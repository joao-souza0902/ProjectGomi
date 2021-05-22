/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gomi.front.Controllers;

import br.com.gomi.business.Dados;
import br.com.gomi.business.RandomPasswordGenerator;
import br.com.gomi.business.Validacao;
import java.io.IOException;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrador
 */
public class RecuperacaoDeSenhaController extends PadraoController
{

    @FXML
    private TextField emailTextField;

    public void btnRecuperarOnClick(ActionEvent event) throws IOException, SQLException, Exception
    {
        //Chamar o banco para verificar existência de E-mail
        if (Validacao.usuarioExiste(emailTextField.getText()))
        {
            String senha = RandomPasswordGenerator.geraSenha();
            String nome = Dados.atualizaSenhaUsuario(emailTextField.getText(), senha);
            RandomPasswordGenerator.enviarEmail(emailTextField.getText(), senha, nome);
        }
        JOptionPane.showMessageDialog(null, "Um email de solicitação foi enviado", "Troca de Senha", JOptionPane.INFORMATION_MESSAGE);
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("/br/com/gomi/front/Login.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }
    
    public void btnVoltarOnClick(ActionEvent event) throws IOException
    {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("/br/com/gomi/front/Login.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }
}

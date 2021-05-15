/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gomi.front.Controllers;

import br.com.gomi.business.Validacao;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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
public class RecuperacaoDeSenhaController implements Initializable
{

    @FXML
    private TextField emailTextField;

    public void btnRecuperarOnClick(ActionEvent event) throws IOException, SQLException
    {
        //Chamar o banco para verificar existência de E-mail
        JOptionPane.showMessageDialog(null, "Um email de solicitação foi enviado", "Troca de Senha", JOptionPane.INFORMATION_MESSAGE);
        if (Validacao.usuarioExiste(emailTextField.getText()))
        {
            //Envia email e chama tela de login de novo
        }
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        
    }
}

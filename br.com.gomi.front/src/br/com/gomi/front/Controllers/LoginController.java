/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gomi.front.Controllers;

import br.com.gomi.business.*;
import br.com.gomi.shared.UsuarioAtual;
import ch.qos.logback.core.joran.conditional.ElseAction;
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
public class LoginController extends PadraoController
{

    @FXML
    private TextField loginTextField;
    @FXML
    private TextField senhaTextField;

    public void btnLoginOnClick(ActionEvent event) throws Exception
    {
        try
        {
            if (Validacao.validaLogin(loginTextField.getText(), senhaTextField.getText()))
            {
                char tipo = Validacao.validaTipoLogin(loginTextField.getText());
                if (tipo == 'X')
                {
                    String[] escolhas =
                    {
                        "Cliente", "Motorista"
                    };
                    int indice = JOptionPane.showOptionDialog(null, "Com qual tipo de usuário deseja fazer login?", "Usuário Cruzado", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, escolhas, null);
                    if (indice == 0)
                    {
                        tipo = 'C';
                    } else if (indice == 1)
                    {
                        tipo = 'M';
                    } else
                    {
                        return;
                    }

                }
                if (tipo == 'C')
                {
                    UsuarioAtual.getInstancia().setUsuario(Dados.recuperaCliente(loginTextField.getText()));
                    Parent parent = FXMLLoader.load(getClass().getResource("/br/com/gomi/front/PaginaPrincipalC.fxml"));
                    Scene scene = new Scene(parent);
                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    stage.setScene(scene);
                    stage.show();
                } else if (tipo == 'M')
                {
                    UsuarioAtual.getInstancia().setUsuario(Dados.recuperaMotorista(loginTextField.getText()));
                    Parent parent = FXMLLoader.load(getClass().getResource("/br/com/gomi/front/PaginaPrincipalM.fxml"));
                    Scene scene = new Scene(parent);
                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    stage.setScene(scene);
                    stage.show();
                } else
                {
                    //Tela de administrador
                }
            }
        } catch (Exception erro)
        {
            JOptionPane.showMessageDialog(null, erro.getMessage(), "Erro de Login", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void btnCadastrarOnClick(ActionEvent event) throws IOException
    {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("/br/com/gomi/front/CadastroCM.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }

    public void lnkEsqueceuSenhaOnClick(ActionEvent event) throws IOException
    {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("RecuperacaoDeSenha.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }

    public void imgSobreOnClick(ActionEvent event) throws IOException
    {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("Sobre.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }
}

////hh
///hh

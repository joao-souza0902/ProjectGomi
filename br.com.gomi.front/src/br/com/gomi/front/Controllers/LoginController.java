/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gomi.front.Controllers;
import br.com.gomi.business.*;
import br.com.gomi.shared.UsuarioViewModel;
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

/**
 *
 * @author Administrador
 */
public class LoginController
{
    @FXML
    private TextField loginTextField;
    private TextField senhaTextField;
    
    public void btnLoginOnClick(ActionEvent event) throws IOException, SQLException 
    {
        
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        
        if (Validacao.validaLogin(loginTextField.getText(), senhaTextField.getText()))
            app_stage.show();
        else
            System.out.println("Login Inválido!");
    }
    
    public void btnCadastrarOnClick (ActionEvent event) throws IOException {
        
        Parent sign_up_parent = FXMLLoader.load(getClass().getResource("Sign Up.fxml"));
        Scene sign_up_scene = new Scene(sign_up_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(sign_up_scene);
        app_stage.show();
    }
    
    public void imgSobreOnClick (ActionEvent event) throws IOException {
        
        Parent sign_up_parent = FXMLLoader.load(getClass().getResource("Sobre.fxml"));
        Scene sign_up_scene = new Scene(sign_up_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(sign_up_scene);
        app_stage.show();
    }
    
    public void lnkEsqueceuSenhaOnClick (ActionEvent event) throws IOException {
        
        Parent sign_up_parent = FXMLLoader.load(getClass().getResource("EsqueceuSenha.fxml"));
        Scene sign_up_scene = new Scene(sign_up_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(sign_up_scene);
        app_stage.show();
    }
}

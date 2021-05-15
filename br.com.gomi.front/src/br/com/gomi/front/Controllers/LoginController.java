/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gomi.front.Controllers;
import br.com.gomi.business.*;
import br.com.gomi.shared.UsuarioViewModel;
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
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Administrador
 */
public class LoginController implements Initializable
{
    @FXML
    private TextField loginTextField;
    @FXML
    private TextField senhaTextField;
    
    public void btnLoginOnClick(ActionEvent event) throws IOException, SQLException 
    {
        
        if (Validacao.validaLogin("abc@123.com", "123456")){//if (Validacao.validaLogin(loginTextField.getText(), senhaTextField.getText())){
            System.out.println("YeahBaby");
        /*    Parent home_page_parent = FXMLLoader.load(getClass().getResource("PaginaInicial.fxml"));
            Scene home_page_scene = new Scene(home_page_parent);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app_stage.setScene(home_page_scene);
            app_stage.show();*/
        }
        else
            System.out.println("Login Inválido!");
    }
    
    public void btnCadastrarOnClick(ActionEvent event) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("Sign Up.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }
    
    public void lnkEsqueceuSenhaOnClick(ActionEvent event) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("RecuperacaoDeSenha.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }
    
    public void imgSobreOnClick(ActionEvent event) throws IOException{
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("Sobre.fxml"));
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

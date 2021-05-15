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
public class SolicitacaoController implements Initializable
{
    @FXML
    private TextField loginTextField;
    private TextField senhaTextField;
    
    public void btnSolicitarOnClick (ActionEvent event) throws IOException, SQLException 
    {
        
        if (Validacao.validaLogin(loginTextField.getText(), senhaTextField.getText())){
            Parent home_page_parent = FXMLLoader.load(getClass().getResource("MotoristaEncontrado.fxml"));
            Scene home_page_scene = new Scene(home_page_parent);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app_stage.setScene(home_page_scene);
            app_stage.show();
        }
        else
            System.out.println("Login Inválido!");
    }
    
    public void btnVoltarOnClick(ActionEvent event) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("/br/com/gomi/front/PaginaPrincipalC.fxml"));
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
    
    public void btnCloseClick (ActionEvent event) throws IOException{
       System.exit(0);
    } 
    
    public void btnMinOnClick (ActionEvent event) throws IOException{
        System.exit(0);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) 
    {
        
    }
}

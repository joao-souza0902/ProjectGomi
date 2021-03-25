/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gomi.front;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;


/**
 *
 * @author jonyg
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Parent fxml;
    private Label label;

    
    
    public void handledButtonAction(ActionEvent event) throws IOException {
        System.out.println("A");
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }
    
    public void handledButtonAction1(ActionEvent event) throws IOException {
        System.out.println("A");
        Parent sign_up_parent = FXMLLoader.load(getClass().getResource("Sign Up.fxml"));
        Scene sign_up_scene = new Scene(sign_up_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(sign_up_scene);
        app_stage.show();
    }
    
    public void btnSobreClick(ActionEvent event) throws IOException {
        System.out.println("A");
        Parent Sobre_parent = FXMLLoader.load(getClass().getResource("Sobre.fxml"));
        Scene Sobre_scene = new Scene(Sobre_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(Sobre_scene);
        app_stage.show();
    }
    
    public void btnHelpClick(ActionEvent event) throws IOException {
        System.out.println("A");
        Parent Help_parent = FXMLLoader.load(getClass().getResource("Help.fxml"));
        Scene Help_scene = new Scene(Help_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(Help_scene);
        app_stage.show();
    }
    
    public void btnPagUsuario(ActionEvent event) throws IOException {
        System.out.println("A");
        Parent pag_user_parent = FXMLLoader.load(getClass().getResource("PagUsuario.fxml"));
        Scene pag_user_scene = new Scene(pag_user_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(pag_user_scene);
        app_stage.show();
    }
    
    public void btnHome(ActionEvent event) throws IOException {
        System.out.println("A");
        Parent Home_parent = FXMLLoader.load(getClass().getResource("Homepage.fxml"));
        Scene Home_scene = new Scene(Home_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(Home_scene);
        app_stage.show();
    }
    
    public void btnAdicionarSaldo(ActionEvent event) throws IOException {
        System.out.println("A");
        Parent add_saldo_parent = FXMLLoader.load(getClass().getResource("AdicionarSaldo.fxml"));
        Scene add_saldo_scene = new Scene(add_saldo_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(add_saldo_scene);
        app_stage.show();
    }
    
    public void handlerVoltarLogin(ActionEvent event) throws IOException {
        System.out.println("A");
        Parent add_voltar_login_parent = FXMLLoader.load(getClass().getResource("Log In.fxml"));
        Scene add_voltar_login_scene = new Scene(add_voltar_login_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(add_voltar_login_scene);
        app_stage.show();
    }
    
     public void btnSolicitarColeta(ActionEvent event) throws IOException {
         System.out.println("A");
        Parent add_solicitar_parent = FXMLLoader.load(getClass().getResource("Solicitação.fxml"));
        Scene add_solicitar_scene = new Scene(add_solicitar_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(add_solicitar_scene);
        app_stage.show();
    }
    
    public void btnAgendarColeta(ActionEvent event) throws IOException {
        System.out.println("A");
        Parent add_agendar_parent = FXMLLoader.load(getClass().getResource("Log In.fxml"));
        Scene add_agendar_scene = new Scene(add_agendar_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(add_agendar_scene);
        app_stage.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }

}

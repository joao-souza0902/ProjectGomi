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
    
    public void handledButtonMotorista(ActionEvent event) throws IOException {
        System.out.println("A");
        Parent home_page_motorista_parent = FXMLLoader.load(getClass().getResource("HomePageFuncionario.fxml"));
        Scene home_page_motorista_scene = new Scene(home_page_motorista_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_motorista_scene);
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
    
     public void btnClickSolicitar(ActionEvent event) throws IOException {
         System.out.println("A");
        Parent add_solicitar_parent = FXMLLoader.load(getClass().getResource("Solicitação.fxml"));
        Scene add_solicitar_scene = new Scene(add_solicitar_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(add_solicitar_scene);
        app_stage.show();
    }
    
    public void btnClickAgendar(ActionEvent event) throws IOException {
        System.out.println("A");
        Parent add_agendar_parent = FXMLLoader.load(getClass().getResource("Agendamento.fxml"));
        Scene add_agendar_scene = new Scene(add_agendar_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(add_agendar_scene);
        app_stage.show();
    }
    
    public void btnClickReturnLogin(ActionEvent event) throws IOException {
        System.out.println("A");
        Parent return_login_parent = FXMLLoader.load(getClass().getResource("Log In.fxml"));
        Scene return_login_scene = new Scene(return_login_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(return_login_scene);
        app_stage.show();
    } 
    
    public void btnfazerCadastro(ActionEvent event) throws IOException {
        System.out.println("A");
        Parent fazer_cadastro_parent = FXMLLoader.load(getClass().getResource("Log In.fxml"));
        Scene fazer_cadastro_scene = new Scene(fazer_cadastro_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(fazer_cadastro_scene);
        app_stage.show();
    } 
    
    public void btnClickMoveis(ActionEvent event) throws IOException {
        System.out.println("A");
        Parent moveis_parent = FXMLLoader.load(getClass().getResource("ObservaçõesAdicionais.fxml"));
        Scene moveis_scene = new Scene(moveis_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(moveis_scene);
        app_stage.show();
    }
    
    public void btnClickReciclavel(ActionEvent event) throws IOException {
        System.out.println("A");
        Parent reciclaveis_parent = FXMLLoader.load(getClass().getResource("ObservaçõesAdicionais.fxml"));
        Scene reciclaveis_scene = new Scene(reciclaveis_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(reciclaveis_scene);
        app_stage.show();
    }
    
    public void btnClickEletrodomestico(ActionEvent event) throws IOException {
        System.out.println("A");
        Parent eletrodomesticos_parent = FXMLLoader.load(getClass().getResource("ObservaçõesAdicionais.fxml"));
        Scene eletrodomesticos_scene = new Scene(eletrodomesticos_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(eletrodomesticos_scene);
        app_stage.show();
    }
    
    public void btnClickEntulho(ActionEvent event) throws IOException {
        System.out.println("A");
        Parent entulho_parent = FXMLLoader.load(getClass().getResource("ObservaçõesAdicionais.fxml"));
        Scene entulho_scene = new Scene(entulho_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(entulho_scene);
        app_stage.show();
    }
    
    public void btnVoltarMenu(ActionEvent event) throws IOException {
        System.out.println("A");
        Parent voltar_menu_parent = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        Scene voltar_menu_scene = new Scene(voltar_menu_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(voltar_menu_scene);
        app_stage.show();
    } 
    
    public void btnClickVoltar(ActionEvent event) throws IOException {
        System.out.println("A");
        Parent voltar_parent = FXMLLoader.load(getClass().getResource("Solicitação.fxml"));
        Scene voltar_scene = new Scene(voltar_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(voltar_scene);
        app_stage.show();
    } 
      
    public void btnClickProximo(ActionEvent event) throws IOException {
        System.out.println("A");
        Parent proximo_parent = FXMLLoader.load(getClass().getResource("TelaConfirmacao.fxml"));
        Scene proximo_scene = new Scene(proximo_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(proximo_scene);
        app_stage.show();
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }

}

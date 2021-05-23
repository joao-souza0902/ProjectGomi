/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gomi.front.Controllers;

import br.com.gomi.shared.UsuarioAtual;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author jonyg
 */
public class PrincipalCController extends PadraoController {

    //O cliente solicita a coleta com esse método
    public void btnSolicitarColetaOnClick(ActionEvent event) throws IOException {
        NovaColetaController novaColeta = new NovaColetaController();
        novaColeta.exibir(event);
    }

    //O cliente altera seus dados cadastrais com esse método
    public void btnAlterarDadosOnClick(ActionEvent event) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("PaginaMotorista.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }

    //O cliente visualiza o histórico de colétas 
    public void btnHistoricoOnClick(ActionEvent event) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("PaginaHistorico.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }

    //O cliente sai de seu usuario
    public void btnSairOnClick(ActionEvent event) throws IOException {
        UsuarioAtual.getInstancia().logoff();
        LoginController login = new LoginController();
        login.exibir(event);
    }
    
    @Override
    public void exibir(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/br/com/gomi/front/PrincipalC.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}

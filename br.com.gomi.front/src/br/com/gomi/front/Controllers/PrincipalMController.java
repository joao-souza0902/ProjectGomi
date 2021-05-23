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
 * @author Administrador
 */
public class PrincipalMController extends PadraoController {

    //Tela para alterar dados cadastrais do motorista
    public void btnAlterarDadosOnClick(ActionEvent event) {

    }

    //Tela para mostrar o histórico de coletas feitas pelo motorista
    public void btnHistoricoOnClick(ActionEvent event) {

    }

    //Botão para sair do usuario
    public void btnSairOnClick(ActionEvent event) throws IOException {
        UsuarioAtual.getInstancia().logoff();
        LoginController login = new LoginController();
        login.exibir(event);
    }

    @Override
    public void exibir(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/br/com/gomi/front/PrincipalM.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}

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
public class MotoristaController extends PadraoController
{
    public void btnAlterarDadosOnClick(ActionEvent event){
        
    }
    public void btnHistoricoOnClick(ActionEvent event){
        
    }
    public void btnSairOnClick(ActionEvent event) throws IOException{
        UsuarioAtual.getInstancia().logoff();
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("/br/com/gomi/front/Login.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }
}

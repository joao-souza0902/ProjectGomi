/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gomi.front.Controllers;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 *
 * @author Fábio
 */
public class AtenderSolicitacaoController extends PadraoController{

    public void btnConfirmarOnClick(ActionEvent event){
        
    }
    
    public void btnCancelarOnClick(ActionEvent event){
        
    }
    
    //Acessa a tela de atender solicitação
    @Override
    public void start(Stage stage) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("/br/com/gomi/front/AtenderSolicitacao.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        
        home_page_parent.setOnMousePressed (new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event){
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });
        
        home_page_parent.setOnMouseDragged(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event){
                stage.setX(event.getScreenX() - xOffset);
                stage.setY(event.getScreenY() - yOffset);
            }
        });
        
        stage.setScene(home_page_scene);
        stage.show();
    }
    
}

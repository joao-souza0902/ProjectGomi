/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gomi.front.Controllers;

import javafx.geometry.Insets;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Fábio
 */
//Os métodos abaixo denominam funções padrões de todas as telas (Fechar e minimizar) 
public abstract class PadraoController extends Application implements Initializable {
    
    //public abstract void exibir(Stage stage) throws IOException;
    
    public double xOffset = 0, yOffset = 0;
    
    public void btnCloseClick (ActionEvent event) throws IOException{
       System.exit(0);
    }
    
    public void btnMinClick (ActionEvent event) throws IOException{
        ((Stage)((Button)event.getSource()).getScene().getWindow()).setIconified(true);
    }
       
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    
}

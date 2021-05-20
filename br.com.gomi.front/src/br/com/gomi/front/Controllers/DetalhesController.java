/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gomi.front.Controllers;

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
public class DetalhesController {
    
     public void btnAceitarOnClick(ActionEvent event) throws IOException
    {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("/br/com/gomi/front/AtenderSolicitacao.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }
     
      public void btnRecusarOnClick(ActionEvent event) throws IOException
    {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("/br/com/gomi/front/PaginaPrincipalM.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }
       
        public void btnVoltarOnClick(ActionEvent event) throws IOException
    {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("/br/com/gomi/front/TelaAguardoEbuscaSolicitacao.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }
}
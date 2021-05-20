/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gomi.front;

import br.com.gomi.business.Auditoria;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author jonyg
 */
public class BrComGomiFront extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("Login.fxml"));
        
        stage.initStyle(StageStyle.TRANSPARENT); //testar se o fundo vai ficar transparente
        Parent root = loader.load();        
        stage.setScene(new Scene(root));
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Auditoria.obtemInstancia().iniciar();
        launch(args);
        Auditoria.obtemInstancia().finalizar();
    }
    
}

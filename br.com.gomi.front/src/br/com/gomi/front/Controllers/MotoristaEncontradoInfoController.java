/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gomi.front.Controllers;

import br.com.gomi.business.Validacao;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Fábio
 */
public class MotoristaEncontradoInfoController extends PadraoController{

    @FXML
    TextField txtNomeMotorista;
    @FXML
    TextField txtCarroMotorista;
    @FXML
    TextField txtTempoChegadaMotorista;
    
    public void btnCancelarOnClick(ActionEvent event){
        //Cancelar
    }
        
    @Override
    public void initialize(URL url, ResourceBundle rb){
        txtNomeMotorista.setText(Global.obtemInstancia().motorista.getNome());
        txtCarroMotorista.setText(Global.obtemInstancia().motorista.getTipoVeiculo());
        txtTempoChegadaMotorista.setText(Validacao.getTempoChegada(Global.obtemInstancia().solicitacao.getOrigem(), Global.obtemInstancia().solicitacao.getCep()));
    }
    
    @Override
    public void exibir(ActionEvent event) {
        try {
            Parent home_page_parent = FXMLLoader.load(getClass().getResource("/br/com/gomi/front/MotoristaEncontradoInfo.fxml"));
            Scene home_page_scene = new Scene(home_page_parent);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app_stage.setScene(home_page_scene);
            app_stage.show();
        } catch (IOException ex) {
            Logger.getLogger(MotoristaEncontradoInfoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

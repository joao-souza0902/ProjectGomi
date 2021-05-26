/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gomi.front.Controllers;

import br.com.gomi.business.Dados;
import br.com.gomi.shared.SolicitacaoViewModel;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 *
 * @author Administrador
 */
public class BuscandoMotoristaController extends PadraoController {

    @FXML
    Label labelBuscaMotorista;
    @FXML
    Label labelDots;
    @FXML
    Button btnBuscar;
    
    
    public void btnBuscarOnClick(ActionEvent event) throws IOException {
        btnBuscar.setVisible(false);
        labelBuscaMotorista.setVisible(true);
        labelDots.setVisible(true);
        int idSolicitacao = Global.obtemInstancia().solicitacao.getId();
        MotoristaEncontradoInfoController encontrado = new MotoristaEncontradoInfoController();

        Task task = new Task<Void>() {
            @Override
            public Void call() throws Exception {
                boolean ativo = true;
                while (ativo) {
                    SolicitacaoViewModel model = Dados.recuperaSolicitacao(idSolicitacao);
                    if (model.getIdMotorista() != null) {
                        Global.obtemInstancia().motorista = Dados.recuperaMotorista(model.getIdMotorista());
                        Global.obtemInstancia().solicitacao = model;
                        ativo = false;
                    }
                    Thread.sleep(2000);
                }
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        ChangeScene(event, encontrado);
                    }
                });
                return null;
            }
        };
        Thread th = new Thread(task);
        th.setDaemon(true);
        th.start();
    }

    
    public void btnVoltarOnClick(ActionEvent event) throws Exception {
        NovaColetaController novaColeta = new NovaColetaController();
        novaColeta.exibir(event);
        SolicitacaoViewModel solicitacao = Global.obtemInstancia().solicitacao;
        Global.obtemInstancia().solicitacao = null;
        solicitacao.setAberto(false);
        Dados.atualizaSolicitacao(solicitacao);
    }

    public void ChangeScene(ActionEvent event, MotoristaEncontradoInfoController encontrado) {
        encontrado.exibir(event);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        labelBuscaMotorista.setVisible(false);
        labelDots.setVisible(false);
    }

    @Override
    public void exibir(ActionEvent event) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("/br/com/gomi/front/BuscandoMotorista.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }
}

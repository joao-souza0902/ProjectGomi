/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gomi.front.Controllers;

import br.com.gomi.business.Dados;
import br.com.gomi.shared.MotoristaViewModel;
import br.com.gomi.shared.SolicitacaoViewModel;
import br.com.gomi.shared.UsuarioAtual;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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
 * @author jonyg
 */
public class DetalhesPedidoController extends PadraoController {

    @FXML
    TextField txtEndereco;
    @FXML
    TextField txtDescricao;
    
    public void btnAceitarOnClick(ActionEvent event) throws IOException, Exception {                
        Global.obtemInstancia().solicitacao.setIdMotorista(((MotoristaViewModel) UsuarioAtual.getInstancia().getUsuario()).getIdMotorista());
        Dados.atualizaSolicitacao(Global.obtemInstancia().solicitacao);
        AtenderSolicitacaoController atender = new AtenderSolicitacaoController();
        atender.exibir(event);
    }

    public void btnRecusarOnClick(ActionEvent event) throws IOException {
        PrincipalMController principal = new PrincipalMController();
        Global.obtemInstancia().solicitacao = null;
        principal.exibir(event);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        SolicitacaoViewModel solicitacao = new SolicitacaoViewModel();
        solicitacao = Global.obtemInstancia().solicitacao;
        txtEndereco.setText(solicitacao.getCep() + ", Nº" + solicitacao.getNumero());
        txtDescricao.setText(solicitacao.getDescricao());
    }

    @Override
    public void exibir(ActionEvent event) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("/br/com/gomi/front/DetalhesPedido.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }
}

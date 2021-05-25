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
import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrador
 */
public class PrincipalMController extends PadraoController {

    @FXML
    CheckBox disponivelRadioButton;
    
    public void disponivelRadioButtonOnToggle(ActionEvent event) throws Exception{
        if(disponivelRadioButton.isSelected()){
            List<SolicitacaoViewModel> solicitacoes = Dados.recuperaSolicitacoes();
            if(solicitacoes.isEmpty()){
                JOptionPane.showMessageDialog(null, "Não há coletas disponiveis", "Erro de Busca", JOptionPane.INFORMATION_MESSAGE);
                disponivelRadioButton.setSelected(false);
            }else{
                SolicitacaoViewModel solicitacao = solicitacoes.get(0);
                Global.obtemInstancia().solicitacao = solicitacao;
                DetalhesPedidoController detalhes = new DetalhesPedidoController();
                detalhes.exibir(event);
            }
        }
        else{
            disponivelRadioButton.setSelected(false);
        }
    }
    
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

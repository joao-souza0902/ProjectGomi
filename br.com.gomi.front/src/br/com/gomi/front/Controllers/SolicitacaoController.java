/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gomi.front.Controllers;
import br.com.gomi.business.Dados;
import br.com.gomi.business.Validacao;
import br.com.gomi.shared.*;
import java.io.IOException;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrador
 */
public class SolicitacaoController extends PadraoController
{
    @FXML
    TextField descricaoTextField;
    @FXML
    CheckBox checkLixoReciclaveis;
    @FXML
    CheckBox checkEletrodomesticos;
    @FXML
    CheckBox checkMoveis;
    @FXML
    CheckBox checkEntulho;
    @FXML
    CheckBox checkLixoEletronico;
    
    public void btnContinuarOnClick (ActionEvent event) throws IOException, SQLException 
    {
        try {
            Validacao.validaSolicitacao(descricaoTextField.getText());
            
            SolicitacaoViewModel solicitacao = new SolicitacaoViewModel();
            ClienteViewModel cliente = (ClienteViewModel) UsuarioAtual.getInstancia().getUsuario();
            solicitacao.setIdCliente(cliente.getIdCliente()); 
            solicitacao.setCep(cliente.getCep());
            solicitacao.setNumero(cliente.getNumero());
            solicitacao.setDescricao(descricaoTextField.getText());
            //adicionar categorias na lista
            Dados.insereSolicitacao(solicitacao);
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage(), "Erro de Cadastro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void btnVoltarOnClick(ActionEvent event) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("/br/com/gomi/front/PaginaPrincipalC.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }
    
    public void btnFotoColetaOnClick (ActionEvent event) throws IOException{
        
    }
}

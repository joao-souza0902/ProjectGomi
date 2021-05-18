/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gomi.front.Controllers;

import br.com.gomi.business.Dados;
import br.com.gomi.business.Validacao;
import br.com.gomi.shared.ClienteViewModel;
import br.com.gomi.shared.MotoristaViewModel;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrador
 */
public class CadastrarController extends PadraoController
{
    private static boolean ehCliente;
    @FXML
    TextField emailTextField;
    @FXML
    TextField nomeTextField;
    @FXML
    TextField telefoneTextField;
    @FXML 
    TextField cpfTextField;
    @FXML
    TextField dataNascimentoTextField;
    @FXML
    TextField senhaTextField;
    @FXML
    TextField confirmacaoSenhaTextField;
    @FXML
    TextField cepTextField;
    @FXML
    TextField numeroTextField;
    @FXML
    TextField ruaTextField;
    @FXML
    TextField complementoTextField;
    @FXML
    TextField bairroTextField;
    @FXML
    TextField cidadeTextField;
    @FXML
    TextField tipoVeiculoTextField;
    @FXML
    TextField cnhTextfield;
    @FXML
    TextField dataExpiracaoTextField;
    @FXML
    TextField cnhCategoriaTextField;
    @FXML
    TextField cargaSuportadaTextField;
    @FXML
    RadioButton clienteRadioButton;
    @FXML
    RadioButton motoristaRadioButton;
    @FXML
    Label cepLabel;
    @FXML
    Label numeroLabel;
    @FXML 
    Label ruaLabel;
    @FXML
    Label complementoLabel;
    @FXML
    Label bairroLabel;
    @FXML
    Label cidadeLabel;
    @FXML
    Label tipoVeiculoLabel;
    @FXML
    Label numCnhLabel;
    @FXML
    Label dataExpLabel;
    @FXML
    Label cnhCategoriaLabel;
    @FXML
    Label cargaLabel;
    
    //verificar como colocar foto
    //verificar como colocar método de pagamento
    
    public void btnCadastrarOnClick(ActionEvent event) throws IOException, SQLException, Exception{        
        try{
            Validacao.validaCadastro(emailTextField.getText(), nomeTextField.getText(), telefoneTextField.getText(), cpfTextField.getText(), dataNascimentoTextField.getText(),
                    senhaTextField.getText(), confirmacaoSenhaTextField.getText(), ehCliente, cepTextField.getText(), numeroTextField.getText(), ruaTextField.getText(),
                    bairroTextField.getText(), cidadeTextField.getText(), tipoVeiculoTextField.getText(), cnhCategoriaTextField.getText(), dataExpiracaoTextField.getText(),
                    cnhCategoriaTextField.getText(), cargaSuportadaTextField.getText());
            
            if(ehCliente){
                ClienteViewModel cliente = new ClienteViewModel();
                cliente.setEmail(emailTextField.getText());
                cliente.setNome(nomeTextField.getText());
                cliente.setTelefoneddd(Integer.parseInt(telefoneTextField.getText().substring(1, 3)));
                cliente.setTelefone(Integer.parseInt(telefoneTextField.getText().substring(4)));
                cliente.setCpf(cpfTextField.getText());
                cliente.setData(LocalDate.parse(dataNascimentoTextField.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                cliente.setSenha(senhaTextField.getText());
                cliente.setCep(cepTextField.getText());
                cliente.setNumero(Integer.parseInt(numeroTextField.getText()));
                cliente.setRua(ruaTextField.getText());
                cliente.setComplemento(complementoTextField.getText());
                cliente.setBairro(bairroTextField.getText());
                cliente.setCidade(cidadeTextField.getText());
                cliente.setIdCliente(Dados.insereCliente(cliente));
                cliente.setIdNaoAdm(Dados.insereNaoAdm(cliente));
                Dados.insereUsuario(cliente);
            }
            else{
                MotoristaViewModel motorista = new MotoristaViewModel();
                motorista.setEmail(emailTextField.getText());
                motorista.setNome(nomeTextField.getText());
                motorista.setTelefoneddd(Integer.parseInt(telefoneTextField.getText().substring(1, 3)));
                motorista.setTelefone(Integer.parseInt(telefoneTextField.getText().substring(4)));
                motorista.setCpf(cpfTextField.getText());
                motorista.setData(LocalDate.parse(dataNascimentoTextField.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                motorista.setSenha(senhaTextField.getText());
                motorista.setTipoVeiculo(tipoVeiculoTextField.getText());
                motorista.setCnh(cnhTextfield.getText());
                motorista.setDataExpiracao(LocalDate.parse(dataExpiracaoTextField.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                motorista.setCnhCategoria(cnhCategoriaTextField.getText().charAt(0));
                motorista.setCargaSuportada(Integer.parseInt(bairroTextField.getText()));
                motorista.setIdMotorista(Dados.insereMotorista(motorista));
                motorista.setIdNaoAdm(Dados.insereNaoAdm(motorista));
                Dados.insereUsuario(motorista);
            }
        }
        catch (Exception erro){
            JOptionPane.showMessageDialog(null, erro.getMessage(), "Erro de Cadastro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void btnVoltarOnClick(ActionEvent event) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("/br/com/gomi/front/Login.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }
    

    public void rdbClienteOnToggle (ActionEvent event) throws IOException{
        cepTextField.setVisible(true);
        numeroTextField.setVisible(true);
        ruaTextField.setVisible(true);
        complementoTextField.setVisible(true);
        bairroTextField.setVisible(true);
        cidadeTextField.setVisible(true);
        tipoVeiculoTextField.setVisible(false);
        cnhTextfield.setVisible(false);
        dataExpiracaoTextField.setVisible(false);
        cnhCategoriaTextField.setVisible(false);
        cargaSuportadaTextField.setVisible(false);
        cepLabel.setVisible(true);
        numeroLabel.setVisible(true);
        ruaLabel.setVisible(true);
        complementoLabel.setVisible(true);
        bairroLabel.setVisible(true);
        cidadeLabel.setVisible(true);
        tipoVeiculoLabel.setVisible(false);
        numCnhLabel.setVisible(false);
        dataExpLabel.setVisible(false);
        cnhCategoriaLabel.setVisible(false);
        cargaLabel.setVisible(false);
        ehCliente = true;
    }
    
    public void rdbMotoristaOnToggle (ActionEvent event) throws IOException{
        cepTextField.setVisible(false);
        numeroTextField.setVisible(false);
        ruaTextField.setVisible(false);
        complementoTextField.setVisible(false);
        bairroTextField.setVisible(false);
        cidadeTextField.setVisible(false);
        tipoVeiculoTextField.setVisible(true);
        cnhTextfield.setVisible(true);
        dataExpiracaoTextField.setVisible(true);
        cnhCategoriaTextField.setVisible(true);
        cargaSuportadaTextField.setVisible(true);
        cepLabel.setVisible(false);
        numeroLabel.setVisible(false);
        ruaLabel.setVisible(false);
        complementoLabel.setVisible(false);
        bairroLabel.setVisible(false);
        cidadeLabel.setVisible(false);
        tipoVeiculoLabel.setVisible(true);
        numCnhLabel.setVisible(true);
        dataExpLabel.setVisible(true);
        cnhCategoriaLabel.setVisible(true);
        cargaLabel.setVisible(true);
        ehCliente = false;
    }   
    
    @Override @FXML
    public void initialize(URL location, ResourceBundle resources)
    {
        cepTextField.setVisible(false);
        numeroTextField.setVisible(false);
        ruaTextField.setVisible(false);
        complementoTextField.setVisible(false);
        bairroTextField.setVisible(false);
        cidadeTextField.setVisible(false);
        tipoVeiculoTextField.setVisible(false);
        cnhTextfield.setVisible(false);
        dataExpiracaoTextField.setVisible(false);
        cnhCategoriaTextField.setVisible(false);
        cargaSuportadaTextField.setVisible(false);
        cepLabel.setVisible(false);
        numeroLabel.setVisible(false);
        ruaLabel.setVisible(false);
        complementoLabel.setVisible(false);
        bairroLabel.setVisible(false);
        cidadeLabel.setVisible(false);
        tipoVeiculoLabel.setVisible(false);
        numCnhLabel.setVisible(false);
        dataExpLabel.setVisible(false);
        cnhCategoriaLabel.setVisible(false);
        cargaLabel.setVisible(false);
    }
}

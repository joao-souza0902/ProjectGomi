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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Administrador
 */
public class CadastrarController implements Initializable
{
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
    
    //verificar como colocar foto
    //verificar como colocar método de pagamento
    
    public void btnCadastrarOnClick(ActionEvent event) throws IOException, SQLException, Exception{
        boolean erro = false;
        boolean ehCliente = true;
        if(emailTextField.getText().isEmpty()){
            //mensagem de erro ("Error Provider" ou "MessageBox")
            erro = true;
        }
        if(nomeTextField.getText().isEmpty()){
            //mensagem de erro ("Error Provider" ou "MessageBox")
            erro = true;
        }
        if(telefoneTextField.getText().isEmpty()){
            //mensagem de erro ("Error Provider" ou "MessageBox")
            erro = true;
        }
        if(cpfTextField.getText().isEmpty()){
            //mensagem de erro ("Error Provider" ou "MessageBox")
            erro = true;
        }
        if(dataNascimentoTextField.getText().isEmpty()){
            //mensagem de erro ("Error Provider" ou "MessageBox")
            erro = true;
        }
        if(senhaTextField.getText().isEmpty()){
            //mensagem de erro ("Error Provider" ou "MessageBox")
            erro = true;
        }
        if(confirmacaoSenhaTextField.getText().isEmpty()){
            //mensagem de erro ("Error Provider" ou "MessageBox")
            erro = true;
        }
        
        if (emailTextField.getText().indexOf("@") == -1 || emailTextField.getText().lastIndexOf(".") < emailTextField.getText().indexOf("@")){
            //mensagem de erro ("Error Provider" ou "MessageBox")
            erro = true;
        }
        if (Integer.parseInt(telefoneTextField.getText().substring(1, 3)) <= 10 || telefoneTextField.getText().substring(1, 3).indexOf("0") != -1){
            //mensagem de erro ("Error Provider" ou "MessageBox")
            erro = true;
        }
        if (telefoneTextField.getText().substring(4).length() > 9 || telefoneTextField.getText().substring(4).length() < 8 ){
            //mensagem de erro ("Error Provider" ou "MessageBox")
            erro = true;
        }
        if (cpfTextField.getText().length() != 11){
            //mensagem de erro ("Error Provider" ou "MessageBox")
            erro = true;
        }
        if (LocalDate.parse(dataNascimentoTextField.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy")).isAfter(LocalDate.now())){
            //mensagem de erro ("Error Provider" ou "MessageBox")
            erro = true;
        }
        if (senhaTextField.getText().equals( confirmacaoSenhaTextField.getText())){
            //mensagem de erro ("Error Provider" ou "MessageBox")
            erro = true;
        }
        if (ehCliente){
            if (cepTextField.getText().replace("-", "").length() != 8){
                //mensagem de erro ("Error Provider" ou "MessageBox")
                erro = true;
            }
            if (numeroTextField.getText().isEmpty() || Integer.parseInt(numeroTextField.getText()) <= 0){
                //mensagem de erro ("Error Provider" ou "MessageBox")
                erro = true;
            }
            if (ruaTextField.getText().isEmpty()){
                //mensagem de erro ("Error Provider" ou "MessageBox")
                erro = true;
            }
            if (bairroTextField.getText().isEmpty()){
                //mensagem de erro ("Error Provider" ou "MessageBox")
                erro = true;
            }
            if (cidadeTextField.getText().isEmpty()){
                //mensagem de erro ("Error Provider" ou "MessageBox")
                erro = true;
            }
            if (Validacao.usuarioExiste(emailTextField.getText())){
                //mensagem de erro ("Error Provider" ou "MessageBox")
                erro = true;
            }
            if (!erro){
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
                System.out.println("Erro no cadastro de cliente");
            }
        }
        else{
            if (tipoVeiculoTextField.getText().isEmpty()){
                //mensagem de erro ("Error Provider" ou "MessageBox")
                erro = true;
            }
            if (cnhTextfield.getText().isEmpty()){
                //mensagem de erro ("Error Provider" ou "MessageBox")
                erro = true;
            }
            if (dataExpiracaoTextField.getText().isEmpty()){
                //mensagem de erro ("Error Provider" ou "MessageBox")
                erro = true;
            }
            if (LocalDate.parse(dataExpiracaoTextField.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy")).isAfter(LocalDate.now())){
                //mensagem de erro ("Error Provider" ou "MessageBox")
                erro = true;
            }
            if (cnhCategoriaTextField.getText().length() != 1){
                //mensagem de erro ("Error Provider" ou "MessageBox")
                erro = true;
            }
            if (cargaSuportadaTextField.getText().isEmpty() || Integer.parseInt(cargaSuportadaTextField.getText()) <= 0){
                //mensagem de erro ("Error Provider" ou "MessageBox")
                erro = true;
            }
            if (!erro){
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
            else{
                System.out.println("Erro no cadastro de motorista");
            }
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
    }
    
    public void btnCloseClick (ActionEvent event) throws IOException{
       System.exit(0);
    }
    
    public void btnMinClick (ActionEvent event) throws IOException{
        ((Stage)((Button)event.getSource()).getScene().getWindow()).setIconified(true);
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
    }
}

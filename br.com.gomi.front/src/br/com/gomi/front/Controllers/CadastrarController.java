/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gomi.front.Controllers;

import br.com.gomi.business.Dados;
import br.com.gomi.business.Validacao;
import br.com.gomi.shared.ClienteViewModel;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 *
 * @author Administrador
 */
public class CadastrarController
{
    @FXML
    TextField emailTextField;
    TextField nomeTextField;
    TextField telefoneTextField;
    TextField cpfTextField;
    TextField dataNascimentoTextField;
    TextField senhaTextField;
    TextField confirmacaoSenhaTextField;
    TextField cepTextField;
    TextField numeroTextField;
    TextField ruaTextField;
    TextField complementoTextField;
    TextField bairroTextField;
    TextField cidadeTextField;
    //verificar como colocar foto
    //verificar como colocar método de pagamento
    
    public void btnCadstrarOnClick(ActionEvent event) throws IOException, SQLException, Exception{
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
        if (senhaTextField.getText() != confirmacaoSenhaTextField.getText()){
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
        }
        else{
            
        }
    }
}

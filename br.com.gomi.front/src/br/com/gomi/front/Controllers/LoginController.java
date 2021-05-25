/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gomi.front.Controllers;

import br.com.gomi.business.*;
import br.com.gomi.shared.UsuarioAtual;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrador
 */
public class LoginController extends PadraoController {

    @FXML
    private TextField loginTextField;
    @FXML
    private TextField senhaTextField;

    //Login do cliente conforme as iinformações inseridas corretamente
    public void btnLoginOnClick(ActionEvent event) throws Exception {
        try {
            if (Validacao.validaLogin(loginTextField.getText(), senhaTextField.getText())) {
                char tipo = Validacao.validaTipoLogin(loginTextField.getText());
                if (tipo == 'X') {
                    String[] escolhas
                            = {
                                "Cliente", "Motorista"
                            };
                    int indice = JOptionPane.showOptionDialog(null, "Com qual tipo de usuário deseja fazer login?", "Usuário Cruzado", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, escolhas, null);
                    switch (indice) {
                        case 0:
                            tipo = 'C';
                            break;
                        case 1:
                            tipo = 'M';
                            break;
                        default:
                            return;
                    }

                }
                switch (tipo) {
                    case 'C': {
                        UsuarioAtual.getInstancia().setUsuario(Dados.recuperaCliente(loginTextField.getText()));
                        PrincipalCController principal = new PrincipalCController();
                        principal.exibir(event);
                        break;
                    }
                    case 'M': {
                        UsuarioAtual.getInstancia().setUsuario(Dados.recuperaMotorista(loginTextField.getText()));
                        PrincipalMController principal = new PrincipalMController();
                        principal.exibir(event);
                        break;
                    }
                    //Tela de administrador
                    default:
                        break;
                }
            }
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage(), "Erro de Login", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    //Se não possuir usuario, o botão leva para a tela de cadastro
    public void btnCadastrarOnClick(ActionEvent event) throws IOException {
        CadastroController cadastrar = new CadastroController();
        cadastrar.exibir(event);
    }

    //Direcionado a tela caso o usuario esquecer a senha
    public void lnkEsqueceuSenhaOnClick(ActionEvent event) throws IOException {
        RedefinicaoSenhaController redefinicao = new RedefinicaoSenhaController();
        redefinicao.exibir(event);
    }

    //Pagina sobre o programa e os integrantes do grupo
    public void imgSobreOnClick(ActionEvent event) throws IOException {
        
        SobreController sobre = new SobreController();
        sobre.exibir(event);
    }

    @Override
    public void exibir(ActionEvent event) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("/br/com/gomi/front/Login.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }
}

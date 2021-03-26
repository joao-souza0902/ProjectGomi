/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gomi.front;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;


/**
 *
 * @author jonyg
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Parent fxml;
    private Label label;

    
    //Pagina login cliente
    public void handledButtonAction(ActionEvent event) throws IOException {
        
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }
    
    //cadastro usuario
    public void handledButtonAction1(ActionEvent event) throws IOException {
        
        Parent sign_up_parent = FXMLLoader.load(getClass().getResource("Sign Up.fxml"));
        Scene sign_up_scene = new Scene(sign_up_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(sign_up_scene);
        app_stage.show();
    }
    
    // Login no motorista
    public void handledButtonMotorista(ActionEvent event) throws IOException {
        
        Parent home_page_motorista_parent = FXMLLoader.load(getClass().getResource("HomePageFuncionario.fxml"));
        Scene home_page_motorista_scene = new Scene(home_page_motorista_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_motorista_scene);
        app_stage.show();
    }
    
    //Abre tela sobre
    public void btnSobreClick(ActionEvent event) throws IOException {
        
        Parent Sobre_parent = FXMLLoader.load(getClass().getResource("Sobre.fxml"));
        Scene Sobre_scene = new Scene(Sobre_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(Sobre_scene);
        app_stage.show();
    }
    
    //Abre tela help
    public void btnHelpClick(ActionEvent event) throws IOException {
        
        Parent Help_parent = FXMLLoader.load(getClass().getResource("Help.fxml"));
        Scene Help_scene = new Scene(Help_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(Help_scene);
        app_stage.show();
    }
    
    //Pagina do cliente
    public void btnPagUsuario(ActionEvent event) throws IOException {
        
        Parent pag_user_parent = FXMLLoader.load(getClass().getResource("PaginaUser.fxml"));
        Scene pag_user_scene = new Scene(pag_user_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(pag_user_scene);
        app_stage.show();
    }
    
    //Pagina do motorista
    public void btnPaginaMotorista(ActionEvent event) throws IOException {
        
        Parent pag_moto_parent = FXMLLoader.load(getClass().getResource("PaginaMotorista.fxml"));
        Scene pag_moto_scene = new Scene(pag_moto_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(pag_moto_scene);
        app_stage.show();
    }
    
    //Pagina Home do cliente
    public void btnHome(ActionEvent event) throws IOException {
        
        Parent Home_parent = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        Scene Home_scene = new Scene(Home_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(Home_scene);
        app_stage.show();
    }
    
    //Adicionar saldo em sua conta (aind em planejamento)
    public void btnAdicionarSaldo(ActionEvent event) throws IOException {
        
        Parent add_saldo_parent = FXMLLoader.load(getClass().getResource("AdicionarSaldo.fxml"));
        Scene add_saldo_scene = new Scene(add_saldo_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(add_saldo_scene);
        app_stage.show();
    }
    //Volta da tela de cadastro ao login
    public void handlerVoltarLogin(ActionEvent event) throws IOException {
        
        Parent add_voltar_login_parent = FXMLLoader.load(getClass().getResource("Log In.fxml"));
        Scene add_voltar_login_scene = new Scene(add_voltar_login_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(add_voltar_login_scene);
        app_stage.show();
    }
    
    //Abre uma solicitação de coleta
     public void btnClickSolicitar(ActionEvent event) throws IOException {
        
        Parent add_solicitar_parent = FXMLLoader.load(getClass().getResource("Solicitação.fxml"));
        Scene add_solicitar_scene = new Scene(add_solicitar_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(add_solicitar_scene);
        app_stage.show();
    }
    
     //Abre um agendamento
    public void btnClickAgendar(ActionEvent event) throws IOException {
        
        Parent add_agendar_solicitar_parent = FXMLLoader.load(getClass().getResource("Solicitação.fxml"));
        Scene add_agendar_solicitar_scene = new Scene(add_agendar_solicitar_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(add_agendar_solicitar_scene);
        app_stage.show();
    }
    
    
    public void btnClickReturnLogin(ActionEvent event) throws IOException {
        
        Parent return_login_parent = FXMLLoader.load(getClass().getResource("Log In.fxml"));
        Scene return_login_scene = new Scene(return_login_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(return_login_scene);
        app_stage.show();
    } 
    
    public void btnfazerCadastro(ActionEvent event) throws IOException {
        
        Parent fazer_cadastro_parent = FXMLLoader.load(getClass().getResource("Log In.fxml"));
        Scene fazer_cadastro_scene = new Scene(fazer_cadastro_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(fazer_cadastro_scene);
        app_stage.show();
    } 
    
    public void btnClickMoveis(ActionEvent event) throws IOException {
        
        Parent moveis_parent = FXMLLoader.load(getClass().getResource("ObservaçõesAdicionais.fxml"));
        Scene moveis_scene = new Scene(moveis_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(moveis_scene);
        app_stage.show();
    }
    
    public void btnClickReciclavel(ActionEvent event) throws IOException {
        
        Parent reciclaveis_parent = FXMLLoader.load(getClass().getResource("ObservaçõesAdicionais.fxml"));
        Scene reciclaveis_scene = new Scene(reciclaveis_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(reciclaveis_scene);
        app_stage.show();
    }
    
    public void btnClickEletrodomestico(ActionEvent event) throws IOException {
        
        Parent eletrodomesticos_parent = FXMLLoader.load(getClass().getResource("ObservaçõesFinaisAgendamento.fxml"));
        Scene eletrodomesticos_scene = new Scene(eletrodomesticos_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(eletrodomesticos_scene);
        app_stage.show();
    }
    
    public void btnClickEntulho(ActionEvent event) throws IOException {
        
        Parent entulho_parent = FXMLLoader.load(getClass().getResource("ObservaçõesAdicionais.fxml"));
        Scene entulho_scene = new Scene(entulho_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(entulho_scene);
        app_stage.show();
    }
    
    public void btnVoltarMenu(ActionEvent event) throws IOException {
        
        Parent voltar_menu_parent = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        Scene voltar_menu_scene = new Scene(voltar_menu_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(voltar_menu_scene);
        app_stage.show();
    } 
    
    public void btnClickVoltar(ActionEvent event) throws IOException {
        
        Parent voltar_parent = FXMLLoader.load(getClass().getResource("Solicitação.fxml"));
        Scene voltar_scene = new Scene(voltar_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(voltar_scene);
        app_stage.show();
    } 
      
    //Passa para a tela de confirmação
    public void btnClickProximo(ActionEvent event) throws IOException {
        
        Parent proximo_parent = FXMLLoader.load(getClass().getResource("TelaConfirmacao.fxml"));
        Scene proximo_scene = new Scene(proximo_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(proximo_scene);
        app_stage.show();
    }
    
    public void btnClickVoltarInfo(ActionEvent event) throws IOException {
        
        Parent voltar_info_parent = FXMLLoader.load(getClass().getResource("ObservaçõesAdicionais.fxml"));
        Scene voltar_info_scene = new Scene(voltar_info_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(voltar_info_scene);
        app_stage.show();
    } 
    
    public void btnClickProximoInfo(ActionEvent event) throws IOException {
        
        Parent voltar_info_parent = FXMLLoader.load(getClass().getResource("MotoristaEncontrado.fxml"));
        Scene voltar_info_scene = new Scene(voltar_info_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(voltar_info_scene);
        app_stage.show();
    }
    
    public void btnClickCancelarPedido(ActionEvent event) throws IOException {
        
        Parent cancelar_pedido_parent = FXMLLoader.load(getClass().getResource("CancelarPedido.fxml"));
        Scene cancelar_pedido_scene = new Scene(cancelar_pedido_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(cancelar_pedido_scene);
        app_stage.show();
    }
    
    //Cancela pedido de coleta
    public void btnClickCancelarColeta(ActionEvent event) throws IOException {
        
        Parent cancelar_coleta_parent = FXMLLoader.load(getClass().getResource("ColetaCancelada.fxml"));
        Scene cancelar_coleta_scene = new Scene(cancelar_coleta_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(cancelar_coleta_scene);
        app_stage.show();
    }
    
    
    //Volta para a tela do motorista encontrado das paginas de cancelar pedido (se não cancelar) e sair da sala de chat
    public void btnClickNaoCancelar(ActionEvent event) throws IOException {
        
        Parent cancelar_pedido_parent = FXMLLoader.load(getClass().getResource("MotoristaEncontrado.fxml"));
        Scene cancelar_pedido_scene = new Scene(cancelar_pedido_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(cancelar_pedido_scene);
        app_stage.show();
    }
    
    //Volta ao menu da tela de confirmação de cancelamento
    public void btnClickVoltarMenu(ActionEvent event) throws IOException {
        
        Parent voltar_menu_parent = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        Scene voltar_menu_scene = new Scene(voltar_menu_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(voltar_menu_scene);
        app_stage.show();
    }
    
    public void btnClickChat(ActionEvent event) throws IOException {
        
        Parent chatroom_parent = FXMLLoader.load(getClass().getResource("Chat.fxml"));
        Scene chatroom_scene = new Scene(chatroom_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(chatroom_scene);
        app_stage.show();
    }
    
    public void btnClickPedido1(ActionEvent event) throws IOException {
        
        Parent Pedido1_parent = FXMLLoader.load(getClass().getResource("Mapa.fxml"));
        Scene Pedido1_scene = new Scene(Pedido1_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(Pedido1_scene);
        app_stage.show();
    }
    
    public void btnClickPedido2(ActionEvent event) throws IOException {
        
        Parent Pedido2_parent = FXMLLoader.load(getClass().getResource("Mapa.fxml"));
        Scene Pedido2_scene = new Scene(Pedido2_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(Pedido2_scene);
        app_stage.show();
    }
    
    public void btnClickPedido3(ActionEvent event) throws IOException {
        
        Parent Pedido3_parent = FXMLLoader.load(getClass().getResource("Mapa.fxml"));
        Scene Pedido3_scene = new Scene(Pedido3_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(Pedido3_scene);
        app_stage.show();
    }
    
    public void btnClickPedido4(ActionEvent event) throws IOException {
        
        Parent Pedido4_parent = FXMLLoader.load(getClass().getResource("Mapa.fxml"));
        Scene Pedido4_scene = new Scene(Pedido4_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(Pedido4_scene);
        app_stage.show();
    }
    
    public void btnClickPedido5(ActionEvent event) throws IOException {
        
        Parent Pedido5_parent = FXMLLoader.load(getClass().getResource("Mapa.fxml"));
        Scene Pedido5_scene = new Scene(Pedido5_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(Pedido5_scene);
        app_stage.show();
    }
    
    public void btnClickProximo1(ActionEvent event) throws IOException {
        
        Parent proximo_1_parent = FXMLLoader.load(getClass().getResource("Agendamento.fxml"));
        Scene proximo_1_scene = new Scene(proximo_1_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(proximo_1_scene);
        app_stage.show();
    }
    
    //Sair da conta
    public void btnClickSair(ActionEvent event) throws IOException {
        
        Parent sair_parent = FXMLLoader.load(getClass().getResource("Log In.fxml"));
        Scene sair_scene = new Scene(sair_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(sair_scene);
        app_stage.show();
    }
    
    //Voltar aao menu do motorista
    public void btnVoltarMenuMotorista(ActionEvent event) throws IOException {
        
        Parent sair_parent = FXMLLoader.load(getClass().getResource("HomePageFuncionario.fxml"));
        Scene sair_scene = new Scene(sair_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(sair_scene);
        app_stage.show();
    }
    
    //Aceita um pedido e abre mapa do local
    public void btnClickMapa(ActionEvent event) throws IOException {
        
        Parent mapa_detalhes_parent = FXMLLoader.load(getClass().getResource("Mapa.fxml"));
        Scene mapa_detalhes_scene = new Scene(mapa_detalhes_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(mapa_detalhes_scene);
        app_stage.show();
    }
    
    //Abre informações do pedido
    public void btnClickInformacoes(ActionEvent event) throws IOException {
        
        Parent info_pedido_parent = FXMLLoader.load(getClass().getResource("InformacoesPedido.fxml"));
        Scene info_pedido_scene = new Scene(info_pedido_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(info_pedido_scene);
        app_stage.show();
    }
    
    //Abre chat com o cliente
    public void btnClickChatMotorista(ActionEvent event) throws IOException {
        
        Parent info_pedido_parent = FXMLLoader.load(getClass().getResource("ChatMotorista.fxml"));
        Scene info_pedido_scene = new Scene(info_pedido_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(info_pedido_scene);
        app_stage.show();
    }
    
    //Abre pagina de pagamento (ainda em planejamento)
    public void btnClickQR(ActionEvent event) throws IOException {
        
        Parent QR_parent = FXMLLoader.load(getClass().getResource("Pagamento.fxml"));
        Scene QR_scene = new Scene(QR_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(QR_scene);
        app_stage.show();
    }
    
    //Tela do chat do motorista para o mapa do motorista
    public void btnClickChatCancelar(ActionEvent event) throws IOException {
        
        Parent chat_cancelar_parent = FXMLLoader.load(getClass().getResource("Mapa.fxml"));
        Scene chat_cancelar_scene = new Scene(chat_cancelar_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(chat_cancelar_scene);
        app_stage.show();
    }
    
    //Pagina home do motorista
    public void btnHomeFuncionario(ActionEvent event) throws IOException {
        
        Parent chat_cancelar_parent = FXMLLoader.load(getClass().getResource("HomePageFuncionario.fxml"));
        Scene chat_cancelar_scene = new Scene(chat_cancelar_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(chat_cancelar_scene);
        app_stage.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }

}

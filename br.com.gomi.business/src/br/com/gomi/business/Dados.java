/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gomi.business;

import br.com.gomi.back.*;
import br.com.gomi.shared.*;
import java.sql.SQLException;

/**
 *
 * @author Administrador
 */
public class Dados
{
    public static int insereCliente(ClienteViewModel cliente) throws Exception{
        ClienteDAO dao = new ClienteDAO();
        return dao.insert(cliente);
    }
    public static int insereNaoAdm(NaoAdmViewModel naoAdm) throws Exception{
        NaoAdmDAO dao = new NaoAdmDAO();
        return dao.insert(naoAdm);
    }
    public static int insereUsuario(UsuarioViewModel usuario) throws Exception{
        UsuarioDAO dao = new UsuarioDAO();
        return dao.insert(usuario);
    }
    public static int insereMotorista(MotoristaViewModel motorista) throws Exception{
        MotoristaDAO dao = new MotoristaDAO();
        return dao.insert(motorista);
    }
    public static int insereSolicitacao(SolicitacaoViewModel solicitacao) throws Exception{
        SolicitacaoDAO dao = new SolicitacaoDAO();
        return dao.insert(solicitacao);
    }
    public static ClienteViewModel recuperaCliente(String login) throws SQLException, Exception{
        UsuarioViewModel user = new UsuarioDAO().consultaEmail(login);
        NaoAdmViewModel na = new NaoAdmDAO().consult(user.getIdNaoAdm());
        ClienteViewModel cli = new ClienteDAO().consult(na.getIdCliente());
        cli.setIdNaoAdm(na.getIdNaoAdm());
        cli.setIdMotorista(na.getIdMotorista());
        cli.setTelefoneddd(na.getTelefoneddd());
        cli.setTelefone(na.getTelefone());
        cli.setId(user.getId());
        cli.setEmail(user.getEmail());
        cli.setSenha(user.getSenha());
        cli.setNome(user.getNome());
        cli.setData(user.getData());
        cli.setCpf(user.getCpf());        
        return cli;
    }
    public static MotoristaViewModel recuperaMotorista(String login) throws SQLException, Exception{
        UsuarioViewModel user = new UsuarioDAO().consultaEmail(login);
        NaoAdmViewModel na = new NaoAdmDAO().consult(user.getIdNaoAdm());
        MotoristaViewModel mot = new MotoristaDAO().consult(na.getIdMotorista());
        mot.setIdNaoAdm(na.getIdNaoAdm());
        mot.setIdCliente(na.getIdCliente());
        mot.setTelefoneddd(na.getTelefoneddd());
        mot.setTelefone(na.getTelefone());
        mot.setId(user.getId());
        mot.setEmail(user.getEmail());
        mot.setSenha(user.getSenha());
        mot.setNome(user.getNome());
        mot.setData(user.getData());
        mot.setCpf(user.getCpf());        
        return mot;
    }
}

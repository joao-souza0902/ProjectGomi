/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gomi.business;

import br.com.gomi.back.ClienteDAO;
import br.com.gomi.back.NaoAdmDAO;
import br.com.gomi.back.UsuarioDAO;
import br.com.gomi.shared.ClienteViewModel;
import br.com.gomi.shared.NaoAdmViewModel;
import br.com.gomi.shared.UsuarioViewModel;

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
}
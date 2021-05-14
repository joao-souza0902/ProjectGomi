/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gomi.business;

import br.com.gomi.back.LoginDAO;
import br.com.gomi.shared.UsuarioViewModel;
import java.sql.SQLException;

/**
 *
 * @author Administrador
 */
public class Validacao
{
    public static  boolean validaLogin (String usuario, String senha) throws SQLException{
        UsuarioViewModel user = new LoginDAO().login(usuario, senha);
        if (user != null)
            return true;
        else
            return false;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gomi.back;

import java.math.BigDecimal;
import java.util.HashMap;
import br.com.gomi.shared.*;
import java.time.LocalDate;

/**
 *
 * @author Administrador
 */
public class UsuarioDAO extends PadraoDAO<UsuarioViewModel>
{
      
    @Override
    protected String[] CriaParametros(UsuarioViewModel model)
    {           
        String[] parametros = new String[2];
        parametros[0] = String.valueOf(model.getId());
        parametros[1] = "'" + model.getEmail()+ "'";
        parametros[2] = "'" + model.getSenha()+ "'";
        parametros[3] = "'" + model.getNome()+ "'";
        parametros[4] = String.valueOf(model.getData());
        parametros[5] = "'" + model.getCpf()+ "'";
        return parametros;
    }

    @Override
    protected UsuarioViewModel MontaModel(HashMap<String, Object> registro)
    {
        UsuarioViewModel t = new UsuarioViewModel();
        t.setId((Integer)registro.get("id"));
        t.setEmail((String)registro.get("nome"));
        t.setSenha((String)registro.get("nome"));
        t.setNome((String)registro.get("nome"));
        t.setData(LocalDate.parse((String)registro.get("nome")));
        t.setCpf((String)registro.get("nome"));
        return t;
    }

    @Override
    protected void setTabela()
    {
       tabela = "Usuario";
    }    
    
    @Override
    protected void setQtdParametros(){
        qtdParametros = " ?, ?, ?, ?, ?, ?";
    }
}

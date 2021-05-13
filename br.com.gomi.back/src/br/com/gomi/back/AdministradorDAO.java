/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gomi.back;

import java.math.BigDecimal;
import java.util.HashMap;
import br.com.gomi.shared.*;

/**
 *
 * @author Administrador
 */
public class AdministradorDAO extends PadraoDAO<AdministradorViewModel>
{
      
    @Override
    protected String[] CriaParametros(AdministradorViewModel model)
    {           
        String[] parametros = new String[1];
        parametros[0] = String.valueOf(model.getId());
        return parametros;
    }

    @Override
    protected AdministradorViewModel MontaModel(HashMap<String, Object> registro)
    {
        AdministradorViewModel t = new AdministradorViewModel();
        t.setId((Integer)registro.get("id"));
        return t;
    }

    @Override
    protected void setTabela()
    {
       tabela = "Administrador";
    }    
    
    @Override
    protected void setQtdParametros(){
        qtdParametros = " ?";
    }
}

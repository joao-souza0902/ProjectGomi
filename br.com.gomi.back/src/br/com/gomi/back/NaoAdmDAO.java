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
public class NaoAdmDAO extends PadraoDAO<NaoAdmViewModel>
{
      
    @Override
    protected String[] CriaParametros(NaoAdmViewModel model)
    {           
        String[] parametros = new String[5];
        parametros[0] = String.valueOf(model.getId());
        parametros[1] = String.valueOf(model.getIdCliente());
        parametros[2] = String.valueOf(model.getIdMotorista());
        parametros[3] = String.valueOf(model.getTelefoneddd());
        parametros[4] = String.valueOf(model.getTelefone());
        
        return parametros;
    }

    @Override
    protected NaoAdmViewModel MontaModel(HashMap<String, Object> registro)
    {
        NaoAdmViewModel t = new NaoAdmViewModel();
        t.setId((Integer)registro.get("id"));
        t.setIdNaoAdm((Integer)registro.get("idCliente"));
        t.setIdAdministrador((Integer)registro.get("idMotorista"));
        t.setTelefoneddd((Integer)registro.get("telefoneDDD"));
        t.setTelefone((Integer)registro.get("telefone"));
        return t;
    }

    @Override
    protected void setTabela()
    {
       tabela = "NaoAdm";
    }    
    
    @Override
    protected void setQtdParametros(){
        qtdParametros = " ?, ?, ?, ?, ?";
    }
}

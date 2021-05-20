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
public class ClienteDAO extends PadraoDAO<ClienteViewModel>
{
      
    @Override
    protected String[] CriaParametros(ClienteViewModel model)
    {           
        String[] parametros = new String[7];
        parametros[0] = String.valueOf(model.getId());
        parametros[1] = model.getRua();
        parametros[2] = String.valueOf(model.getNumero());
        parametros[3] = model.getComplemento();
        parametros[4] = model.getBairro();
        parametros[5] = model.getCidade();
        parametros[6] = model.getCep();
        return parametros;
    }

    @Override
    protected ClienteViewModel MontaModel(HashMap<String, Object> registro)
    {
        ClienteViewModel t = new ClienteViewModel();
        t.setIdCliente((Integer)registro.get("IdCliente"));
        t.setRua((String)registro.get("Rua"));
        t.setNumero((Integer)registro.get("Numero"));
        t.setComplemento((String)registro.get("Complemento"));
        t.setBairro((String)registro.get("Bairro"));
        t.setCidade((String)registro.get("Cidade"));
        t.setCep((String)registro.get("CEP"));
        return t;
    }

    @Override
    protected void setTabela()
    {
       tabela = "Cliente";
    }    
    
    @Override
    protected void setQtdParametros(){
        qtdParametros = " ?, ?, ?, ?, ?, ?, ?";
    }
}

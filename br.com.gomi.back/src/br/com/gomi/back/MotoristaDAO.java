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
public class MotoristaDAO extends PadraoDAO<MotoristaViewModel>
{
      
    @Override
    protected String[] CriaParametros(MotoristaViewModel model)
    {           
        String[] parametros = new String[6];
        parametros[0] = String.valueOf(model.getId());
        parametros[1] = String.valueOf(model.getTipoVeiculo());
        parametros[2] = "'" + model.getCnh()+ "'"; //Verificar
        parametros[3] = String.valueOf(model.getDataExpiracao()); //Verificar
        parametros[4] = "'" + model.getCnhCategoria()+ "'";
        parametros[5] = String.valueOf(model.getCargaSuportada());
        return parametros;
    }

    @Override
    protected MotoristaViewModel MontaModel(HashMap<String, Object> registro)
    {
        MotoristaViewModel t = new MotoristaViewModel();
        t.setId((Integer)registro.get("id"));
        t.setTipoVeiculo((String)registro.get("tipoVeiculo"));
        t.setCnh((String)registro.get("cnh"));
        t.setDataExpiracao(LocalDate.parse((String)registro.get("dataExpiracao")));
        t.setCnhCategoria((Character)registro.get("cnhCategoria"));
        t.setCargaSuportada((Integer)registro.get("cargaSuportada"));
        return t;
    }

    @Override
    protected void setTabela()
    {
       tabela = "Motorista";
    }    
    
    @Override
    protected void setQtdParametros(){
        qtdParametros = " ?, ?, ?, ?, ?, ?";
    }
}

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
import java.time.format.DateTimeFormatter;

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
        parametros[2] = model.getCnh();
        parametros[3] = String.valueOf(model.getDataExpiracao());
        parametros[4] = String.valueOf(model.getCnhCategoria());
        parametros[5] = String.valueOf(model.getCargaSuportada());
        return parametros;
    }

    @Override
    protected MotoristaViewModel MontaModel(HashMap<String, Object> registro)
    {        
        MotoristaViewModel t = new MotoristaViewModel();
        t.setIdMotorista((Integer)registro.get("IdMotorista"));
        t.setTipoVeiculo((String)registro.get("TipoVeiculo"));
        t.setCnh((String)registro.get("CNH"));
        t.setDataExpiracao(LocalDate.parse(String.valueOf(registro.get("DataExpiracao"))));
        t.setCnhCategoria((Character)String.valueOf(registro.get("CategoriaCNH")).charAt(0));
        t.setCargaSuportada((Integer)registro.get("CargaSuportada"));
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

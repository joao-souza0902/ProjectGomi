/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gomi.back;

import java.util.HashMap;
import br.com.gomi.shared.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Administrador
 */
public class SolicitacaoDAO extends PadraoDAO<SolicitacaoViewModel>
{
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    @Override
    protected String[] CriaParametros(SolicitacaoViewModel model)
    {           
        String[] parametros = new String[10];
        parametros[0] = String.valueOf(model.getId());
        parametros[1] = String.valueOf(model.getIdCliente());
        parametros[2] = String.valueOf(model.getIdMotorista());
        parametros[3] = String.valueOf(model.isAgendamento());
        parametros[4] = String.valueOf(model.getDataSolicitacao().format(dtf));
        parametros[5] = String.valueOf(model.isAberto());
        parametros[6] = model.getDescricao();
        parametros[7] = String.valueOf(model.getVolume());
        parametros[8] = model.getCep();
        parametros[9] = String.valueOf(model.getNumero());
        
        return parametros;
    }

    @Override
    protected SolicitacaoViewModel MontaModel(HashMap<String, Object> registro)
    {
        DateTimeFormatter dft = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        SolicitacaoViewModel t = new SolicitacaoViewModel();
        t.setId((Integer)registro.get("IdSolicitacao"));
        t.setIdCliente((Integer)registro.get("IdCliente"));
        t.setIdMotorista((Integer)registro.get("IdMotorista"));
        t.setAgendamento((Boolean)registro.get("Agendamento"));
        t.setDataSolicitacao(LocalDateTime.parse(String.valueOf(registro.get("DataSolicitacao")).substring(0, 16), dft));
        t.setAberto((Boolean)registro.get("Aberto"));
        t.setDescricao((String)registro.get("Descricao"));
        t.setVolume((Integer)registro.get("Volume"));
        t.setCep((String)registro.get("cep"));
        t.setNumero((Integer)registro.get("numero"));
        return t;
    }

    @Override
    protected void setTabela()
    {
       tabela = "Solicitacao";
    }    
    
    @Override
    protected void setQtdParametros(){
        qtdParametros = " ?, ?, ?, ?, ?, ?, ?, ?, ?, ?";
    }
}
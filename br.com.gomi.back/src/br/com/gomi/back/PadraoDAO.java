/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gomi.back;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import br.com.gomi.shared.*;

/**
 *
 * @author Administrador
 * @param <T>
 */
public abstract class PadraoDAO<T> extends PadraoViewModel
{
    protected PadraoDAO(){
        setTabela();
        setQtdParametros();
    };
    protected String tabela; 
    protected String chave; 
    protected String qtdParametros; 
    protected abstract String[] CriaParametros(T model); //Talvez nao seja statement, mas aqui é para passar parametros
    protected abstract T MontaModel(HashMap<String, Object> registro);
    protected abstract void setTabela();
    protected abstract void setQtdParametros();
    
    public void insert(T model) throws Exception{
        HelperDAO.executaProc("exec spInsert_" + getTabela() + getQtdParametros(), CriaParametros(model));
    }
    public void update(T model)throws Exception{
        HelperDAO.executaProc("exec spUpdate_" + getTabela() + getQtdParametros(), CriaParametros(model));
    }
    public void delete(int id)throws Exception{
        String[] parametros = {String.valueOf(id), getTabela()};
        HelperDAO.executaProc("spDelete_ ?, ? ", parametros);
    }
    public T consult(int id)throws Exception{
        String[] parametros = {String.valueOf(id), getTabela()};
        JDataTable tabela = HelperDAO.executaProcSelect("spConsult_ ?, ?", parametros);
        if (tabela.getNumeroLinhas() == 0)
            return null;
        else
            return MontaModel(tabela.getLinha(1));
    }
    public ArrayList<T> list()throws Exception{
        String[] parametros = {getTabela()};
        JDataTable tabela = HelperDAO.executaProcSelect("spList_ ?", parametros);
        ArrayList<T> lista = new ArrayList<T>();
        for(int linha = 1; linha <= tabela.getNumeroLinhas(); linha++){
            lista.add(MontaModel(tabela.getLinha(linha)));
        }
        return lista;
    }

    /**
     * @return the tabela
     */
    public String getTabela()
    {
        return tabela;
    }

    /**
     * @return the chave
     */
    public String getChave()
    {
        return chave;
    }

    /**
     * @param chave the chave to set
     */
    public void setChave(String chave)
    {
        this.chave = chave;
    }

    /**
     * @return the qtdParametros
     */
    public String getQtdParametros()
    {
        return qtdParametros;
    }
}

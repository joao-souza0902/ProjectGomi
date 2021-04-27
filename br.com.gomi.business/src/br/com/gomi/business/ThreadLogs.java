/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gomi.business;

/**
 *
 * @author Fábio
 */
public class ThreadLogs extends Thread{
    
    private boolean ativo = true;
    
    @Override
    public void run() {
        Auditoria auditoria = Auditoria.obtemInstancia();
        
        while (isAtivo() /*|| auditoria.existemLogsNaFila()*/ ) {  //Só ativar essa parte depois de estar salvando no banco
            if (auditoria.existemLogsNaFila()) {
                String log = auditoria.getFila().poll();
                
                ////////////////////////////////////////////////////////////////////////////////
                //Salvar no banco de dados, na tabela de logs
                ////////////////////////////////////////////////////////////////////////////////                               
            }
        }
    }
    
    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}

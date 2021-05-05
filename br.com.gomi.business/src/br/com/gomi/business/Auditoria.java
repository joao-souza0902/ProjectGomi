/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gomi.business;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 *
 * @author Fábio
 */
public class Auditoria {
    /*Singleton*/
    static private Auditoria _instancia;
    
    private Auditoria(){
    }
    
    public static Auditoria obtemInstancia(){
        if(_instancia == null){
            _instancia = new Auditoria();            
        }
        return _instancia;
    }
    /*Singleton*/
    
    ThreadLogs thread;
    static private ConcurrentLinkedQueue<String> fila = new ConcurrentLinkedQueue<String>();
    
    public ConcurrentLinkedQueue<String> getFila() {
        return fila;
    }
    
    public void salvarLog(String log){
        fila.add(log);
    }
    
    public boolean existemLogsNaFila(){
        if(fila.isEmpty()){
            return false;
        }
        else{
            return true;
        }
    }
    
    //É necessário executar o método iniciar no inicio da aplicação
    public void iniciar(){
        if(thread == null){
            thread = new ThreadLogs();
            thread.start();
        }                
    }
    
    //É necessário executar o método finalizar no final da aplicação (Dentro do Finally)
    public void finalizar(){
        if(thread != null){
            thread.setAtivo(false);
        }
    }
}
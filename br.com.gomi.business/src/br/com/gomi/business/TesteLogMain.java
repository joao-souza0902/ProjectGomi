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
public class TesteLogMain {
    public static void main(String[] args) throws Exception
    {
        try
        {
            Auditoria.obtemInstancia().iniciar();
            for (Integer i = 0; i < 100; i++){
                Auditoria.obtemInstancia().salvarLog("Log" + i.toString());
            }
        }
        finally
        {
            Auditoria.obtemInstancia().finalizar();
        }
    }
}

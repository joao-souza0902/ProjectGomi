/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gomi.back;

import br.com.gomi.shared.LogViewModel;

/**
 *
 * @author Administrador
 */
public class TesteMain
{
    public static void main(String[] args) throws Exception
    {
        LogDAO l = new LogDAO();
        LogViewModel lvm = new LogViewModel();
        lvm.setId(1);
        lvm.setDescricao("Primeiro teste com o Log");
        l.insert(lvm);
    }
}

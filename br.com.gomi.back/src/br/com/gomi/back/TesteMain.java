/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gomi.back;

import br.com.gomi.shared.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;

/**
 *
 * @author Administrador
 */
public class TesteMain
{
    public static void main(String[] args) throws Exception
    {
       DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
       EcopontoDAO dao = new EcopontoDAO();
       EcopontoViewModel vm = new EcopontoViewModel();
       vm.setId(1);
       vm.setCep("156058902");
       vm.setNumero(331);       
       System.out.println(dao.insert(vm));
    }
}

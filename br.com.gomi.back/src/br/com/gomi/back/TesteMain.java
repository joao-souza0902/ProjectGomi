/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gomi.back;

import br.com.gomi.shared.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

/**
 *
 * @author Administrador
 */
public class TesteMain
{
    public static void main(String[] args) throws Exception
    {
        DateTimeFormatter sdf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        NaoAdmDAO dao = new NaoAdmDAO();
        NaoAdmViewModel vm = new NaoAdmViewModel();
        vm.setId(175);
        vm.setTelefoneddd(11);
        vm.setTelefone(946626888);
        dao.insert(vm);
    }
}

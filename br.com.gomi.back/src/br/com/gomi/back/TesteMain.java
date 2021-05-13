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
        UsuarioDAO dao = new UsuarioDAO();
        UsuarioViewModel vm = new UsuarioViewModel();
        vm.setId(175);
        vm.setIdNaoAdm(1);
        vm.setIdAdministrador(null);
        vm.setEmail("qualquer.coisa@gmail.com");
        vm.setSenha("admin123456ç");
        vm.setNome("Adamastor Terreno");
        vm.setData(LocalDate.parse("11/05/1997", sdf));
        vm.setCpf("44885468893");
        dao.insert(vm);
    }
}

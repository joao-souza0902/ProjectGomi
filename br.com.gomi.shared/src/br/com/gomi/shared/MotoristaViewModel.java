/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gomi.shared;

import java.time.LocalDate;

/**
 *
 * @author Fábio
 */
public class MotoristaViewModel extends NaoAdmViewModel{    
    private String tipoVeiculo;
    private String cnh;
    private LocalDate dataExpiracao;
    private char cnhCategoria;
    private int cargaSuportada;
    //Foto da CNH
    
    public String gettipoVeiculo() {
        return tipoVeiculo;
    }

    public void settipoVeiculo(String tipoVeiculo) {
        this.tipoVeiculo = tipoVeiculo;
    }
    
    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public LocalDate getDataExpiracao() {
        return dataExpiracao;
    }

    public void setDataExpiracao(LocalDate dataExpiracao) {
        this.dataExpiracao = dataExpiracao;
    }

    public char getCnhCategoria() {
        return cnhCategoria;
    }

    public void setCnhCategoria(char cnhCategoria) {
        this.cnhCategoria = Character.toUpperCase(cnhCategoria);
    }

    public int getCargaSuportada() {
        return cargaSuportada;
    }

    public void setCargaSuportada(int cargaSuportada) {
        this.cargaSuportada = cargaSuportada;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gomi.shared;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author Fábio
 */
public class SolicitacaoViewModel extends PadraoViewModel {
    private int idCliente;
    private int idMotorista;
    private boolean agendamento;
    private LocalDateTime dataSolicitacao;
    private boolean aberto;
    private String descricao;
    private int volume;
    private String cep;
    private int numero;
    ArrayList<CategoriaViewModel> categorias = new ArrayList<>();    

    public int getIdCliente()
    {
        return idCliente;
    }

    public void setIdCliente(int idCliente)
    {
        this.idCliente = idCliente;
    }

    public int getIdMotorista()
    {
        return idMotorista;
    }

    public void setIdMotorista(int idMotorista)
    {
        this.idMotorista = idMotorista;
    }
    
    public boolean isAgendamento() {
        return agendamento;
    }

    public void setAgendamento(boolean agendamento) {
        this.agendamento = agendamento;
    }

    public LocalDateTime getDataSolicitacao() {
        return dataSolicitacao;
    }

    public void setDataSolicitacao(LocalDateTime dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }

    public boolean isAberto() {
        return aberto;
    }

    public void setAberto(boolean aberto) {
        this.aberto = aberto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    } 
    
    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}

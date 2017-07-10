package com.cesar.renda.bean;

import java.io.Serializable;
import java.util.Date;

public class Contrato implements Serializable{

    private int id;
    private Date dataAssinatura;
    private int idApartamento;
    private int idInquilino;
    private int idSenhorio;
    private String termos;
    private Date dataTermino;
    private Date dataVencimentoRenda;

    public Contrato() {
    }

    public Contrato(Date dataAssinatura, int idApartamento, int idInquilino, int idSenhorio, Date dataVencimentoRenda) {
        this.dataAssinatura = dataAssinatura;
        this.idApartamento = idApartamento;
        this.idInquilino = idInquilino;
        this.idSenhorio = idSenhorio;
        this.dataVencimentoRenda = dataVencimentoRenda;
    }

    public Contrato(int id, Date dataAssinatura, int idApartamento, int idInquilino, int idSenhorio, String termos, Date dataTermino, Date dataVencimentoRenda) {
        this.id = id;
        this.dataAssinatura = dataAssinatura;
        this.idApartamento = idApartamento;
        this.idInquilino = idInquilino;
        this.idSenhorio = idSenhorio;
        this.termos = termos;
        this.dataTermino = dataTermino;
        this.dataVencimentoRenda = dataVencimentoRenda;
    }

    public boolean isEmpty(){
        return (dataAssinatura == null && dataVencimentoRenda == null && idApartamento <= 0 
                && idInquilino <= 0 && idSenhorio <= 0 );
    }
    
    @Override
    public String toString() {
        return "Contrato{" + "id=" + id + ", dataAssinatura=" + dataAssinatura + ", idApartamento=" + idApartamento + ", idInquilino=" + idInquilino + ", idSenhorio=" + idSenhorio + ", termos=" + termos + ", dataTermino=" + dataTermino + ", dataVencimentoRenda=" + dataVencimentoRenda + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataAssinatura() {
        return dataAssinatura;
    }

    public void setDataAssinatura(Date dataAssinatura) {
        this.dataAssinatura = dataAssinatura;
    }

    public int getIdApartamento() {
        return idApartamento;
    }

    public void setIdApartamento(int idApartamento) {
        this.idApartamento = idApartamento;
    }

    public int getIdInquilino() {
        return idInquilino;
    }

    public void setIdInquilino(int idInquilino) {
        this.idInquilino = idInquilino;
    }

    public int getIdSenhorio() {
        return idSenhorio;
    }

    public void setIdSenhorio(int idSenhorio) {
        this.idSenhorio = idSenhorio;
    }

    public String getTermos() {
        return termos;
    }

    public void setTermos(String termos) {
        this.termos = termos;
    }

    public Date getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(Date dataTermino) {
        this.dataTermino = dataTermino;
    }

    public Date getDataVencimentoRenda() {
        return dataVencimentoRenda;
    }

    public void setDataVencimentoRenda(Date dataVencimentoRenda) {
        this.dataVencimentoRenda = dataVencimentoRenda;
    }
    
    
    
}

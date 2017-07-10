package com.cesar.renda.bean;

import java.io.Serializable;
import java.util.Date;

public class Pagamento implements Serializable{

    private int id;
    private int idInquilino;
    private int idContrato;
    private float valorPago;
    private Date dataPagamento;
    private String pagamentoMes;
    private String pagamentoAno;
    
    public Pagamento() {}

    public Pagamento(int idInquilino, int idContrato, float valorPago, Date dataPagamento, String pagamentoMes, String pagamentoAno) {
        this.idInquilino = idInquilino;
        this.idContrato = idContrato;
        this.valorPago = valorPago;
        this.dataPagamento = dataPagamento;
        this.pagamentoMes = pagamentoMes;
        this.pagamentoAno = pagamentoAno;
    }

    public Pagamento(int id, int idInquilino, int idContrato, float valorPago, Date dataPagamento, String pagamentoMes, String pagamentoAno) {
        this.id = id;
        this.idInquilino = idInquilino;
        this.idContrato = idContrato;
        this.valorPago = valorPago;
        this.dataPagamento = dataPagamento;
        this.pagamentoMes = pagamentoMes;
        this.pagamentoAno = pagamentoAno;
    }

    @Override
    public String toString() {
        return "Pagamento{" + "id=" + id + ", idInquilino=" + idInquilino + ", idContrato=" + idContrato + ", valorPago=" + valorPago + ", dataPagamento=" + dataPagamento + ", pagamentoMes=" + pagamentoMes + ", pagamentoAno=" + pagamentoAno + '}';
    }
    
    public boolean isEmpty(){
        return (idInquilino <= 0 && idContrato <= 0 && valorPago <= 0 && dataPagamento == null 
                && pagamentoMes == null && pagamentoAno == null);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdInquilino() {
        return idInquilino;
    }

    public void setIdInquilino(int idInquilino) {
        this.idInquilino = idInquilino;
    }

    public int getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(int idContrato) {
        this.idContrato = idContrato;
    }

    public float getValorPago() {
        return valorPago;
    }

    public void setValorPago(float valorPago) {
        this.valorPago = valorPago;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public String getPagamentoMes() {
        return pagamentoMes;
    }

    public void setPagamentoMes(String pagamentoMes) {
        this.pagamentoMes = pagamentoMes;
    }

    public String getPagamentoAno() {
        return pagamentoAno;
    }

    public void setPagamentoAno(String pagamentoAno) {
        this.pagamentoAno = pagamentoAno;
    }

}

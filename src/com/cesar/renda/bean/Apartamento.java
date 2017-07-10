package com.cesar.renda.bean;

import java.io.Serializable;

public class Apartamento implements Serializable{

    private int id;
    private int numQuartos;
    private String area;
    private String piso;
    private String tipo;
    private String descricao;
    private String ref_quarto;

    public Apartamento() {
    }

    public Apartamento(int numQuartos, String tipo, String ref_quarto) {
        this.numQuartos = numQuartos;
        this.tipo = tipo;
        this.ref_quarto = ref_quarto;
    }

    public Apartamento(int id, int numQuartos, String area, String piso, String tipo, String descricao, String ref_quarto) {
        this.id = id;
        this.numQuartos = numQuartos;
        this.area = area;
        this.piso = piso;
        this.tipo = tipo;
        this.descricao = descricao;
        this.ref_quarto = ref_quarto;
    }

    @Override
    public String toString() {
        return "Apartamento{" + "id=" + id + ", numQuartos=" + numQuartos + ", area=" + area + ", piso=" + piso + ", tipo=" + tipo + ", descricao=" + descricao + ", ref_quarto=" + ref_quarto + '}';
    }
    
    public boolean isEmpty(){
        return (numQuartos <= 0 && tipo == null && ref_quarto == null);
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumQuartos() {
        return numQuartos;
    }

    public void setNumQuartos(int numQuartos) {
        this.numQuartos = numQuartos;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getRef_quarto() {
        return ref_quarto;
    }

    public void setRef_quarto(String ref_quarto) {
        this.ref_quarto = ref_quarto;
    }

}

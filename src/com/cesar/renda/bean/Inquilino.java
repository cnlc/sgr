package com.cesar.renda.bean;

import java.io.Serializable;
import java.util.Date;

public class Inquilino implements Serializable{

    private int id;
    private String nome;
    private String sexo;
    private Date dataNascimento;
    private String docIdentificacao;
    private String NumDoc;
    private String nacionalidade;
    private String contato;

    public Inquilino() {
    }

    public Inquilino(String nome, String sexo) {
        this.nome = nome;
        this.sexo = sexo;
    }
    
    public Inquilino(int id, String nome, String sexo, Date dataNascimento, String docIdentificacao, String NumDoc, String nacionalidade, String contato) {
        this.id = id;
        this.nome = nome;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
        this.docIdentificacao = docIdentificacao;
        this.NumDoc = NumDoc;
        this.nacionalidade = nacionalidade;
        this.contato = contato;
    }

    @Override
    public String toString() {
        return "Inquilino{" + "id=" + id + ", nome=" + nome + ", sexo=" + sexo + ", dataNascimento=" + dataNascimento + ", docIdentificacao=" + docIdentificacao + ", NumDoc=" + NumDoc + ", nacionalidade=" + nacionalidade + ", contato=" + contato + '}';
    }

    public boolean isEmpty(){
        return (nome == null && sexo == null);
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getDocIdentificacao() {
        return docIdentificacao;
    }

    public void setDocIdentificacao(String docIdentificacao) {
        this.docIdentificacao = docIdentificacao;
    }

    public String getNumDoc() {
        return NumDoc;
    }

    public void setNumDoc(String NumDoc) {
        this.NumDoc = NumDoc;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    
}

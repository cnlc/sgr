package com.cesar.renda.bean;

import java.io.Serializable;
import java.util.Date;

public class Senhorio implements Serializable {

    private int id;
    private String nome;
    private String sexo;
    private Date dataNascimento;
    private String docIdentificacao;
    private String NumDoc;
    private String Nacionalidade;
    private String contato;

    public Senhorio() {
    }

    public Senhorio(String nome, String sexo) {
        this.nome = nome;
        this.sexo = sexo;
    }

    public Senhorio(int id, String nome, String sexo, Date dataNascimento, String docIdentificacao, String NumDoc, String Nacionalidade, String contato) {
        this.id = id;
        this.nome = nome;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
        this.docIdentificacao = docIdentificacao;
        this.NumDoc = NumDoc;
        this.Nacionalidade = Nacionalidade;
        this.contato = contato;
    }

    @Override
    public String toString() {
        return "Senhorio{" + "id=" + id + ", nome=" + nome + ", sexo=" + sexo + ", dataNascimento=" + dataNascimento + ", docIdentificacao=" + docIdentificacao + ", NumDoc=" + NumDoc + ", Nacionalidade=" + Nacionalidade + ", contato=" + contato + '}';
    }

    public boolean isEmpty() {
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
        return Nacionalidade;
    }

    public void setNacionalidade(String Nacionalidade) {
        this.Nacionalidade = Nacionalidade;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

}

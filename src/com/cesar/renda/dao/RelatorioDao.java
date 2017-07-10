package com.cesar.renda.dao;

public interface RelatorioDao {

    public abstract void gerarRelatorioApartamento();

    public abstract void gerarRelatorioInquilino();

    public abstract void gerarRelatorioPagamento();

    public abstract void listarRelatorio();

    public abstract void pesquizarRelatorio();

    public abstract void imprimirRelatorio();

}

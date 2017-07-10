package com.cesar.renda.dao;

import com.cesar.renda.bean.Apartamento;
import java.util.ArrayList;

public interface ApartamentoDao {

    public int insert(Apartamento apartamento);
    public int create(Apartamento apartamento);
    public int update(Apartamento apartamento);
    public Apartamento get(int id);
    public ArrayList<Apartamento> getAll();
    public ArrayList<Apartamento> find();
    public void delete(int id);

}

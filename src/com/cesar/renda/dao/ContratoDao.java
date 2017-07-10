package com.cesar.renda.dao;

import com.cesar.renda.bean.Contrato;
import java.util.ArrayList;

public interface ContratoDao {

    public int insert(Contrato contrato);
    public int create(Contrato contrato);
    public int update(Contrato contrato);
    public Contrato get(int id);
    public ArrayList<Contrato> getAll();
    public ArrayList<Contrato> find();
    public void delete(int id);

}

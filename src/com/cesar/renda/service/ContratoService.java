package com.cesar.renda.service;

import com.cesar.renda.bean.Contrato;
import java.util.ArrayList;

public interface ContratoService {
    
    public int create(Contrato contrato);
    public int update(Contrato inquilino);
    public Contrato get(int id);
    public ArrayList<Contrato> getAll();
    public ArrayList<Contrato> find();
    public void delete(int id);

}

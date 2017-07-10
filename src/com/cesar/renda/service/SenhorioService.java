package com.cesar.renda.service;

import com.cesar.renda.bean.Senhorio;
import java.util.ArrayList;

public interface SenhorioService {

    public int create(Senhorio senhorio);
    public int update(Senhorio senhorio);
    public Senhorio get(int id);
    public ArrayList<Senhorio> getAll();
    public ArrayList<Senhorio> find();
    public void delete(int id);

}

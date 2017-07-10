package com.cesar.renda.dao;

import com.cesar.renda.bean.Senhorio;
import java.util.ArrayList;

public interface SenhorioDao {

    public int insert(Senhorio senhorio);
    public int create(Senhorio senhorio);
    public int update(Senhorio senhorio);
    public Senhorio get(int id);
    public ArrayList<Senhorio> getAll();
    public ArrayList<Senhorio> find();
    public void delete(int id);

}

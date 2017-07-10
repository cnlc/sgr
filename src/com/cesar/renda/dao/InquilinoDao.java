package com.cesar.renda.dao;

import com.cesar.renda.bean.Inquilino;
import java.util.ArrayList;

public interface InquilinoDao {

    public int insert(Inquilino inquilino);
    public int create(Inquilino inquilino);
    public int update(Inquilino inquilino);
    public Inquilino get(int id);
    public ArrayList<Inquilino> getAll();
    public ArrayList<Inquilino> find();
    public void delete(int id);

}

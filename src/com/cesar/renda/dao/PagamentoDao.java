package com.cesar.renda.dao;

import com.cesar.renda.bean.Pagamento;
import java.util.ArrayList;

public interface PagamentoDao {
    
    public int insert(Pagamento pagamento);
    public int create(Pagamento pagamento);
    public int update(Pagamento pagamento);
    public Pagamento get(int id);
    public ArrayList<Pagamento> getAll();
    public ArrayList<Pagamento> find();
    public void delete(int id);

}

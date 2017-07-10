package com.cesar.renda.service;

import com.cesar.renda.bean.Pagamento;
import java.util.ArrayList;

public interface PagamentoService {

    public int create(Pagamento pagamento);
    public int update(Pagamento inquilino);
    public Pagamento get(int id);
    public ArrayList<Pagamento> getAll();
    public ArrayList<Pagamento> find();
    public void delete(int id);

}

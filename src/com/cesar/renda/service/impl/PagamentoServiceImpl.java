/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cesar.renda.service.impl;

import com.cesar.renda.bean.Pagamento;
import com.cesar.renda.dao.PagamentoDao;
import com.cesar.renda.dao.impl.PagamentoDaoImpl;
import com.cesar.renda.service.PagamentoService;
import com.cesar.renda.utils.exception.CCValidationException;
import java.util.ArrayList;
import java.util.List;


public class PagamentoServiceImpl implements PagamentoService {

   @Override
    public int create(Pagamento pagamento) {
        if(pagamento.isEmpty()){
            errors.add("[idInquilino] é Obrigatório");
            errors.add("[idContrato] é Obrigatório");
            errors.add("[valorPago] é Obrigatório");
            errors.add("[dataPagamento] é Obrigatório");
            errors.add("[pagamentoMes] é Obrigatório");
            errors.add("[pagamentoAno] é Obrigatório");
            throw new CCValidationException(errors);
        }
        return dao.insert(pagamento);
    }

    @Override
    public int update(Pagamento pagamento) {
        if(pagamento.getId() <= 0 ){
            errors.add("[ID] é Obrigatório");
            throw new CCValidationException(errors);
        }
        if(pagamento.isEmpty()){
            errors.add("[idInquilino] é Obrigatório");
            errors.add("[idContrato] é Obrigatório");
            errors.add("[valorPago] é Obrigatório");
            errors.add("[dataPagamento] é Obrigatório");
            errors.add("[pagamentoMes] é Obrigatório");
            errors.add("[pagamentoAno] é Obrigatório");
            throw new CCValidationException(errors);
        }
        return dao.update(pagamento);
    }

    @Override
    public Pagamento get(int id) {
        if(id <= 0 ){
            errors.add("[ID] é Obrigatório");
            throw new CCValidationException(errors);
        }
        return dao.get(id);
    }

    @Override
    public ArrayList<Pagamento> getAll() {
        return dao.getAll();
    }

    @Override
    public ArrayList<Pagamento> find() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id) {
        if(id <= 0 ){
            errors.add("[ID] é Obrigatório");
            throw new CCValidationException(errors);
        }
        dao.delete(id);
    }
    
    private PagamentoDao dao = new PagamentoDaoImpl();
    private List<String> errors = new ArrayList<>();
}

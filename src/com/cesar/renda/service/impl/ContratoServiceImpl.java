/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cesar.renda.service.impl;

import com.cesar.renda.bean.Contrato;
import com.cesar.renda.dao.ContratoDao;
import com.cesar.renda.dao.impl.ContratoDaoImpl;
import com.cesar.renda.service.ContratoService;
import com.cesar.renda.utils.exception.CCValidationException;
import java.util.ArrayList;
import java.util.List;


public class ContratoServiceImpl implements ContratoService {


    @Override
    public int create(Contrato contrato) {
        if(contrato.isEmpty()){
            errors.add("[dataAssinatura] é Obrigatório");
            errors.add("[idApartamento] é Obrigatório");
            errors.add("[idInquilino] é Obrigatório");
            errors.add("[idSenhorio] é Obrigatório");
            errors.add("[dataVencimentoRenda] é Obrigatório");
            throw new CCValidationException(errors);
        }
        return dao.insert(contrato);
    }

    @Override
    public int update(Contrato contrato) {
        if(contrato.getId() <= 0 ){
            errors.add("[ID] é Obrigatório");
            throw new CCValidationException(errors);
        }
        if(contrato.isEmpty()){
            errors.add("[dataAssinatura] é Obrigatório");
            errors.add("[idApartamento] é Obrigatório");
            errors.add("[idInquilino] é Obrigatório");
            errors.add("[idSenhorio] é Obrigatório");
            errors.add("[dataVencimentoRenda] é Obrigatório");
            throw new CCValidationException(errors);
        }
        return dao.update(contrato);
    }

    @Override
    public Contrato get(int id) {
        if(id <= 0 ){
            errors.add("[ID] é Obrigatório");
            throw new CCValidationException(errors);
        }
        return dao.get(id);
    }

    @Override
    public ArrayList<Contrato> getAll() {
        return dao.getAll();
    }

    @Override
    public ArrayList<Contrato> find() {
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
    
    private ContratoDao dao = new ContratoDaoImpl();
    private List<String> errors = new ArrayList<>();
}

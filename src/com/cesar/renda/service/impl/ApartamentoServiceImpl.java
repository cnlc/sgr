/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cesar.renda.service.impl;

import com.cesar.renda.bean.Apartamento;
import com.cesar.renda.dao.ApartamentoDao;
import com.cesar.renda.dao.impl.ApartamentoDaoImpl;
import com.cesar.renda.service.ApartamentoService;
import com.cesar.renda.utils.exception.CCValidationException;
import java.util.ArrayList;
import java.util.List;


public class ApartamentoServiceImpl implements ApartamentoService {


    @Override
    public int create(Apartamento apartamento) {
        if(apartamento.isEmpty()){
            errors.add("[numQuartos] é Obrigatório");
            errors.add("[tipo] é Obrigatório");
            errors.add("[ref_quarto] é Obrigatório");
            throw new CCValidationException(errors);
        }
        return dao.insert(apartamento);
    }

    @Override
    public int update(Apartamento apartamento) {
        if(apartamento.getId() <= 0 ){
            errors.add("[ID] é Obrigatório");
            throw new CCValidationException(errors);
        }
        if(apartamento.isEmpty()){
            errors.add("[numQuartos] é Obrigatório");
            errors.add("[tipo] é Obrigatório");
            errors.add("[ref_quarto] é Obrigatório");
            throw new CCValidationException(errors);
        }
        return dao.update(apartamento);
    }

    @Override
    public Apartamento get(int id) {
        if(id <= 0 ){
            errors.add("[ID] é Obrigatório");
            throw new CCValidationException(errors);
        }
        return dao.get(id);
    }

    @Override
    public ArrayList<Apartamento> getAll() {
        return dao.getAll();
    }

    @Override
    public ArrayList<Apartamento> find() {
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
    
    private ApartamentoDao dao = new ApartamentoDaoImpl();
    private List<String> errors = new ArrayList<>();
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cesar.renda.service.impl;

import com.cesar.renda.bean.Inquilino;
import com.cesar.renda.dao.InquilinoDao;
import com.cesar.renda.dao.impl.InquilinoDaoImpl;
import com.cesar.renda.service.InquilinoService;
import com.cesar.renda.utils.exception.CCValidationException;
import java.util.ArrayList;
import java.util.List;


public class InquilinoServiceImpl implements InquilinoService {


    @Override
    public int create(Inquilino inquilino) {
        if(inquilino.isEmpty()){
            errors.add("[nome] é Obrigatório");
            errors.add("[sexo] é Obrigatório");
            throw new CCValidationException(errors);
        }
        return dao.insert(inquilino);
    }

    @Override
    public int update(Inquilino inquilino) {
        if(inquilino.getId() <= 0 ){
            errors.add("[ID] é Obrigatório");
            throw new CCValidationException(errors);
        }
        if(inquilino.isEmpty()){
            errors.add("[nome] é Obrigatório");
            errors.add("[sexo] é Obrigatório");
            throw new CCValidationException(errors);
        }
        return dao.update(inquilino);
    }

    @Override
    public Inquilino get(int id) {
        if(id <= 0 ){
            errors.add("[ID] é Obrigatório");
            throw new CCValidationException(errors);
        }
        return dao.get(id);
    }

    @Override
    public ArrayList<Inquilino> getAll() {
        return dao.getAll();
    }

    @Override
    public ArrayList<Inquilino> find() {
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
    
    private InquilinoDao dao = new InquilinoDaoImpl();
    private List<String> errors = new ArrayList<>();
}

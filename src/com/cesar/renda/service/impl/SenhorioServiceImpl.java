/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cesar.renda.service.impl;

import com.cesar.renda.bean.Senhorio;
import com.cesar.renda.dao.SenhorioDao;
import com.cesar.renda.dao.impl.SenhorioDaoImpl;
import com.cesar.renda.service.SenhorioService;
import com.cesar.renda.utils.exception.CCValidationException;
import java.util.ArrayList;
import java.util.List;


public class SenhorioServiceImpl implements SenhorioService {


    @Override
    public int create(Senhorio senhorio) {
        if(senhorio.isEmpty()){
            errors.add("[nome] é Obrigatório");
            errors.add("[sexo] é Obrigatório");
            throw new CCValidationException(errors);
        }
        return dao.insert(senhorio);
    }

    @Override
    public int update(Senhorio senhorio) {
        if(senhorio.getId() <= 0 ){
            errors.add("[ID] é Obrigatório");
            throw new CCValidationException(errors);
        }
        if(senhorio.isEmpty()){
            errors.add("[nome] é Obrigatório");
            errors.add("[sexo] é Obrigatório");
            throw new CCValidationException(errors);
        }
        return dao.update(senhorio);
    }

    @Override
    public Senhorio get(int id) {
        if(id <= 0 ){
            errors.add("[ID] é Obrigatório");
            throw new CCValidationException(errors);
        }
        return dao.get(id);
    }

    @Override
    public ArrayList<Senhorio> getAll() {
        return dao.getAll();
    }

    @Override
    public ArrayList<Senhorio> find() {
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
    
    private SenhorioDao dao = new SenhorioDaoImpl();
    private List<String> errors = new ArrayList<>();
}

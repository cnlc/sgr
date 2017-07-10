package com.cesar.renda.controller;

import com.cesar.renda.bean.Apartamento;
import com.cesar.renda.service.ApartamentoService;
import com.cesar.renda.service.impl.ApartamentoServiceImpl;
import com.cesar.renda.utils.exception.CCValidationException;

public class ApartamentoController{
    private final ApartamentoService service;
    
    public ApartamentoController() {
        this.service = new ApartamentoServiceImpl();
    }
    
    public void registarApartamento(Apartamento ap){
        int id = service.create(ap);
        try {
            System.out.println(service.get(id)); 
        } catch (CCValidationException e) {
            
        }
        
    }
}

package com.cesar.renda.service;

import com.cesar.renda.bean.Apartamento;
import com.cesar.renda.utils.exception.CCValidationException;
import java.util.ArrayList;

public interface ApartamentoService {
    
    /**
     *
     * @param apartamento
     * @return
     * @throws CCValidationException
     */
    public int create(Apartamento apartamento) throws CCValidationException;

    /**
     *
     * @param apartamento
     * @return
     * @throws CCValidationException
     */
    public int update(Apartamento apartamento) throws CCValidationException;
    /**
     * Search database and return an Apartment with id passed on param
     *
     * @param id
     * @return Apartamento
     * @throws CCValidationException when some params is null or id = 0
     */
    public Apartamento get(int id) throws CCValidationException;

    /**
     *
     * @return
     * @throws CCValidationException
     */
    public ArrayList<Apartamento> getAll() throws CCValidationException;

    /**
     *
     * @return
     * @throws CCValidationException
     */
    public ArrayList<Apartamento> find() throws CCValidationException;

    /**
     *
     * @param id
     * @throws CCValidationException
     */
    public void delete(int id) throws CCValidationException;

}

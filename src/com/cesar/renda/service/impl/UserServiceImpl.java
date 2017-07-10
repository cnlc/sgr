/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cesar.renda.service.impl;

import com.cesar.renda.bean.User;
import com.cesar.renda.dao.UserDao;
import com.cesar.renda.dao.impl.UserDaoImpl;
import com.cesar.renda.service.UserService;
import com.cesar.renda.utils.exception.CCValidationException;
import java.util.ArrayList;
import java.util.List;


public class UserServiceImpl implements UserService {

    @Override
    public int create(User user) {
        if(user.isEmpty()){
            errors.add("[userType] é Obrigatório");
            errors.add("[fullName] é Obrigatório");
            errors.add("[username] é Obrigatório");
            errors.add("[password] é Obrigatório");
            throw new CCValidationException(errors);
        }
        return dao.insert(user);
    }

    @Override
    public int update(User user) {
        if(user.getId() <= 0 ){
            errors.add("[ID] é Obrigatório");
            throw new CCValidationException(errors);
        }
        if(user.isEmpty()){
            errors.add("[userType] é Obrigatório");
            errors.add("[fullName] é Obrigatório");
            errors.add("[username] é Obrigatório");
            errors.add("[password] é Obrigatório");
            throw new CCValidationException(errors);
        }
        return dao.update(user);
    }

    @Override
    public User get(int id) {
        if(id <= 0 ){
            errors.add("[ID] é Obrigatório");
            throw new CCValidationException(errors);
        }
        return dao.get(id);
    }

    @Override
    public ArrayList<User> getAll() {
        return dao.getAll();
    }

    @Override
    public ArrayList<User> find() {
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
    
    private UserDao dao = new UserDaoImpl();
    private List<String> errors = new ArrayList<>();
}

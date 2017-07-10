package com.cesar.renda.dao;

import com.cesar.renda.bean.User;
import java.util.ArrayList;

public interface UserDao {

    public int insert(User user);
    public int create(User user);
    public int update(User user);
    public User get(int id);
    public ArrayList<User> getAll();
    public ArrayList<User> find();
    public void delete(int id);

}

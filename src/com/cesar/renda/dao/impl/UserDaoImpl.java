/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cesar.renda.dao.impl;

import com.cesar.renda.bean.User;
import com.cesar.renda.dao.UserDao;
import com.cesar.renda.dao.jdbc.JdbcTemplate;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class UserDaoImpl implements UserDao {

    @Override
    public int insert(User user) {
        if(user.getId() > 0)
            return update(user);
        else
            return create(user);
    }
    
    @Override
    public int create(User user) {
        try {
            
            String sql = "insert into users (fullname, username, password, user_type) values (?,?,?,?)";
            
            PreparedStatement p = JdbcTemplate.getPreparedStatement(sql);

            int index = 0;

            p.setString(++index, user.getFullName());
            p.setString(++index, user.getUsername());
            p.setString(++index, user.getPassword());
            p.setInt(++index, user.getUserType());

            return JdbcTemplate.executeUpdate(p);

        } catch (SQLException ex) {
            return 0;
        }
    }

    @Override
    public int update(User user) {
        try {
            String sql = "update user set "
                    + "fullname = ?, username = ?, password = ?,"
                    + "user_type = ? where id = ?";
            
            PreparedStatement p = JdbcTemplate.getPreparedStatement(sql);

            int index = 0;

            p.setString(++index, user.getFullName());
            p.setString(++index, user.getUsername());
            p.setString(++index, user.getPassword());
            p.setInt(++index, user.getUserType());
            p.setInt(++index, user.getId());

            return JdbcTemplate.executeUpdate(p);

        } catch (SQLException ex) {
            return 0;
        }
    }

    @Override
    public User get(int id) {
        User inq = null;
        try {
            String sql = "select * from user where id = ?";
            PreparedStatement p = JdbcTemplate.getPreparedStatement(sql);
            p.setInt(1, id);
            ResultSet r = JdbcTemplate.executeQuery(p);
            
            if(r.next()){
                inq = new User(
                    r.getInt("id"),r.getInt("user_type"),r.getString("fullname"),
                    r.getString("username"),r.getString("password")
                );
            }
            
        } catch (SQLException ex) {
            return null;
        }
        return inq;
    }

    @Override
    public ArrayList<User> getAll() {
        ArrayList<User> list = null;
        try {
            String sql = "select * from user";
            ResultSet r = JdbcTemplate.executeQuery(sql);
            
            while (r.next()) {
                list.add(new User(
                    r.getInt("id"),r.getInt("user_type"),r.getString("fullname"),
                    r.getString("username"),r.getString("password")
                ));
                
            }
            
        } catch (SQLException ex) {
            return null;
        }
        return list;
    }

    @Override
    public ArrayList<User> find() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id) {
        try {
            
            String sql = "delete from user where id = ?";
            PreparedStatement p = JdbcTemplate.getPreparedStatement(sql);
            p.setInt(1, id);
            JdbcTemplate.execute(p);

        } catch (SQLException e) {
        }
    }
    
}

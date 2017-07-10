/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cesar.renda.dao.impl;

import com.cesar.renda.bean.Senhorio;
import com.cesar.renda.dao.SenhorioDao;
import com.cesar.renda.dao.jdbc.JdbcTemplate;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class SenhorioDaoImpl implements SenhorioDao {

    @Override
    public int insert(Senhorio senhorio) {
        if(senhorio.getId() > 0)
            return update(senhorio);
        else
            return create(senhorio);
    }
    
    @Override
    public int create(Senhorio senhorio) {
        try {
            
            String sql = "insert into senhorio ( nome, sexo, data_nascimento, doc_identificacao, num_documento, nacionalidade,contato) values (?,?,?,?,?,?,?)";
            PreparedStatement p = JdbcTemplate.getPreparedStatement(sql);

            int index = 0;

            p.setString(++index, senhorio.getNome());
            p.setString(++index, senhorio.getSexo());
            p.setDate(++index, (Date) senhorio.getDataNascimento());
            p.setString(++index, senhorio.getDocIdentificacao());
            p.setString(++index, senhorio.getNumDoc());
            p.setString(++index, senhorio.getNacionalidade());
            p.setString(++index, senhorio.getContato());

            return JdbcTemplate.executeUpdate(p);

        } catch (SQLException ex) {
            return 0;
        }
    }

    @Override
    public int update(Senhorio senhorio) {
        try {
            String sql = "update senhorio set "
                    + "nome = ?, sexo = ?, data_nascimento = ?,"
                    + "doc_identificacao = ?, num_documento = ?, nacionalidade = ?, contato = ? where id = ?";
            
            PreparedStatement p = JdbcTemplate.getPreparedStatement(sql);

            int index = 0;

            p.setString(++index, senhorio.getNome());
            p.setString(++index, senhorio.getSexo());
            p.setDate(++index, (Date) senhorio.getDataNascimento());
            p.setString(++index, senhorio.getDocIdentificacao());
            p.setString(++index, senhorio.getNumDoc());
            p.setString(++index, senhorio.getNacionalidade());
            p.setString(++index, senhorio.getContato());
            p.setInt(++index, senhorio.getId());

            return JdbcTemplate.executeUpdate(p);

        } catch (SQLException ex) {
            return 0;
        }
    }

    @Override
    public Senhorio get(int id) {
        Senhorio inq = null;
        try {
            String sql = "select * from senhorio where id = ?";
            PreparedStatement p = JdbcTemplate.getPreparedStatement(sql);
            p.setInt(1, id);
            ResultSet r = JdbcTemplate.executeQuery(p);
            
            if(r.next()){
                inq = new Senhorio(
                    r.getInt("id"),r.getString("nome"),r.getString("sexo"),
                    r.getDate("data_nascimento"),r.getString("doc_identicicacao"),
                    r.getString("num_documento"),r.getString("nacionalidade"),r.getString("contato")
                );
            }
            
        } catch (SQLException ex) {
            return null;
        }
        return inq;
    }

    @Override
    public ArrayList<Senhorio> getAll() {
        ArrayList<Senhorio> list = null;
        try {
            String sql = "select * from senhorio";
            ResultSet r = JdbcTemplate.executeQuery(sql);
            
            while (r.next()) {
                list.add(new Senhorio(
                    r.getInt("id"),r.getString("nome"),r.getString("sexo"),
                    r.getDate("data_nascimento"),r.getString("doc_identicicacao"),
                    r.getString("num_documento"),r.getString("nacionalidade"),r.getString("contato")
                ));
                
            }
            
        } catch (SQLException ex) {
            return null;
        }
        return list;
    }

    @Override
    public ArrayList<Senhorio> find() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id) {
        try {
            String sql = "delete from senhorio where id = ?";
            PreparedStatement p = JdbcTemplate.getPreparedStatement(sql);
            p.setInt(1, id);
            JdbcTemplate.execute(p);

        } catch (SQLException e) {
        }
    }
    
}

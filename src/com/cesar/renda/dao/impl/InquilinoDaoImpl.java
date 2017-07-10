/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cesar.renda.dao.impl;

import com.cesar.renda.bean.Inquilino;
import com.cesar.renda.dao.InquilinoDao;
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
public class InquilinoDaoImpl implements InquilinoDao {

    @Override
    public int insert(Inquilino inquilino) {
        if(inquilino.getId() > 0)
            return update(inquilino);
        else
            return create(inquilino);
    }
    
    @Override
    public int create(Inquilino inquilino) {
        try {
            
            String sql = "insert into inquilino ( nome, sexo, data_nascimento, doc_identificacao, num_documento, nacionalidade,contato) values (?,?,?,?,?,?,?)";
            PreparedStatement p = JdbcTemplate.getPreparedStatement(sql);

            int index = 0;

            p.setString(++index, inquilino.getNome());
            p.setString(++index, inquilino.getSexo());
            p.setDate(++index, (Date) inquilino.getDataNascimento());
            p.setString(++index, inquilino.getDocIdentificacao());
            p.setString(++index, inquilino.getNumDoc());
            p.setString(++index, inquilino.getNacionalidade());
            p.setString(++index, inquilino.getContato());

            return JdbcTemplate.executeUpdate(p);

        } catch (SQLException ex) {
            return 0;
        }
    }

    @Override
    public int update(Inquilino inquilino) {
        try {
            String sql = "update inquilino set "
                    + "nome = ?, sexo = ?, data_nascimento = ?,"
                    + "doc_identificacao = ?, num_documento = ?, nacionalidade = ?, contato = ? where id = ?";
            
            PreparedStatement p = JdbcTemplate.getPreparedStatement(sql);

            int index = 0;

            p.setString(++index, inquilino.getNome());
            p.setString(++index, inquilino.getSexo());
            p.setDate(++index, (Date) inquilino.getDataNascimento());
            p.setString(++index, inquilino.getDocIdentificacao());
            p.setString(++index, inquilino.getNumDoc());
            p.setString(++index, inquilino.getNacionalidade());
            p.setString(++index, inquilino.getContato());
            p.setInt(++index, inquilino.getId());

            return JdbcTemplate.executeUpdate(p);

        } catch (SQLException ex) {
            return 0;
        }
    }

    @Override
    public Inquilino get(int id) {
        Inquilino inq = null;
        try {
            String sql = "select * from inquilino where id = ?";
            PreparedStatement p = JdbcTemplate.getPreparedStatement(sql);
            p.setInt(1, id);
            ResultSet r = JdbcTemplate.executeQuery(p);
            
            if(r.next()){
                inq = new Inquilino(
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
    public ArrayList<Inquilino> getAll() {
        ArrayList<Inquilino> list = null;
        try {
            String sql = "select * from inquilino";
            ResultSet r = JdbcTemplate.executeQuery(sql);
            
            while (r.next()) {
                list.add(new Inquilino(
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
    public ArrayList<Inquilino> find() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id) {
        try {
            String sql = "delete from inquilino where id = ?";
            PreparedStatement p = JdbcTemplate.getPreparedStatement(sql);
            p.setInt(1, id);
            JdbcTemplate.execute(p);

        } catch (SQLException e) {
        }
    }

    

}

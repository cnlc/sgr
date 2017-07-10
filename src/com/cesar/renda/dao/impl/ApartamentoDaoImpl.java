/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cesar.renda.dao.impl;

import com.cesar.renda.bean.Apartamento;
import com.cesar.renda.dao.ApartamentoDao;
import com.cesar.renda.dao.jdbc.JdbcTemplate;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class ApartamentoDaoImpl implements ApartamentoDao {

    @Override
    public int insert(Apartamento apartamento) {
        if(apartamento.getId() > 0)
            return update(apartamento);
        else
            return create(apartamento);
    }
    
    @Override
    public int create(Apartamento apartamento) {
        try {
            String sql = "insert into apartamento ( num_quarto, area, piso, tipo, descricao, ref_quarto) values (?,?,?,?,?,?)";
            PreparedStatement p = JdbcTemplate.getPreparedStatement(sql);

            int index = 0;

            p.setInt(++index, apartamento.getNumQuartos());
            p.setString(++index, apartamento.getArea());
            p.setString(++index, apartamento.getPiso());
            p.setString(++index, apartamento.getTipo());
            p.setString(++index, apartamento.getDescricao());
            p.setString(++index, apartamento.getRef_quarto());

            return JdbcTemplate.executeUpdate(p);

        } catch (SQLException ex) {
            return 0;
        }
    }

    @Override
    public int update(Apartamento apartamento) {
        try {
            String sql = "update apartamento set "
                    + "num_quarto = ?, area = ?, piso = ?, "
                    + "tipo = ?, descricao = ?, ref_quarto = ? where id = ?";
            
            PreparedStatement p = JdbcTemplate.getPreparedStatement(sql);

            int index = 0;

            p.setInt(++index, apartamento.getNumQuartos());
            p.setString(++index, apartamento.getArea());
            p.setString(++index, apartamento.getPiso());
            p.setString(++index, apartamento.getTipo());
            p.setString(++index, apartamento.getDescricao());
            p.setString(++index, apartamento.getRef_quarto());
            p.setInt(++index, apartamento.getId());

            return JdbcTemplate.executeUpdate(p);

        } catch (SQLException ex) {
            return 0;
        }
    }

    @Override
    public Apartamento get(int id) {
        Apartamento ap = null;
        try {
            String sql = "select * from apartamento where id = ?";
            PreparedStatement p = JdbcTemplate.getPreparedStatement(sql);
            p.setInt(1, id);
            ResultSet r = JdbcTemplate.executeQuery(p);
            
            if(r.next()){
                ap = new Apartamento(
                    r.getInt("id"),r.getInt("num_quartos"), r.getString("area"),
                    r.getString("piso"), r.getString("tipo"), r.getString("descricao"), 
                    r.getString("ref_quarto")
                );
            }
            
        } catch (SQLException ex) {
            return null;
        }
        return ap;
    }

    @Override
    public ArrayList<Apartamento> getAll() {
        ArrayList<Apartamento> list = null;
        try {
            String sql = "select * from apartamento";
            ResultSet r = JdbcTemplate.executeQuery(sql);
            
            while (r.next()) {
                list.add(new Apartamento(
                    r.getInt("id"),r.getInt("num_quartos"), r.getString("area"),
                    r.getString("piso"), r.getString("tipo"), r.getString("descricao"), 
                    r.getString("ref_quarto")
                ));
                
            }
            
        } catch (SQLException ex) {
            return null;
        }
        return list;
    }

    @Override
    public ArrayList<Apartamento> find() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id) {
        try {
            String sql = "delete from apartamento where id = ?";
            PreparedStatement p = JdbcTemplate.getPreparedStatement(sql);
            p.setInt(1, id);
            JdbcTemplate.execute(p);

        } catch (SQLException e) {
        }
    }

    

}

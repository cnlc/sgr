/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cesar.renda.dao.impl;

import com.cesar.renda.bean.Contrato;
import com.cesar.renda.dao.ContratoDao;
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
public class ContratoDaoImpl implements ContratoDao {

    @Override
    public int insert(Contrato contrato) {
        if(contrato.getId() > 0)
            return update(contrato);
        else
            return create(contrato);
    }
    
    @Override
    public int create(Contrato contrato) {
        try {
            
            String sql = "insert into contrato ( data_assinatura, data_termino, data_vencimento_renda, id_apartamento, id_inquilino, id_senhorio,termos) values (?,?,?,?,?,?,?)";
            PreparedStatement p = JdbcTemplate.getPreparedStatement(sql);

            int index = 0;

            p.setDate(++index, (Date) contrato.getDataAssinatura());
            p.setDate(++index, (Date) contrato.getDataTermino());
            p.setDate(++index, (Date) contrato.getDataVencimentoRenda());
            p.setInt(++index, contrato.getIdApartamento());
            p.setInt(++index, contrato.getIdInquilino());
            p.setInt(++index, contrato.getIdSenhorio());
            p.setString(++index, contrato.getTermos());

            return JdbcTemplate.executeUpdate(p);

        } catch (SQLException ex) {
            return 0;
        }
    }

    @Override
    public int update(Contrato contrato) {
        try {
            String sql = "update contrato set "
                    + "data_assinatura = ?, data_termino = ?, data_vencimento_renda = ?,"
                    + "id_apartamento = ?, id_inquilino = ?, id_senhorio = ?, termos = ? where id = ?";
            
            PreparedStatement p = JdbcTemplate.getPreparedStatement(sql);

            int index = 0;

            p.setDate(++index, (Date) contrato.getDataAssinatura());
            p.setDate(++index, (Date) contrato.getDataTermino());
            p.setDate(++index, (Date) contrato.getDataVencimentoRenda());
            p.setInt(++index, contrato.getIdApartamento());
            p.setInt(++index, contrato.getIdInquilino());
            p.setInt(++index, contrato.getIdSenhorio());
            p.setString(++index, contrato.getTermos());

            return JdbcTemplate.executeUpdate(p);

        } catch (SQLException ex) {
            return 0;
        }
    }

    @Override
    public Contrato get(int id) {
        Contrato inq = null;
        try {
            String sql = "select * from contrato where id = ?";
            PreparedStatement p = JdbcTemplate.getPreparedStatement(sql);
            p.setInt(1, id);
            ResultSet r = JdbcTemplate.executeQuery(p);
            
            if(r.next()){
                inq = new Contrato(
                    r.getInt("id"),r.getDate("data_assinatura"),r.getInt("id_apartamento"),
                    r.getInt("id_inquilino"),r.getInt("id_senhorio"),r.getString("termos"),
                    r.getDate("data_termino"),r.getDate("data_vencimento_renda")
                );
                
            }
            
        } catch (SQLException ex) {
            return null;
        }
        return inq;
    }

    @Override
    public ArrayList<Contrato> getAll() {
        ArrayList<Contrato> list = null;
        try {
            String sql = "select * from contrato";
            ResultSet r = JdbcTemplate.executeQuery(sql);
            
            while (r.next()) {
                list.add(new Contrato(
                    r.getInt("id"),r.getDate("data_assinatura"),r.getInt("id_apartamento"),
                    r.getInt("id_inquilino"),r.getInt("id_senhorio"),r.getString("termos"),
                    r.getDate("data_termino"),r.getDate("data_vencimento_renda")
                ));
                
            }
            
        } catch (SQLException ex) {
            return null;
        }
        return list;
    }

    @Override
    public ArrayList<Contrato> find() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id) {
        try {
            String sql = "delete from contrato where id = ?";
            PreparedStatement p = JdbcTemplate.getPreparedStatement(sql);
            p.setInt(1, id);
            JdbcTemplate.execute(p);

        } catch (SQLException e) {
        }
    }
    
}

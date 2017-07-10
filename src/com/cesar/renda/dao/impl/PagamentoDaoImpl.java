/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cesar.renda.dao.impl;

import com.cesar.renda.bean.Pagamento;
import com.cesar.renda.dao.PagamentoDao;
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
public class PagamentoDaoImpl implements PagamentoDao {

    @Override
    public int insert(Pagamento pagamento) {
        if(pagamento.getId() > 0)
            return update(pagamento);
        else
            return create(pagamento);
    }
    
    @Override
    public int create(Pagamento pagamento) {
        try {
            
            String sql = "insert into pagamento (data_pagamento, valor_pago, pagamento_mes, pagamento_ano, id_contrato, id_inquilino) values (?,?,?,?,?,?)";
            PreparedStatement p = JdbcTemplate.getPreparedStatement(sql);

            int index = 0;

            p.setDate(++index, (Date) pagamento.getDataPagamento());
            p.setFloat(++index, pagamento.getValorPago());
            p.setString(++index, pagamento.getPagamentoMes());
            p.setString(++index, pagamento.getPagamentoAno());
            p.setInt(++index, pagamento.getIdContrato());
            p.setInt(++index, pagamento.getIdInquilino());

            return JdbcTemplate.executeUpdate(p);

        } catch (SQLException ex) {
            return 0;
        }
    }

    @Override
    public int update(Pagamento pagamento) {
        try {
            String sql = "update pagamento set "
                    + "data_pagamento = ?, valor_pago = ?, pagamento_mes = ?, pagamento_ano = ?, "
                    + "id_contrato = ?, id_inquilino = ? where id = ?";
            
            PreparedStatement p = JdbcTemplate.getPreparedStatement(sql);

            int index = 0;

            p.setDate(++index, (Date) pagamento.getDataPagamento());
            p.setFloat(++index, pagamento.getValorPago());
            p.setString(++index, pagamento.getPagamentoMes());
            p.setString(++index, pagamento.getPagamentoAno());
            p.setInt(++index, pagamento.getIdContrato());
            p.setInt(++index, pagamento.getIdInquilino());
            p.setInt(++index, pagamento.getId());

            return JdbcTemplate.executeUpdate(p);

        } catch (SQLException ex) {
            return 0;
        }
    }

    @Override
    public Pagamento get(int id) {
        Pagamento inq = null;
        try {
            String sql = "select * from pagamento where id = ?";
            PreparedStatement p = JdbcTemplate.getPreparedStatement(sql);
            p.setInt(1, id);
            ResultSet r = JdbcTemplate.executeQuery(p);
            
            if(r.next()){
                inq = new Pagamento(
                    r.getInt("id"),r.getInt("id_inquilino"),r.getInt("id_contrato"),r.getFloat("valor_pago"),
                    r.getDate("data_pagamento"),r.getString("pagamento_mes"),r.getString("pagamento_ano")
                );
                
            }
            
        } catch (SQLException ex) {
            return null;
        }
        return inq;
    }

    @Override
    public ArrayList<Pagamento> getAll() {
        ArrayList<Pagamento> list = null;
        try {
            String sql = "select * from pagamento";
            ResultSet r = JdbcTemplate.executeQuery(sql);
            
            while (r.next()) {
                list.add(new Pagamento(
                    r.getInt("id"),r.getInt("id_inquilino"),r.getInt("id_contrato"),r.getFloat("valor_pago"),
                    r.getDate("data_pagamento"),r.getString("pagamento_mes"),r.getString("pagamento_ano")
                ));
                
            }
            
        } catch (SQLException ex) {
            return null;
        }
        return list;
    }

    @Override
    public ArrayList<Pagamento> find() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id) {
        try {
            String sql = "delete from pagamento where id = ?";
            PreparedStatement p = JdbcTemplate.getPreparedStatement(sql);
            p.setInt(1, id);
            JdbcTemplate.execute(p);

        } catch (SQLException e) {
        }
    }
    
}

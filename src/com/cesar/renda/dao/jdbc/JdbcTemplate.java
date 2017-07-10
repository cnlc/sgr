/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cesar.renda.dao.jdbc;

import com.cesar.utils.Config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author User
 */
public class JdbcTemplate {

    private static Connection conn = null;
    private static Statement stmt = null;
    private static PreparedStatement pstmt = null;
    private static ResultSet rset = null;
    private static int id = 0;

    /**
     *
     * @return @throws ClassNotFoundException
     */
    public static Connection getConnection() throws ClassNotFoundException {
        try {
            Class.forName(Config.DATABASE_CLASS);
            if (conn == null) {
                conn = DriverManager.getConnection(Config.DATABASE_DRIVER_OPEN, Config.DATABASE_USER, Config.DATABASE_PASSWORD);
            }
            return conn;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     *
     * @param conn
     */
    public static void closeConnection(Connection conn) {
        try {
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     *
     * @return
     */
    public static Statement getStatement() {
        try {
            if (stmt == null) {
                stmt = getConnection().createStatement();
            }
            return stmt;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     *
     * @param sql
     * @return
     */
    public static PreparedStatement getPreparedStatement(String sql) {
        try {
            pstmt = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            return pstmt;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     *
     */
    public static void close() {
        try {
            if (pstmt != null) {
                pstmt.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void close(Object o) {
        try {
            if (o instanceof ResultSet) {
                ((ResultSet) o).close();
            }
            if (o instanceof PreparedStatement) {
                ((PreparedStatement) o).close();
            }
            if (o instanceof Statement) {
                ((Statement) o).close();
            }
            if (o instanceof Connection) {
                ((Connection) o).close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void closeDatabaseConnection() {
        try {
            close();
            DriverManager.getConnection(Config.DATABASE_DRIVER_CLOSE, Config.DATABASE_USER, Config.DATABASE_PASSWORD);
        } catch (SQLException e) {
        }
    }

    /**
     *
     * @param sql
     * @return
     */
    public static int executeUpdate(String sql) {
        try {
            id = getStatement().executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return id;
    }

    /**
     *
     * @param pstmt
     * @return
     */
    public static int executeUpdate(PreparedStatement pstmt) {
        try {
            pstmt.executeUpdate();
            if ((rset = pstmt.getGeneratedKeys()).next())
                id = rset.getInt(1);
            close(pstmt);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return id;
    }

    /**
     *
     * @param pstmt
     * @return
     */
    public static ResultSet executeQuery(PreparedStatement pstmt) {
        try {
            rset = pstmt.executeQuery();
            close(pstmt);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rset;
    }
    
    public static void execute(PreparedStatement pstmt) {
        try {
            pstmt.execute();
            close(pstmt);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     *
     * @param sql
     * @param prepare
     * @return
     */
    public static ResultSet executeQuery(String sql, boolean prepare) {
        try {
            if (prepare) {
                rset = getPreparedStatement(sql).executeQuery();
            } else {
                rset = getStatement().executeQuery(sql);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rset;
    }

    /**
     *
     * @param sql
     * @return
     */
    public static ResultSet executeQuery(String sql) {
        return executeQuery(sql, true);
    }
}

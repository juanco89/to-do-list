
package com.juanco.todo.modelo.jdbc.dao;

import com.juanco.todo.modelo.jdbc.db.ConnDB;
import com.juanco.todo.modelo.jdbc.dto.Tarea;
import com.juanco.todo.util.Logg;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Dao para la tabla TAREA.
 * 
 * Se construye este DAO usando JDBC sencillo.
 * 
 * @author Juan C. Orozco <juanco89@gmail.com>
 */
public class TareaDao {

    private final Connection conn;
    
    public TareaDao() {
        conn = ConnDB.getConn();
    }
    
    public List<Tarea> buscarTodo() {
        List<Tarea> lista = null;
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("select * from tarea order by realizado, id");
            
            lista = new ArrayList<>();
            Tarea a;
            while(rs.next()) {
                a = new Tarea();
                a.setId(rs.getInt("id"));
                a.setFecha(rs.getDate("fecha"));
                a.setDescripcion(rs.getString("descripcion"));
                a.setRealizado(rs.getBoolean("realizado"));
                
                lista.add(a);
            }
        } catch (SQLException ex) {
            Logg.registrar(ex.getLocalizedMessage());
        }
        return lista;
    }
}

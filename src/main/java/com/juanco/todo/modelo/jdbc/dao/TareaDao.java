
package com.juanco.todo.modelo.jdbc.dao;

import com.juanco.todo.modelo.jdbc.db.ConnDB;
import com.juanco.todo.modelo.jdbc.dto.Tarea;
import com.juanco.todo.util.Logg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
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
    
    /**
     * Consulta todas las tareas almacenadas
     * @return List<Tarea> - Lista de tareas con los datos encontrados.
     */
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
                a.setFecha(rs.getTimestamp("fecha"));
                a.setDescripcion(rs.getString("descripcion"));
                a.setRealizado(rs.getBoolean("realizado"));
                
                lista.add(a);
            }
            statement.close();
        } catch (SQLException ex) {
            Logg.registrar(ex.getLocalizedMessage());
        }
        return lista;
    }

    /**
     * Almacena la informacion de una tarea en base de datos.
     * 
     * @param dto - Tarea - Dto con los datos a insertar. 
     * @return boolean - Indica si la operación fue exitosa.
     * @throws SQLException
     */
	public boolean insertar(Tarea dto) throws SQLException {
		if(dto == null) return false;
		
		String sql = "INSERT INTO tarea "
				+ " (fecha, descripcion, realizado) "
				+ " VALUES (?, ?, ?)";
		try(PreparedStatement statement = conn.prepareStatement(sql)) {
			conn.setAutoCommit(false);
			statement.setTimestamp(1, new Timestamp(dto.getFecha().getTime()));
			statement.setString(2, dto.getDescripcion());
			statement.setBoolean(3, dto.isRealizado());
			
			int r = statement.executeUpdate();
			conn.commit();
			
			return r == 1;
		}catch(Exception e) {
			Logg.registrar(e.getLocalizedMessage());
			return false;
		}finally {
			conn.setAutoCommit(true);
		}
	}

	/**
	 * Actualiza la tarea con id=id marcandola como realizada.
	 * @param id - Identificador de la tarea.
	 * @return boolean - Indica si el proceso fue exitoso.
	 * @throws SQLException
	 */
	public boolean marcarComoRealizada(int id) throws SQLException {
		String sql = "UPDATE tarea "
				+ " SET realizado = true "
				+ " WHERE id = ?";
		try(PreparedStatement statement = conn.prepareStatement(sql)) {
			conn.setAutoCommit(false);
			statement.setInt(1, id);
			
			int r = statement.executeUpdate();
			conn.commit();
			
			return r == 1;
		}catch(Exception e) {
			Logg.registrar(e.getLocalizedMessage());
			return false;
		}finally {
			conn.setAutoCommit(true);
		}
	}
}

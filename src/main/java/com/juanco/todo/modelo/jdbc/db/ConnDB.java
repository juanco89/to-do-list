
package com.juanco.todo.modelo.jdbc.db;

import com.juanco.todo.util.Logg;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase encargada de proporcionar la conexión a la base de datos.
 * 
 * @author Juan C. Orozco <juanco89@gmail.com>
 */
public class ConnDB {

    private static final String DB_NAME = "to-do";
    private static final String DB_USER = "postgres";
    private static final String DB_HOST = "localhost";
    private static final String DB_SECRET = "plokijuh";
    
    private static Connection conn;
    
    private ConnDB() {
    }
    
    public static Connection getConn() {
        if(conn == null) {
            try {
                Class.forName("org.postgresql.Driver");
                conn = DriverManager.getConnection("jdbc:postgresql://" + DB_HOST + "/" + DB_NAME, 
                        DB_USER, DB_SECRET);
            } catch (ClassNotFoundException | SQLException ex) {
                Logg.registrar(ex.getLocalizedMessage());
            }
        }
        return conn;
    }
}


package com.juanco.todo.modelo.db;

import java.sql.Connection;
import java.sql.SQLException;
import org.junit.BeforeClass;
import org.junit.Test;
import com.juanco.todo.modelo.jdbc.db.ConnDB;
import static org.junit.Assert.*;

/**
 *
 * @author Juan C. Orozco <juanco89@gmail.com>
 */
public class ConnDBTest {
    
    public ConnDBTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }

    @Test
    public void testGetConn() throws SQLException {
        System.out.println("ConnDB.getConn");
        
        Connection conn = ConnDB.getConn();
        assertNotNull(conn);
        assertTrue(!conn.isClosed());
    }
}

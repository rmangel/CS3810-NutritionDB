/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package support;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author jgillham
 */
public class DataBaseManager {
    static {
        // Load Driver.
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        }
        // If an exception is generated then try removing the driver,
        //  closing the project, re-opening the project, and finally
        //  re-adding the driver.
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private Connection conn;
    private Statement stm;
    
    public DataBaseManager ( String connectionURL) throws SQLException {
         this.conn = DriverManager.getConnection(connectionURL);
         this.stm = conn.createStatement();
    }
    
    public ResultSet runStatement( String statement ) throws SQLException {
        return this.stm.executeQuery(statement);
    }
}

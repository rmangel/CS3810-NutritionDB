package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * This class wraps the data base connection. This class is a singleton meaning
 *  that only one DataBaseManager can exist at a time in the JVM.
 * 
 * @author Josh Gillham
 * @version 11-27-2013
 */
public class DataBaseManager {
    static private DataBaseManager instance = null;
    
    static public DataBaseManager getConnection(String connectionURL)
            throws SQLException {
        if ( instance != null ) {
            return instance;
        }
        return instance = new DataBaseManager(connectionURL);
    }
    /**
     * Check for the driver in the static constructor.
     *  This check is meant to be helpful more than necessary.
     */
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
    
    /** Holds the data base connection. */
    private Connection conn;
    /** Holds the statement. Used to execute SQL statements. */
    private Statement stm;
    
    /**
     * Constructions the class by attempting to connect to the data base.
     * 
     * @param connectionURL The URL points to the data base. It also holds
     *  information about the driver and optionally user names and passwords.
     * 
     * @throws SQLException The error thrown potentially when connecting to the
     *  data base fails.
     */
    public DataBaseManager ( String connectionURL) throws SQLException {
         this.conn = DriverManager.getConnection(connectionURL);
         this.stm = conn.createStatement();
    }
    
    /**
     * Attempts to execute the SQL statement.
     * 
     * @param statement the SQL statement.
     * 
     * @return The ResultSet contains the information returned by the SQL
     *  statement.
     * 
     * @throws SQLException The error is thrown when execution of a statement
     *  fails.
     */
    public ResultSet runStatement( String statement ) throws SQLException {
        return this.stm.executeQuery(statement);
    }
    
    /**
     * Cleans up data base resources such as connections.
     */
    public void dispose() {
        try {
            conn.close();
            stm.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    /**
     * Upon garbage collection, will try to clean up data base resources
     * 
     * @throws Throwable Handled by JVM.
     */
    @Override
    public void finalize() throws Throwable{
        super.finalize();
        this.dispose();
    }
}

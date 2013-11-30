package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This singleton class wraps the data base connection.
 * 
 * @author Josh Gillham
 * @version 11-27-2013
 */
public class DataBaseManager {    
    static private DataBaseManager instance = null;
    
    static public DataBaseManager getDataBase( String connectionURL )
            throws SQLException {
        if ( instance == null ) {
            instance = new DataBaseManager(connectionURL);
        }
        return instance;
        
    }
    
    static public DataBaseManager getDataBase( ) {
        return instance;
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
    private DataBaseManager ( String connectionURL) throws SQLException {
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
     * Attempts to execute the SQL update statement.
     * 
     * @param statement the SQL statement.
     * 
     * @return The value indicating success or failure.
     * 
     * @throws SQLException The error is thrown when execution of a statement
     *  fails.
     */
    public int runUpdateStatement( String statement ) throws SQLException {
        return this.stm.executeUpdate(statement);
    }
    
    /**
     * Tries to match the login credentials to a record in the data base.
     *
     * @param uname The user name.
     * @param password The password.
     *
     * @return True if the user name and password match or false otherwise.
     */
    public ResultSet getCredintials( String uname, String password ) {
        String sqlStatement =
                    "select Uname, Password, Fname,"
                    + " Lname from USERS Where uname ='"
                    + uname + "' and password ='"
                    + password + "'";
        ResultSet result;
        try {
            result = this.runStatement(sqlStatement);
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseManager.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return result;
    }
    
    public boolean testCanPrescribe( String uname ) {
        String sqlStatement2 = "SELECT DIETITION.USER_ID" +
                    " FROM DIETITION NATURAL JOIN USERS WHERE " +
                    "Users.Uname = '" + uname + "'";
        System.out.println(sqlStatement2);
        try {
            ResultSet result2 = this.runStatement(sqlStatement2);
            return result2.next();
        }
        catch ( SQLException ex ) {
            ex.printStackTrace();
        }
        return false;
    }
    
    /**
     * Gets a list of meals for date and user.
     * 
     * @param uname The user name.
     * @param date The date.
     * 
     * @return A list of meals.
     */
    public List<String> getMealsForDate( String uname, Date date ) {
      String query =
        "SELECT M.\"NAME\" " +
        "FROM USERS U " +
        "JOIN USERSELECTEDMEALS UM " +
        "ON U.USER_ID = UM.USER_ID " +
        "JOIN MEALS M " +
        "ON UM.MEAL_ID = M.MEAL_ID " +
        "WHERE UM.\"DATE\" = \'" +
          new SimpleDateFormat("yyyy-MM-dd").format(date) + "\' " +
        "AND U.UNAME = \'" + uname + "\'";
      System.out.println( query );
      try {
          List< String > ret = new LinkedList< String >();
          ResultSet result = this.runStatement(query);
          while ( result.next() ) {
            ret.add( result.getString( "NAME" ) );
          }
          return ret;
      }
      catch ( SQLException ex ) {
          ex.printStackTrace();
      }
      return null;
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

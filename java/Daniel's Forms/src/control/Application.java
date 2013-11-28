package control;

import java.sql.SQLException;
import model.DataBaseManager;

/**
 * The application class is the central for the application. It provides a
 *  store for application resources such as data base connections. This class is
 *  a singleton meaning only one instance of Application can exist in the JVM
 *  at a time.
 * 
 * @author Josh Gillham
 * @version 11-27-2013
 */
public class Application {
    
    /** Holds the reference to the application instance. */
    static public Application instance = null;
    
    /**
     * Constructs an instance of application if not already in existance.
     *  Otherwise, return the existing instance.
     * 
     * @param connectionURL The database connection string.
     * 
     * @return The instance of the application.
     * 
     * @throws SQLException The error occurs when forming the connection fails.
     */
    static public Application getApplication( String connectionURL )
            throws SQLException {
        if ( instance == null ) {
            instance = new Application( );
        }
        return instance;
    }
    
    /**
     * Accesses the instance of application.
     * 
     * @return The instance.
     */
    static public Application getApplication( ) {
        return instance;
    }
    
    /**
     * Provides a diagnostic tool to check for the driver being properly loaded.
     * 
     * @return True if the driver is successfully loaded or false otherwise.
     */
    static public boolean testDriver() {
        // Load Driver.
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            return true;
        }
        // If an exception is generated then try removing the driver,
        //  closing the project, re-opening the project, and finally
        //  re-adding the driver.
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}

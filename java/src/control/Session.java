package control;

import model.DataBaseManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * This singleton class holds the login session creditals. The singleton
 *  will create an instance only when the user name and password match the
 *  data base.
 *
 * @author Josh Gillham
 * @version 11-28-2013
 */
public class Session {
    /** Holds the single instance of the login session. */
    static private Session instance = null;

    /**
     * Creates a new session if one does not already exist.
     *
     * @param uname The user name.
     * @param password The password.
     *
     * @return a session if one already exists or a new session if the login 
     *  was successful. This function will return null upon unsuccessful login.
     */
    static public Session getSession( String uname, String password ) {
        if ( instance == null ) {
            DataBaseManager db = DataBaseManager.getDataBase();
            
            String fname;
            String lname;
            try {
                ResultSet result = db.getCredintials(uname, password);
                if ( result == null || !result.next() ) {
                    return instance;
                }
                fname = result.getString( "Fname" );
                lname = result.getString( "Lname" );
            }
            // Usually caused by changing database tables.
            catch ( SQLException ex ) {
                ex.printStackTrace();
                throw new UnsupportedOperationException(
                    "Table attributes have changed."
                );
            }
            boolean canPrescribe = db.testCanPrescribe(uname);
            instance =
                new Session( fname, lname, uname, password, canPrescribe );
        }
        return instance;
    }
    
    /**
     * Accesses the current session.
     */
    static public Session getSession( ) {
        return instance;
    }
    
    /**
     * Logs the user out.
     */
    static public boolean signOut() {
        instance = null;
        return true;
    }
    
    /** Holds the user name. */
    final private String uname;
    /** Holds the user password. */
    final private String password;
    /** Holds the first name. */
    private String fname;
    /** Holds the last name. */
    private String lname;
    /** True indicates dietitian privileges. */
    final public boolean canPrescribe;

    /**
     * Creates an instance of the class with login credentials.
     *
     * @param uname The user name.
     * @param password The password.
     */
    private Session( String fname, String lname,
            String uname, String password, boolean canPrescribe ) {
        this.uname = uname;
        this.password = password;
        this.fname = fname;
        this.lname = lname;
        this.canPrescribe = canPrescribe;
    }

    public String getFirstName() {
        return this.fname;
    }

    public String getLastName() {
        return this.lname;
    }
    
    public String getUserName() {
        return this.uname;
    }
}

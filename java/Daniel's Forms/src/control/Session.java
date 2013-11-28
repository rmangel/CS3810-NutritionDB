package control;

import model.DataBaseManager;

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
            if ( DataBaseManager.getDataBase().testCredintials(uname, password)) {
                instance = new Session( uname, password );
            }
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
    final public String uname;
    /** Holds the user password. */
    final public String password;

    /**
     * Creates an instance of the class with login credentials.
     *
     * @param uname The user name.
     * @param password The password.
     */
    private Session( String uname, String password ) {
        this.uname = uname;
        this.password = password;
    }
}

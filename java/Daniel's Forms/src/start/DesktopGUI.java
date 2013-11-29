/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package start;

import control.Application;
import model.DataBaseManager;
import java.sql.SQLException;
import java.sql.SQLNonTransientConnectionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.login;

/**
 *
 * @author ArcadeHitman
 */
public class DesktopGUI {

    private String userName;
    static final String DB_URL = "jdbc:derby://localhost:1527/testing";//for local testing
    //final String DB_URL = "jdbc:oracle:thin:@//cncsidb01.msudenver.edu:1521:DB01, S900723387, kYmyal5v";
    boolean login;

    /**
     * Boot straps a Desktop GUI application.
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if ( !Application.testDriver() ) {
            System.exit( 1 );
        }
        Application app;
        try {
            app = Application.getApplication( );
            DataBaseManager.getDataBase( DB_URL );
        }
        // Can occur when the server is not running or when the database name
        //  is not found.
        catch (SQLException ex) {
            Logger.getLogger(DesktopGUI.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            System.exit( 3 );
        }
        login form = new login();
        form.setVisible(true);
        System.out.println("the db url is " + DB_URL);
    }
    
}

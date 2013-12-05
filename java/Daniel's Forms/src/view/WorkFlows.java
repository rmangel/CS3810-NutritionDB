package view;

import control.Application;
import control.Session;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import model.DataBaseManager;

/**
 * Contains the GUI's shared methods.
 * 
 * @author Josh Gillham
 * @version 11-28-2013
 */
public class WorkFlows {
    /**
     * Logs the user into the database.
     * 
     * @param rootPane The form to associate message boxes with.
     * @param userN The user name.
     * @param pass The password.
     * 
     * @return True upon success or false otherwise.
     */
    public static boolean login(
            JRootPane rootPane, String userN, String pass ) {
        try {
            System.out.println("username is " + userN + " password is " + pass);
            if (userN.isEmpty() || pass.isEmpty()) {
                JOptionPane.showMessageDialog(rootPane,
                        "Enter username and password.", "Login error",
                        JOptionPane.ERROR_MESSAGE);
                return false;
            }

            Session session = Session.getSession( userN, pass );

            if ( session == null ) {
                JOptionPane.showMessageDialog(rootPane, 
                        "Username and/or password incorrect.", "Login error",
                        JOptionPane.ERROR_MESSAGE);
                return false;
            }
            String fname = session.getFirstName();
            String lname = session.getLastName();
            
            JOptionPane.showMessageDialog(rootPane, "Login Successful");
            viewMealPlanner();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(rootPane,
                    "There was an error login in."
                    + ex.getMessage(), "Login error",
                    JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
    
    public static boolean viewDietitionPanel() {
        Session session = Session.getSession();
        if ( session.canPrescribe ) {
            new dietitianhome( session.getFirstName(), session.getLastName() )
                    .setVisible(true);
            return true;
        }
        return false;
    }
    
    public static void signOut() {
        Session.signOut();
        new view.login().setVisible(true);
    }
    public static void viewMealPlanner() {
        Session session = Session.getSession();
        new usermain( session.getFirstName(), session.getLastName() )
                .setVisible(true);
    }
    
    
}

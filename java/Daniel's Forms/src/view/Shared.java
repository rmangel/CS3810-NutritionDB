package view;

import control.Application;
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
public class Shared {
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
            DataBaseManager db = DataBaseManager.getDataBase();
            String sqlStatement =
                    "select Uname, Password, Fname,"
                    + " Lname from USERS Where uname ='"
                    + userN + "' and password ='"
                    + pass + "'";
            System.out.println(sqlStatement);

            ResultSet result = db.runStatement(sqlStatement);

            if (!result.next()) {
                JOptionPane.showMessageDialog(rootPane, 
                        "Username and/or password incorrect.", "Login error",
                        JOptionPane.ERROR_MESSAGE);
                return false;
            }
            
            System.out.println(result.getString("Uname")
                    + " " + result.getString("Password"));
            String fname = result.getString("Fname");
            String lname = result.getString("Lname");
            String uname = result.getString("Uname");
            boolean login = true;
            
            JOptionPane.showMessageDialog(rootPane, "Login Successful");
            
            String sqlStatement2 = "SELECT DIETITION.USER_ID" +
                    " FROM DIETITION NATURAL JOIN USERS WHERE " +
                    "Users.Uname = '" + userN + "'";
            System.out.println(sqlStatement2);
            ResultSet result2 = db.runStatement(sqlStatement2);
            boolean canPrescribe = result2.next();
            System.out.println( "canPrescribe" + canPrescribe );
            if ( canPrescribe ) {
                dietitianhome dhome = new dietitianhome(fname, lname);
                dhome.setVisible(login);
            }
            else {
                usermain umain = new usermain(fname, lname);
                umain.setVisible(login);
            }
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
    
}

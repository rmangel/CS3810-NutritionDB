/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author ArcadeHitman
 */
public class JavaApplication1 {

    private String userName;
    final String DB_URL = "jdbc:derby://localhost:1527/testing";//for local testing
    //final String DB_URL = "jdbc:oracle:thin:@//cncsidb01.msudenver.edu:1521:DB01, S900723387, kYmyal5v";
    boolean login;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        }
        // If an exception is generated then try removing the driver,
        //  closing the project, re-opening the project, and finally
        //  re-adding the driver.
        catch (Exception e) {
            e.printStackTrace();
        }
        JavaApplication1 app = new JavaApplication1();
        login form = new login();
        form.setVisible(true);
        form.DB_URL = app.DB_URL;
        System.out.println("the db url is " + form.DB_URL);
        app.userName = form.returnUName();
        app.login = form.loginCheck();

        }
    
}

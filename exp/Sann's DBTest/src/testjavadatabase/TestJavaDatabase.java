/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testjavadatabase;
import java.sql.*;
import java.util.Scanner;

/**
 *
 * @author s2k
 */
public class TestJavaDatabase {
    String firstName, lastName, userName, gender, passkey;
    private int count;
    final String DB_URL = "jdbc:derby://localhost:1527/testing";
	public static void main(String[] args) {
            TestJavaDatabase test = new TestJavaDatabase();
            String DB_URL = test.DB_URL;

                int userCount;                
		
		try
		{
			Connection conn = DriverManager.getConnection(DB_URL);
			Statement stmt = conn.createStatement();
                        String sqlGetCount = "select count(*) from app.users";
                        ResultSet countResult = stmt.executeQuery(sqlGetCount);
                        countResult.next();                           
                        userCount = countResult.getInt(1);
                        test.count = userCount + 1;
                        System.out.println("There are " + userCount +" number of users.");
			String sqlStatement = "select Fname, Lname, Uname from APP.USERS" ;
			ResultSet result = stmt.executeQuery(sqlStatement);
			System.out.println("The result of the Users is: ");
			
			while(result.next())
			{
			System.out.println( result.getString("Fname") + " " + 
                                            result.getString("Lname") + " " +
                                            result.getString("Uname"));
			}
                        stmt.close();
			conn.close();
		}
		catch(Exception ex)
		{
			System.out.println("ERROR: " + ex.getMessage());
		}
                
                test.addUser();

	}
        private void addUser()
        {
            System.out.println("Hello this is the registration fourm.");
            System.out.println("Enter your first name.");
            Scanner keys = new Scanner(System.in);
            firstName = keys.nextLine();
            System.out.println("Enter your last name.");
            lastName = keys.nextLine();
            System.out.println("Enter a user name.");
            userName = keys.nextLine();
            System.out.println("Enter a password.");
            passkey = keys.nextLine();
            System.out.println("Indicate whether your male or female by typing in"
                    + " male or female");
            gender = keys.nextLine();
            System.out.println("Done registering!");
            
            try
		{
			Connection conn = DriverManager.getConnection(DB_URL);
			Statement stmt = conn.createStatement();
                        String sql = "INSERT INTO App.Users Values ('"
                                + firstName + "', '" + lastName + "', '"
                                + userName + "', '" + gender + "', '"
                                + passkey + "', " + count + ", NULL, NULL, NULL)";
                        stmt.executeUpdate(sql);
                        stmt.close();
			conn.close();
		}
		catch(Exception ex)
		{
			System.out.println("ERROR: " + ex.getMessage());
		}
            
            
        }

}


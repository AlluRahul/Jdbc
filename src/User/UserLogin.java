package User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UserLogin {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        // Step 1: Load the JDBC driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish a connection to the database
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?user=root&password=12345");

            // Step 3: Create a statement
            stmt = conn.createStatement();

            Scanner scanner = new Scanner(System.in);

            // Keep prompting until valid email is entered
            String email;
            System.out.print("Enter your : ");
                email = scanner.nextLine();
                

            // Keep prompting until valid password is entered
            String password;
                System.out.print("Enter your password: ");
                password = scanner.nextLine();
            

            // Step 4: Execute the SQL statement to check user credentials
            String query = "SELECT * FROM userdetails WHERE user_emailid = '" + email + "' AND user_password = '" + password + "'";
            rs = stmt.executeQuery(query);

            if (rs.next()) {
                System.out.println("Logged in successfully!");
            } else {
                System.out.println("Invalid email or password. Please try again.");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

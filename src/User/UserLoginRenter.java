package User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UserLoginRenter {
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
            System.out.print("Enter your email : ");
            email = scanner.nextLine();

            // Keep prompting until valid password is entered
            String password;
            System.out.print("Enter your password: ");
            password = scanner.nextLine();

            // Step 4: Execute the SQL statement to check user credentials
            String query = "SELECT * FROM userdetails WHERE user_emailid = '" + email + "' AND user_password = '" + password + "'";
            rs = stmt.executeQuery(query);

            // Step 5: Handle different cases and ask to re-enter if needed
            if (rs.next()) {
                System.out.println("Logged in successfully!");
            } else {
                // Check and prompt for re-entry
                if (!isValidEmail(email)) {
                    System.out.println("Invalid email. Please try again.");
                } else if (!isValidPassword(password)) {
                    System.out.println("Invalid password. Please try again.");
                } else {
                    System.out.println("Invalid email and password combination. Please try again.");
                }
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

    // Validate email format
    private static boolean isValidEmail(String email) {
        // Add your email validation logic here
        // For simplicity, a basic check is performed
        return email.contains("@");
    }

    // Validate password format
    private static boolean isValidPassword(String password) {
        // Add your password validation logic here
        // For simplicity, a basic check is performed (password length should be at least 6 characters)
        return password.length() <= 5;
    }
}

package User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdatePassword {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet resultSet = null;
        Scanner sc = new Scanner(System.in);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?useSSL=false", "root", "12345");

            // Use a PreparedStatement for parameterized queries
            stmt = connection.prepareStatement("SELECT id, password FROM userdetails WHERE email = ?");
            
            System.out.println("Enter your email:");
            String email = sc.next();
            
            // Set the parameter for the prepared statement
            stmt.setString(1, email);

            // Execute the query
            resultSet = stmt.executeQuery();

            if (resultSet.next()) {
                int userId = resultSet.getInt("id");
                String currentPassword = resultSet.getString("password");

                // Check the current password (you may want to use a secure password hashing mechanism)
                System.out.println("Enter your current password:");
                String enteredPassword = sc.next();

                if (currentPassword.equals(enteredPassword)) {
                    // Update the password
                    System.out.println("Enter your new password:");
                    String newPassword = sc.next();

                    String updateQuery = "UPDATE users SET password = ? WHERE id = ?";
                    try (PreparedStatement updateStatement = connection.prepareStatement(updateQuery)) {
                        updateStatement.setString(1, newPassword);
                        updateStatement.setInt(2, userId);

                        int rowsAffected = updateStatement.executeUpdate();

                        if (rowsAffected > 0) {
                            System.out.println("Password updated successfully");
                        } else {
                            System.out.println("Failed to update password");
                        }
                    }
                } else {
                    System.out.println("Incorrect current password");
                }
            } else {
                System.out.println("User not found");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the resources in the reverse order of their creation
            try {
                if (resultSet != null) resultSet.close();
                if (stmt != null) stmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

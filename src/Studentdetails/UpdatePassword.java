package Studentdetails;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdatePassword {

    // JDBC URL, username, and password of MySQL server
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/demo";
    private static final String DB_USER = "userdetails";
    private static final String DB_PASSWORD = "12345";

    public static void main(String[] args) {
        String email = "user@example.com";
        String newPassword = "newPassword123";

        try {
            // Connect to the database
            Connection connection = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD);

            // Check the existing password for the given email
            String selectQuery = "SELECT id, password FROM users WHERE email = ?";
            try (PreparedStatement selectStatement = connection.prepareStatement(selectQuery)) {
                selectStatement.setString(1, email);

                ResultSet resultSet = selectStatement.executeQuery();

                if (resultSet.next()) {
                    int userId = resultSet.getInt("id");
                    String currentPassword = resultSet.getString("password");

                    // Check the current password (you may want to use a secure password hashing mechanism)
                    if (currentPassword.equals("oldPassword123")) {
                        // Update the password
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
            }

            // Close the connection
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

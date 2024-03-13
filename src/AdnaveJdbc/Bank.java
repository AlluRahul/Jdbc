package AdnaveJdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
public class Bank {

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/bank";

    static final String USER = "root";
    static final String PASS = "12345";

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        Scanner scanner = new Scanner(System.in);

        try {
            // Register JDBC driver
            Class.forName(JDBC_DRIVER);

            // Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank?useSSL=false", "root", "12345");

            // SQL query to insert Bank user details
            String sql = "INSERT INTO Bank (FirstName, LastName, MobileNumber, Email, Password, Address, Amount) VALUES (?, ?, ?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);

            while (true) {
                // Take input from the user
                System.out.print("Enter First Name: ");
                String firstName = scanner.nextLine();

                System.out.print("Enter Last Name: ");
                String lastName = scanner.nextLine();

                System.out.print("Enter Mobile Number (10 digits): ");
                String mobileNumber = scanner.nextLine();

                // Validate mobile number
                if (isValidMobileNumber(mobileNumber)) {
                    // Create email based on the specified pattern
                    String email = firstName.toLowerCase() + mobileNumber.substring(7) + "@example.com";

                    // Validate and set password
                    System.out.print("Enter Password (5 digits): ");
                    String password = scanner.nextLine();
                    if (isValidPassword(password)) {
                        // Validate and set amount
                        System.out.print("Enter Address: ");
                        String address = scanner.nextLine();

                        System.out.print("Enter Amount: ");
                        double amount = scanner.nextDouble();

                        if (amount >= 0) {
                            pstmt.setString(1, firstName);
                            pstmt.setString(2, lastName);
                            pstmt.setString(3, mobileNumber);
                            pstmt.setString(4, email);
                            pstmt.setString(5, password);
                            pstmt.setString(6, address);
                            pstmt.setDouble(7, amount);

                            // Execute the update
                            pstmt.executeUpdate();

                            System.out.println("User details inserted successfully!");
                            break;  // exit the loop if the data is valid
                        } else {
                            System.out.println("Invalid amount. Amount should be a positive value. Please re-enter.");
                        }
                    } else {
                        System.out.println("Invalid password format. Please re-enter.");
                    }
                } else {
                    System.out.println("Invalid mobile number format. Please re-enter.");
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
                scanner.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    // Validate mobile number format (10 digits, only numbers)
    private static boolean isValidMobileNumber(String mobileNumber) {
        return mobileNumber.matches("\\d{10}");
    }

    // Validate password format (5 digits)
    private static boolean isValidPassword(String password) {
        return password.matches("\\d{5}");
    }
}
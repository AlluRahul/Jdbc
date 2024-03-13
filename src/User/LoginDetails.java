package User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;

public class LoginDetails {
	 static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        try {
            // Step 1: Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish a connection to the database
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?user=root&password=12345");

            // Step 3: Create a PreparedStatement
            preparedStatement = conn.prepareStatement("SELECT * FROM userdetails WHERE user_EmailId=? AND user_Password=?");

            while (true) {
                System.out.println("Enter your email:");
                String user_EmailId = sc.next();
                System.out.println("Enter your password:");
                String user_Password = sc.next();
                preparedStatement.setString(1, user_EmailId);
                preparedStatement.setString(2, user_Password);
                rs = preparedStatement.executeQuery();

                if (rs.next()) {
                    System.out.println("Details are valid and Generating OTP.....");
                    Random rd = new Random();
                    int generatedOtp = rd.nextInt(100000);
                    if (generatedOtp < 100000) {
                        generatedOtp += 100000;
                    } // Ensures a 6-digit number
                    System.out.println("Generated OTP: " + generatedOtp);

                 // ... (previous code)

                 // ... (previous code)

                    int maxAttempts = 3;
                    for (int attempt = 1; attempt <= maxAttempts; attempt++) {
                        try {
                            // Validate entered OTP
                            System.out.print("Enter your OTP: ");
                            int enteredOtp = sc.nextInt();

                            if (enteredOtp == generatedOtp) {
                                System.out.println("OTP is valid. Logging in...");

                                // Simulate a delay after successful login
                                Thread.sleep(3000); // Sleep for 3 seconds (3000 milliseconds)

                                // Your additional logic for successful login can go here
                                System.out.print(">");
                                Thread.sleep(3000);
                                System.out.print(">");
                                Thread.sleep(3000);
                                System.out.print(">");
                                Thread.sleep(3000);
                                System.out.print("! loggin succesfull !");
                                Thread.sleep(3000);
                                System.out.print("<");
                                Thread.sleep(3000);
                                System.out.print("<");
                                Thread.sleep(3000);
                                System.out.print("<");
                             // Call the method to get user details
                                getUserDetails(conn, user_EmailId);
                                break;
                                
                            } else {
                                System.out.println("Invalid OTP. Attempts left: " + (maxAttempts - attempt));
                            }
                        } catch (java.util.InputMismatchException e) {
                            // Handle the exception (e.g., print an error message and clear the scanner buffer)
                            System.out.println("Invalid input. Please enter a valid integer for OTP.");
                            sc.nextLine(); // Clear the scanner buffer
                        } catch (InterruptedException e) {
                            e.printStackTrace(); // Handle InterruptedException if needed
                        }
                    }

                    // ... (remaining code)

                    // ... (remaining code)

                    break;
                } else {
                    boolean invalidEmail = checkInvalidEmail(conn, user_EmailId);
                    boolean invalidPassword = checkInvalidPassword(conn, user_Password);

                    if (invalidEmail && invalidPassword) {
                        System.out.println("Invalid email and password. Try again.");
                    } else if (invalidEmail) {
                        System.out.println("Invalid email. Try again.");
                    } else if (invalidPassword) {
                        System.out.println("Invalid password. Try again.");
                    }

                    System.out.println("1. Retry\n2. Exit");
                    int choice = sc.nextInt();
                    if (choice == 2) {
                        System.out.println("Exiting login...");
                        break;
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (preparedStatement != null)
                    preparedStatement.close();
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private static boolean checkInvalidEmail(Connection conn, String userEmail) throws SQLException {
        String selectEmail = "SELECT * FROM userdetails WHERE user_EmailId=?";
        PreparedStatement emailStatement = conn.prepareStatement(selectEmail);
        emailStatement.setString(1, userEmail);
        ResultSet emailResult = emailStatement.executeQuery();
        return !emailResult.next();
    }

    private static boolean checkInvalidPassword(Connection conn, String userPassword) throws SQLException {
        String selectPassword = "SELECT * FROM userdetails WHERE user_Password=?";
        PreparedStatement passwordStatement = conn.prepareStatement(selectPassword);
        passwordStatement.setString(1, userPassword);
        ResultSet passwordResult = passwordStatement.executeQuery();
        return !passwordResult.next();
    }
    private static void getUserDetails(Connection conn, String userEmail) throws SQLException {
        String selectUserDetails = "SELECT * FROM userdetails WHERE user_EmailId=?";
        PreparedStatement userDetailsStatement = conn.prepareStatement(selectUserDetails);
        userDetailsStatement.setString(1, userEmail);
        ResultSet userDetailsResult = userDetailsStatement.executeQuery();

        if (userDetailsResult.next()) {
            int user_ID = userDetailsResult.getInt("user_ID");
            String user_FirstName = userDetailsResult.getString("User_firstname");
            String user_LastName = userDetailsResult.getString("User_lastname");
            String user_EmailId = userDetailsResult.getString("user_emailid");
            String user_PhoneNumber = userDetailsResult.getString("user_phonenumber");
            String user_Address = userDetailsResult.getString("user_address");
            double user_ammount = userDetailsResult.getDouble("user_ammount");

            // Print or use the user details as needed
            System.out.println("User Details:");
            System.out.println("User ID      :" + user_ID);
            System.out.println("First Name   :" + user_FirstName);
            System.out.println("Last Name    :" + user_LastName);
            System.out.println("Email ID     :" + user_EmailId);
            System.out.println("Phone Number :" + user_PhoneNumber);
            System.out.println("Address      :" + user_Address);
            
        System.out.println("1. AccountDetails \n2. Exit");
        int choice = sc.nextInt();
        if (choice == 1) {
            System.out.println("Ammount In Account " + user_ammount);
            System.out.println("1. Moreanydetails \n2. Exit");
            int choice1 = sc.nextInt();
            if (choice1 == 1) {
                System.out.println("Moreanydetails");
            }
            else if (choice1 == 2) {    
    			System.out.println("Exiting login...");
    		}
        }
        else if (choice == 2) {
			System.out.println("Exiting login...");
		}
        } else {
            System.out.println("User details not found.");
        } 
        
    }

}

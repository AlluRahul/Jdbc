//package Studentdetails;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//public class UpdateQuery {
//    public static void main(String[] args) {
//        Connection conn = null;
//        Statement stmt = null;
//
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?useSSL=false", "root", "12345");
//            stmt = conn.createStatement();
//
//            // Specify the new value for student_percentage
//            double newPercentage = 80.0;
//
//            // Update the record with student_id = 19
//            int rowsAffected = stmt.executeUpdate("UPDATE studentdetails SET student_percentage = " + newPercentage + " WHERE student_id = 19");
//
//            if (rowsAffected > 0) {
//                System.out.println(rowsAffected + " record(s) updated successfully.");
//            } else {
//                System.out.println("No records found for update.");
//            }
//
//            System.out.println("! Connection established !");
//        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (stmt != null)
//                    stmt.close();
//                if (conn != null)
//                    conn.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//}
package Studentdetails;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateQuery {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        Scanner scanner = new Scanner(System.in);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?useSSL=false", "root", "12345");
            stmt = conn.createStatement();

            System.out.print("Enter the new student percentage: ");
            double newPercentage = scanner.nextDouble();

            int rowsAffected = stmt.executeUpdate("UPDATE studentdetails SET student_percentage = " + newPercentage + " WHERE student_id = 19");

            if (rowsAffected > 0) {
                System.out.println(rowsAffected + " record(s) updated successfully.");
            } else {
                System.out.println("No records found for update.");
            }

            System.out.println("! Connection established !");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
                if (conn != null)
                    conn.close();
                scanner.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}


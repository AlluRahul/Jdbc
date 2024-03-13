package Studentdetails;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//public class DeleteQuery {
//	public static void main(String[] args) {
//		Connection conn = null;
//		Statement stmt = null;
//
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?useSSL=false", "root", "12345");
//			stmt = conn.createStatement();
//			int rs = stmt.executeUpdate("delete  studentdetails where student_percentage<35");
//			// Is Before is used true if the cursor is before the first row;
//			// false if the cursor is at any other position or the result set contains no
//			// rows
//			if (rs > 0) {
//				System.out.println(rs + " record(s) deleted successfully.");
//
//				// Additional code if needed inside the while loop
//				// while (rs.next()) {
//				// // Process each deleted record if needed
//				// }
//
//			} else {
//				System.out.println("No records found to delete.");
//			}
//
//			System.out.println("! Connection established !");
//		} catch (ClassNotFoundException | SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if (stmt != null)
//					stmt.close();
//				if (conn != null)
//					conn.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//	}
//}

//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//public class DeleteQuery {
//    public static void main(String[] args) {
//        Connection conn = null;
//        PreparedStatement selectStmt = null;
//        PreparedStatement deleteStmt = null;
//
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?useSSL=false", "root", "12345");
//
//            // Step 1: Select the rows you want to delete
//            String selectQuery = "SELECT * FROM studentdetails WHERE student_percentage < 35";
//            selectStmt = conn.prepareStatement(selectQuery);
//            ResultSet rs = selectStmt.executeQuery();
//
//            // Step 2: Print or process the selected rows
//            while (rs.next()) {
//                // Process each selected record if needed
//                System.out.println("Selected Record: " + rs.getString("student_name"));
//            }
//
//            // Step 3: Delete the selected rows
//            String deleteQuery = "DELETE FROM studentdetails WHERE student_percentage < 35";
//            deleteStmt = conn.prepareStatement(deleteQuery);
//            int rowsAffected = deleteStmt.executeUpdate();
//
//            System.out.println(rowsAffected + " record(s) deleted successfully.");
//
//            System.out.println("! Connection established !");
//        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (selectStmt != null)
//                    selectStmt.close();
//                if (deleteStmt != null)
//                    deleteStmt.close();
//                if (conn != null)
//                    conn.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//}


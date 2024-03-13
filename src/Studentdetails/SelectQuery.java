package Studentdetails;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectQuery {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?useSSL=false", "root", "12345");
			stmt = conn.createStatement();
			rs = stmt.executeQuery("Select * from studentdetails");
			// Is Before is used true if the cursor is before the first row;
			// false if the cursor is at any other position or the result set contains no
			// rows
			if (rs.isBeforeFirst()) {
				System.out.println("\t\tstudent_id\t\tstudent_name\t\tstudent_emailId\t\tstudent_percentage");
				while (rs.next()) {
					int student_id = rs.getInt("student_id");
					String student_name = rs.getString("student_name");
					String student_emailId = rs.getString("student_emailId");
					Double student_percentage = rs.getDouble("student_percentage");
					System.out.println("\t\t" + student_id + "\t\t" + student_name + "\t\t" + student_emailId + "\t\t"
							+ student_percentage);
				}
			} else {
				System.out.println("data not found ");
				System.out.println("connection not establish");
			}
			System.out.println("! Data Found !");
			System.out.println("!Connecion establish !");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}



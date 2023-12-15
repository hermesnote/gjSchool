package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

	public static void main(String[] args) {
//		DbConnection db = new DbConnection();
		System.out.println(DbConnection.getDb());
	}
	
	String name;
	
	public static Connection getDb() {
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/school";
		String user = "root";
		String passeord = "0000";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, passeord);
			System.out.println("Connected!");
		}catch(ClassNotFoundException e) {
			System.out.println("Driver Not Found!");
			e.printStackTrace();
		}catch(SQLException e) {
			System.out.println("Connect Fail!");
			e.printStackTrace();
		}
		return conn;
	}
}

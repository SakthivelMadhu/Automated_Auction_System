package com.masai.DAO;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

//public class DBUtils {
//    private static final String DB_URL = "jdbc:mysql://localhost:3306/auction_system";
//    private static final String DB_USER = "root";
//    private static final String DB_PASSWORD = "password";
//    
//    final static String URL;
//	final static String username;
//	final static String password;
//	
//	static {
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//		}catch(ClassNotFoundException ex) {
//			System.err.println("Fatal Error! Unable to start application");
//			System.exit(1);
//		}
//		
//		ResourceBundle bundle = ResourceBundle.getBundle("database");
//		
//		URL = bundle.getString("url");
//		username = bundle.getString("username");
//		password = bundle.getString("password");
//	}
//
//    private static Connection connection = null;
//
//    public static Connection getConnection() throws SQLException {
//        if (connection == null) {
//            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
//        }
//        return connection;
//    }
//
//    public static void closeConnection() throws SQLException {
//        if (connection != null) {
//            connection.close();
//            connection = null;
//        }
//    }
//
//    public static void closeResultSet(ResultSet rs) throws SQLException {
//        if (rs != null) {
//            rs.close();
//        }
//    }
//
//    public static void closeStatement(Statement stmt) throws SQLException {
//        if (stmt != null) {
//            stmt.close();
//        }
//    }
//}


public class DBUtils {
	private static String drivername;
	private static String url;
	private static String username;
	private static String password;
	
	static {
		ResourceBundle rb=ResourceBundle.getBundle("database");
		drivername=rb.getString("db.drivername");
		url=rb.getString("db.url");
		username=rb.getString("db.username");
		password=rb.getString("db.password");
	}
	
	public static Connection provideConnection() {
		Connection conn=null;
		
		try {
			Class.forName(drivername);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			conn=DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}
}

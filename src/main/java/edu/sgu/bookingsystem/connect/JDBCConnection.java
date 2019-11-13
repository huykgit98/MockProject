package edu.sgu.bookingsystem.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class JDBCConnection {

	//Database Driver
		private static final String driver = "com.mysql.jdbc.Driver";
		//url connected to database
		private static final String url = "jdbc:mysql://localhost:3306/mockproject1";
		//Database username
		private static final String username = "root";
		//Database password
		private static final String password = "";
		
		private static Connection conn=null;
		
		//static code block to load drive
//		static{
//			try{
//				Class.forName(driver);
//			}
//			catch(Exception e){
//				e.printStackTrace();
//			}
//		}
//		
//		//return database connection object
//		public static Connection getConnection() throws Exception
//		{
//			if(conn==null || conn.isClosed()){
//				conn = DriverManager.getConnection(url,username,password);
//				return conn;
//			}
//			return conn;
//		}
		
		
		public static Connection getConnection() {
			try {
				if (conn == null || conn.isClosed()) {
					try {
						// Register JDBC Driver
						Class.forName(driver);
						// Open Connection
						conn = DriverManager.getConnection(url,username,password);

					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return conn;
		}
		
//		public static void main(String[] args){
//			try{
//				Connection conn=JDBCConnection.getConnection();
//				if(conn!=null){
//					System.out.println("yes, ket noi thanh cong!");
//				}
//				else{
//					System.out.println("no, ket noi that cmn bai!");
//				}
//			}
//			catch(Exception e){
//				e.printStackTrace();
//			}
//		}
}
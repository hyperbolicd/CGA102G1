package com.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class JDBCUtil {
	public static final String DR = "com.mysql.cj.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/movietheater?serverTimezone=Asia/Taipei";
	// cloud
//	public static final String URL = "jdbc:mysql://35.194.154.140:23306/movietheater?serverTimezone=Asia/Taipei";
	public static final String USER = "root";
	public static final String PW = "password";
	
	static Connection con;
	
	static boolean useConnectionPool = true;
	
	public static Connection getConnection() throws SQLException, NamingException, ClassNotFoundException {
		if(useConnectionPool) {
			Context ctx = new javax.naming.InitialContext();
			DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/HireMe");
			con = ds.getConnection();
		} else {
			Class.forName(DR);
			con = DriverManager.getConnection(URL, USER, PW);
		}
		
		return con;
	}

}

package com.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.sql.DataSource;
// JDBC 共用資源
// 使用方式: 在 DAO 層用 con = JDBCUtil.getConnection(); 取得連線，記得要關資源or歸還連線 con.close();
public class JDBCUtil {
	public static final String DR = "com.mysql.cj.jdbc.Driver";
//	public static final String URL = "jdbc:mysql://localhost:3306/movietheater?serverTimezone=Asia/Taipei";
	// docker
	public static final String URL = "jdbc:mysql://dev-mysql:3306/movietheater?serverTimezone=Asia/Taipei";
	// GCP root 641641
//	public static final String URL = "jdbc:mysql://35.194.154.140:23306/movietheater?serverTimezone=Asia/Taipei";
	public static final String USER = "root";
	public static final String PW = "1qaz@WSX";
	
	static Connection con;
	
	// true = 使用連線池，false = 不使用連線池
	static boolean useConnectionPool = true;
	
	public static Connection getConnection() throws SQLException {
		if(useConnectionPool) { // 使用連線池
			Context ctx;
			DataSource ds = null;
			try {
				ctx = new javax.naming.InitialContext();
				ds = (DataSource)ctx.lookup("java:comp/env/jdbc/HireMe");
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			con = ds.getConnection();
		} else { // 不使用連線池
			try {
				Class.forName(DR);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			con = DriverManager.getConnection(URL, USER, PW);
		}
		
		return con;
	}

}

package com.song.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ArticleDB {
	String url = "jdbc:mysql://localhost:3306/test?ServerTimezone=UTC";
	String user = "root";
	String pass = "";
	String driver = "com.mysql.cj.jdbc.Driver";
	
	private Connection getConnection() {
		Connection conn = null;
		try{
			Class.forName(driver);
			conn = DriverManager.getConnection(url,user,pass);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	public void InsertData() {
		String sql = "INSERT INTO article SET title = '力格1', `body` = '郴侩', regDate = '累己老1'";
		Connection conn = getConnection();
		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}


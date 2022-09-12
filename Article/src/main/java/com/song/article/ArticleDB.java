package com.song.article;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ArticleDB {
	String uri = "jdbc:mysql://localhost::9000/article?serverTimezone=UTC";
	String user = "root";
	String pass = "";
	String driver = "com.mysql.cj.jdbc.Driver";
	
	private Connection getConnection() {
		Connection conn = null;
		
		try{
			Class.forName(driver);
			conn = DriverManager.getConnection(uri,user,pass);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public void InsertData() {
	
		String sql = "INSERT INTO article SET title = 'ȫ�浿', `body` = '�Խ��� ��', regDate = '2022-02-02', writer = 'ȫ�浿'";
		Connection conn = getConnection();
		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}

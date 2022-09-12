package com.song.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

public class ArticleDB {
	String url = "jdbc:mysql://localhost:3306/practice?serverTimezone=UTC";
	String user = "root";
	String pass = "";
	String driver = "com.mysql.cj.jdbc.Driver";
	
	private Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,user,pass);
		}catch(Exception e) {
			e.printStackTrace();
		}
			return conn;	
	}
	
	
	
	public ArrayList<Article> getArticleList(String sql){
		Connection conn = getConnection();
		ArrayList<Article> articleList = new ArrayList<>();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				int idx = rs.getInt("idx");
				String title = rs.getString("title");
				String body = rs.getString("body");
				String nickname = rs.getString("nickname");
				String regDate = rs.getString("regDate");
				Article List = new Article(idx,title,body,nickname,regDate);
				articleList.add(List);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return articleList;
	}
	//전체 게시물 가져오기
	public ArrayList<Article> getAllArticle(){
		String sql = "SELECT * FROM article";
		ArrayList<Article> articleList = getArticleList(sql);
		return articleList;
	}
	
	//게시물 한개 가져오기 뭐만?->인덱스로 구분해서 즉 게시물 1개 배열안쓴다 뭐쓰냐? 그냥 array쓴다
	public Article getArticleByIdx(int idx){
		Article article = null;
		String sql = String.format("SELECT * FROM article WHERE idx = %d",idx);
		ArrayList<Article> articles = getArticleList(sql);
		
		if(articles.size() > 0) {
			article = articles.get(0);
		}
		return article;
	}
	
	public void updateQuery(String sql) {
		Connection conn = getConnection();
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void updateArticle(int idx,String title, String body) {
		String sql = String.format("UPDTATE article SET title = '%s', 'body' = '%s' WHERE = %d",title,body,idx);
		updateQuery(sql);
	}
	
	public void InsertData(String title, String body, String nickname) {
		Connection conn = getConnection();
		try {
			String sql = String.format("INSERT INTO article SET title = '%s', `body` = '%s', nickname = '%s', regDate = now()",title,body,nickname);
			updateQuery(sql);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}



	
	
	
}

package com.song.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ArticleDB {
	String url = "jdbc:mysql://localhost:3306/b1?serverTimezone=UTC";
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
				String regDate = rs.getString("regDate");
				
				Article text = new Article(idx,title,body,regDate);
				articleList.add(text);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return articleList;

	}
	public ArrayList<Article> getAllArticle(){
		String sql = String.format("SELECT * FROM article");
		ArrayList <Article> Articles = getArticleList(sql);
		return Articles;
	}
	public Article getArticleByIdx(int idx) {
		Article article = null;
		
		String sql = String.format("SELECT * FROM article where idx = %d",idx);
		ArrayList<Article> articles = getArticleList(sql);
		
		if(articles.size() > 0) {
			article = articles.get(0);
		}
		return article;
	}
	
	
	public void InsertData(String title,String body) {
		String sql = String.format("INSERT INTO article set title = '%s', `body` = '%s', regDate = now()",title,body);
		Connection conn = getConnection();
		try{
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void deleteArticle(int idx) {
		String sql  = String.format("DELETE FROM article WHERE idx = %d",idx);
		Connection conn = getConnection();
		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}

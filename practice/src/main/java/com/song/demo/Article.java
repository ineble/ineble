package com.song.demo;

public class Article {
	private int idx;
	private String title;
	private String body;
	private String regDate;
	
	
	
	public Article(int idx, String title, String body, String regDate) {
		super();
		this.idx = idx;
		this.title = title;
		this.body = body;
		this.regDate = regDate;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	
}

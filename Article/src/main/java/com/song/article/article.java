package com.song.article;

public class article {
	private int idx;
	private String title;
	private String body;
	private String regDate;
	private String writer;
	
	public article(int idx, String title, String body, String regDate, String writer) {
		super();
		this.idx = idx;
		this.title = title;
		this.body = body;
		this.regDate = regDate;
		this.writer = writer;
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

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	
	
	
}

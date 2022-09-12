<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="com.song.demo.ArticleDB" %>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.song.demo.Article" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<h1>주소 목록</h1>
<%
	ArticleDB db = new ArticleDB();
	ArrayList<Article> articleList = db.selectDatas();
	
	for(int i =0; i < articleList.size(); i++){
		Article text = articleList.get(i);
	%>
		<div>
		번호 : <%= text.getIdx() %><br/>
		제목 : <%= text.getTitle() %><br/>
		내용 : <%= text.getBody() %><br/>
		게시일 : <%= text.getRegDate() %><br/>
		</div>
		<hr/>
	<%}%>
	


</body>
</html>
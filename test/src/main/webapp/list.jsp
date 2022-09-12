<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="com.song.demo.ArticleDB" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.song.demo.Article" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<h1>주소 목록</h1>
<c:forEach items="${articleList}" var="List">
	<div>
		번호 : ${List.idx}	<br/>
		제목 : ${List.title}	<br/>
		내용 : ${List.body}	<br/>
		게시일 : ${List.regDate}	<br/>
	</div>
	<hr/>	
</c:forEach>
	
</body>
</html>
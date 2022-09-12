<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<H1>게시물 목록</H1>
<c:forEach items="${articleList}" var="article">
	<div>
	번호 : ${article.idx} <br/>
	<a href="/article/detail?idx=${ article.idx }">제목 : ${ article.title }</a><br/> 
	내용 : ${article.body} <br/>
	작성일 : ${article.regDate} <br/>
	
	</div>
</c:forEach>	
</body>
</html>
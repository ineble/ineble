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
<div>
	<div>
	번호 : ${article.idx} 
	</div>
	<div>
	제목 : ${article.title} 
	</div>
	<div>
	내용 : ${article.body} 
	</div>
	<div>
	작성일 : ${article.regDate}
	</div>
	<div>
	<a href="/article/showUpdateForm?idx=${article.idx}">수정</a>
	<a href="#">삭제</a>
	</div>
</div>	
</body>
</html>
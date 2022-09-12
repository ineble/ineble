<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<H1>게시물 추가</H1>
	<form action="http://localhost:9000/article/add">
	<div>
	제목 : <input type="text" name=title><br/>
	내용 : <input type="text" name=body><br/>
	유저명 : <input type="text" name=nickname><br/>
	<input type="submit" value="게시물 등록" />
	</div>
	</form>
</body>
</html>
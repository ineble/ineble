<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<h1>게시물 등록</h1>
	<form action="http://localhost:9000/ta/add">
	<div>
	제목 : <input type="text" name="title"><br/>
	내용 : <input type="text" name="body"><br/>
	<input type="submit" value="게시물 등록"/>
	</div>
	</form>

</body>
</html>
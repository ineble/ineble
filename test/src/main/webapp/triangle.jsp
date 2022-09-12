<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>삼각형 그리기!</title>
</head>
<body>
<h1>삼각형!</h1>
<% int height = Integer.parseInt(request.getParameter("height"));%>	
	<% out.println("height : [" + height + "]"); %>
	<% for(int i = 0; i <= height; i ++) {%>
		<%for(int j = height; j >= 0; j-- ){ %>
			<% out.print(" "); %>
			<%for(int k = j; k <= height; j++ ){ %>
			<% out.print("*"); %>
			<% } %>
			<br/>
		<% } %> 	
	<% } %>
</body>
</html>
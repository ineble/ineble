<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<h1>할인 대상자</h1>
<% int age = Integer.parseInt(request.getParameter("age"));	
	if(age <=19 || age >=65){%>
		<% out.println("할인 대상자입니다!"); %><br>
		<% %>
	<%} else {%>
	<% out.println("할인 대상자가 아닙니다!"); %><br>
	<% } %>
</body>
</html>
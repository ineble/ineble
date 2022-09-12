<%@page import="org.apache.jasper.tagplugins.jstl.core.Param"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>구구단</title>
</head>
<body>
<h1>구구단</h1>
<% int dan = Integer.parseInt(request.getParameter("dan")); 
   int gop = Integer.parseInt(request.getParameter("gop"));
   for(int i = 1 ; i <= dan ; i++){%>
	   <% out.println(" == " + i + "단 =="); %><br/>
	   <% for(int j = 1; j <=gop; j ++) { %>
		<% out.println(i + " x " + j + " = " + i*j); %><br/>
	<%}%>
	<hr/>
<%}%>
   

</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.connection.DatabaseConnection"%>
<%
	int id = Integer.parseInt(request.getParameter("id"));
	String name = request.getParameter("name");
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	try {
		Connection con = DatabaseConnection.getConnection();
		Statement statement = con.createStatement();
		int edit_account = statement.executeUpdate("update admin set name='" + name + "',username='" + username+ "',password='" + password + "' where admin_id='" + id + "'");
		if (edit_account > 0) {
			response.sendRedirect("account.jsp");
		} else {
			response.sendRedirect("edit_account.jsp");
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
%>
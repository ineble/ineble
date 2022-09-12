<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.connection.DatabaseConnection"%>
<%
	String id = request.getParameter("admin_id");
	Connection con = DatabaseConnection.getConnection();
	Statement statement = con.createStatement();
	int deleteAccount = statement.executeUpdate("delete from admin where admin_id='" + id + "'");
	if (deleteAccount > 0) {
		response.sendRedirect("account.jsp");
	} else {
		response.sendRedirect("account.jsp");
	}
%>
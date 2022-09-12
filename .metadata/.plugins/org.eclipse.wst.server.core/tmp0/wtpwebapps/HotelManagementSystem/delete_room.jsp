<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.connection.DatabaseConnection"%>
<%
	String id = request.getParameter("room_id");
	Connection con = DatabaseConnection.getConnection();
	Statement statement = con.createStatement();
	int deleteAccount = statement.executeUpdate("delete from room where room_id='" + id + "'");
	if (deleteAccount > 0) {
		response.sendRedirect("room.jsp");
	} else {
		response.sendRedirect("room.jsp");
	}
%>
package com.example.hotel.reservation;

import java.io.IOException;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.connection.DatabaseConnection;

import java.sql.*;

/**
 * Servlet implementation class MakeReservation
 */
@WebServlet("/MakeReservation")
public class MakeReservation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession hs=request.getSession();
		int guest_id = 0;
		int travel_id = 0;
		int room_id=(int)hs.getAttribute("room_id");
		String Status = "Pending";
		String firstname = request.getParameter("firstname");
		String middlename = request.getParameter("middlename");
		String lastname = request.getParameter("lastname");
		String address = request.getParameter("address");
		String contactno = request.getParameter("contactno");
		String oldDate = request.getParameter("date");
		int day = Integer.parseInt(request.getParameter("day"));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		try {
			c.setTime(sdf.parse(oldDate));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		c.add(Calendar.DAY_OF_MONTH, day);
		String newDate = sdf.format(c.getTime());
		System.out.println("Date after Addition: " + newDate);
		try {
			Connection con = DatabaseConnection.getConnection();
			Statement st = con.createStatement();
			Statement statement = con.createStatement();
			int makeReservation = st.executeUpdate("insert into guest values('" + guest_id + "','" + firstname + "','"+ middlename + "','" + lastname + "','" + address + "','" + contactno + "')");
			ResultSet rs = st.executeQuery("select guest_id from guest where firstname='" + firstname + "'");
			if (rs.next()) {
				int guestId = rs.getInt(1);
				int loadReservationDate = statement.executeUpdate("insert into travel values('" + travel_id + "','"+ oldDate + "','" + day + "','" + newDate + "','" + Status + "','" + guestId + "','"+room_id+"',0,0,0)");
				response.sendRedirect("reservation.jsp");
			}else{
				response.sendRedirect("reservation.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

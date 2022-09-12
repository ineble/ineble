
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test")
public class test extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		String sdan = request.getParameter("dan");
		int dan = Integer.parseInt(sdan);
		String sgop = request.getParameter("gop");
		int gop = Integer.parseInt(sgop);
		
		for(int i = 1 ; i <= dan; i ++) {
			out.println(" == " + i + "단 ==<br>");
			for(int j = 1; j < gop; j ++ ) {
				out.println(i + "*" + j + "=" + i*j + "<br>");
			}
			out.println("<hr>");
		}
		
		System.out.println("서블릿이 잘 실행됩니다.!");
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

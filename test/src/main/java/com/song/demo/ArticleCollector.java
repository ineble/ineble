package com.song.demo;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/ta/*")
public class ArticleCollector extends HttpServlet {
	ArticleDB db = new ArticleDB();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;  charset=utf-8");
		
		
		String uri = request.getRequestURI();
		String[] uripieces = uri.split("/");
		
		if(uripieces.length < 3) {
			//에러페이지
			System.out.println("잘못된 요청입니다.");
			return;
		} 
		String func = uripieces[2];
		
		if(func.equals("add")) {
			String title = request.getParameter("title");
			String body = request.getParameter("body");
			db.InsertData(title, body);
			list(request,response);
		}else if(func.equals("list")) {
			list(request,response);
		}
		
	}	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void list(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException  {
		ArrayList<Article> articleList = db.selectDatas();
		request.setAttribute("articleList", articleList);
		RequestDispatcher rd = request.getRequestDispatcher("/list.jsp");
		rd.forward(request, response);
		
	}

	

	
}

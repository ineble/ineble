package com.song.demo;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/article/*")
public class ArticleColletor extends HttpServlet {
	ArticleDB db = new ArticleDB();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String url = request.getRequestURI();
		String [] urlpiece = url.split("/");
		if(urlpiece.length <3) {
			System.out.println("넌 못 지나간다.!");
			return;
		}
		String func = urlpiece[2];
		
		if(func.equals("add")) {
			String title = request.getParameter("title");
			String body = request.getParameter("body");
			String nickname = request.getParameter("nickname");
			db.InsertData(title,body,nickname);
			response.sendRedirect("/article/list");
		}else if(func.equals("list")) {
			list(request, response);
		}else if(func.equals("showAddForm")) {
			forward(request,response,"/addForm.jsp");
		}else if (func.equals("detail")) {
			int idx = Integer.parseInt(request.getParameter("idx"));
			Article article = db.getArticleByIdx(idx);
			request.setAttribute("article", article);
			forward(request, response, "/detail.jsp");
		}
		
	}


	private void forward(HttpServletRequest request, HttpServletResponse response, String path) {
		try {
			RequestDispatcher rd = request.getRequestDispatcher(path);
			rd.forward(request, response);
		}catch(Exception e) {
			System.out.println("포워딩 중 문제 발생");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		doGet(request, response);
	}
	
	private void list(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException  {
		ArrayList<Article> articleList = db.getAllArticle();
		request.setAttribute("articleList", articleList);
		forward(request, response, "/list.jsp");
	}


}

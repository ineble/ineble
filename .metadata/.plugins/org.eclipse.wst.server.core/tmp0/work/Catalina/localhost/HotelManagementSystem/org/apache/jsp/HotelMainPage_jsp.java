/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.58
 * Generated at: 2022-09-11 08:15:40 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class HotelMainPage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang = \"en\">\r\n");
      out.write("	<head>\r\n");
      out.write("		<title>Hotel Online Reservation</title>\r\n");
      out.write("		<meta charset = \"utf-8\" />\r\n");
      out.write("		<meta name = \"viewport\" content = \"width=device-width, initial-scale=1.0\" />\r\n");
      out.write("		<link rel = \"stylesheet\" type = \"text/css\" href = \"css/bootstrap.css \" />\r\n");
      out.write("		<link rel = \"stylesheet\" type = \"text/css\" href = \"css/style.css\" />\r\n");
      out.write("	</head>\r\n");
      out.write("<body>\r\n");
      out.write("	<nav style = \"background-color:rgba(0, 0, 0, 0.1);\" class = \"navbar navbar-default\">\r\n");
      out.write("		<div  class = \"container-fluid\">\r\n");
      out.write("			<div class = \"navbar-header\">\r\n");
      out.write("				<a class = \"navbar-brand\" >Hotel Online Reservation</a>\r\n");
      out.write("			</div>\r\n");
      out.write("		</div>\r\n");
      out.write("	</nav>	\r\n");
      out.write("	<ul id = \"menu\">\r\n");
      out.write("		<li><a href = \"HotelMainPage.jsp\">Home</a></li> |\r\n");
      out.write("		<li><a href = \"aboutus.jsp\">About us</a></li> |\r\n");
      out.write("		<li><a href = \"contactus.jsp\">Contact us</a></li> |\r\n");
      out.write("		<li><a href = \"gallery.jsp\">Gallery</a></li> |\r\n");
      out.write("		<li><a href = \"dineandlounge.jsp\">Dine and Lounge</a></li> |			\r\n");
      out.write("		<li><a href = \"reservation.jsp\">Make a reservation</a></li> |\r\n");
      out.write("		<li><a href = \"rulesandregulation.jsp\">Rules and Regulation</a></li>|\r\n");
      out.write("		<li><a href = \"adminLogin.jsp\">Admin Login</a></li>\r\n");
      out.write("	</ul>\r\n");
      out.write("	<div id=\"myCarousel\" class=\"carousel slide container-fluid\" data-ride=\"carousel\">\r\n");
      out.write("		<ol class=\"carousel-indicators\">\r\n");
      out.write("			<li data-target=\"#myCarousel\" data-slide-to=\"0\" class=\"active\"></li>\r\n");
      out.write("			<li data-target=\"#myCarousel\" data-slide-to=\"1\"></li>\r\n");
      out.write("			<li data-target=\"#myCarousel\" data-slide-to=\"2\"></li>\r\n");
      out.write("			<li data-target=\"#myCarousel\" data-slide-to=\"3\"></li>\r\n");
      out.write("			<li data-target=\"#myCarousel\" data-slide-to=\"4\"></li>\r\n");
      out.write("			<li data-target=\"#myCarousel\" data-slide-to=\"5\"></li>\r\n");
      out.write("			<li data-target=\"#myCarousel\" data-slide-to=\"6\"></li>\r\n");
      out.write("		</ol>\r\n");
      out.write("		<div style = \"margin:auto;\" class=\"carousel-inner\" role=\"listbox\">\r\n");
      out.write("			<div class=\"item active\">\r\n");
      out.write("				<img src=\"images/a.jpg\" style = \"width:100%; height:450px;\" />\r\n");
      out.write("			</div>\r\n");
      out.write("		\r\n");
      out.write("			<div class=\"item\">\r\n");
      out.write("				<img src=\"images/b.jpg\" style = \"width:100%; height:450px;\"  />\r\n");
      out.write("			</div>\r\n");
      out.write("		\r\n");
      out.write("			<div class=\"item\">\r\n");
      out.write("				<img src=\"images/c.jpg\" style = \"width:100%; height:450px;\" />\r\n");
      out.write("			</div>\r\n");
      out.write("		\r\n");
      out.write("			<div class=\"item\">\r\n");
      out.write("				<img src=\"images/d.jpg\" style = \"width:100%; height:450px;\" />\r\n");
      out.write("			</div>\r\n");
      out.write("			\r\n");
      out.write("			<div class=\"item\">\r\n");
      out.write("				<img src=\"images/e.jpg\" style = \"width:100%; height:450px;\" />\r\n");
      out.write("			</div>\r\n");
      out.write("			\r\n");
      out.write("			<div class=\"item\">\r\n");
      out.write("				<img src=\"images/f.jpeg\" style = \"width:100%; height:450px;\" />\r\n");
      out.write("			</div>\r\n");
      out.write("			\r\n");
      out.write("			<div class=\"item\">\r\n");
      out.write("				<img src=\"images/g.png\" style = \"width:100%; height:450px;\" />\r\n");
      out.write("			</div>\r\n");
      out.write("			\r\n");
      out.write("			\r\n");
      out.write("		</div>\r\n");
      out.write("		<a class=\"left carousel-control\" href=\"#myCarousel\" role=\"button\" data-slide=\"prev\">\r\n");
      out.write("			<span class=\"glyphicon glyphicon-chevron-left\" aria-hidden=\"true\"></span>\r\n");
      out.write("			<span class=\"sr-only\">Previous</span>\r\n");
      out.write("		</a>\r\n");
      out.write("		<a class=\"right carousel-control\" href=\"#myCarousel\" role=\"button\" data-slide=\"next\">\r\n");
      out.write("			<span class=\"glyphicon glyphicon-chevron-right\" aria-hidden=\"true\"></span>\r\n");
      out.write("			<span class=\"sr-only\">Next</span>\r\n");
      out.write("		</a>	\r\n");
      out.write("	</div>\r\n");
      out.write("</body>\r\n");
      out.write("<script src = \"js/jquery.js\"></script>\r\n");
      out.write("<script src = \"js/bootstrap.js\"></script>	\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
package test.servlet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/home.do")
public class HomeController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String contextPath=req.getContextPath();
		//req.getServletContext()는 application을 사용할 수 있게함
		//방법1
		//ServletContext application=req.getServletContext();
		//application.setAttribute("cp",contextPath);
		//방법2
		req.getServletContext().setAttribute("cp", contextPath);
		resp.sendRedirect(req.getContextPath()+"/index.jsp");
	}
}

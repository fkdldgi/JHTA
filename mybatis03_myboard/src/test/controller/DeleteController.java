package test.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.dao.MyBoardDao;

@WebServlet("/myboard/delete")
public class DeleteController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletContext application=req.getServletContext();
		String cp=application.getContextPath();
		int num=Integer.parseInt(req.getParameter("num"));
		MyBoardDao dao=new MyBoardDao();
		int n=dao.delete(num);
		resp.sendRedirect(cp+"/myboard/list");
	}
}

package test.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.dao.MyBoardDao;
import test.vo.MyBoardVo;

@WebServlet("/myboard/update")
public class UpdateController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		int num=Integer.parseInt(req.getParameter("num"));
		String writer=req.getParameter("writer");
		req.setAttribute("num", num);
		req.setAttribute("writer", writer);
		req.getRequestDispatcher("/update.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		int num=Integer.parseInt(req.getParameter("num"));
		String writer=req.getParameter("writer");
		String pwd=req.getParameter("pwd");
		String title=req.getParameter("title");
		String content=req.getParameter("content");
		MyBoardVo vo=new MyBoardVo(num,writer,pwd,title,content,null);
		MyBoardDao dao=new MyBoardDao();
		int n=dao.update(vo);
		String code="fail";
		if(n>0) {
			code="success";
		}
		req.setAttribute("code", code);
		req.getRequestDispatcher("/result.jsp").forward(req, resp);
		
	}
}

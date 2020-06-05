package test.servlet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.dao.MyBoardDao;
import test.vo.MyBoardVo;

@WebServlet("/board/insert.do")
public class InsertController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/board/insert.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String writer=req.getParameter("writer");
		String title=req.getParameter("title");
		String content=req.getParameter("content");
		String pwd=req.getParameter("pwd");
		MyBoardVo vo=new MyBoardVo(0,writer,pwd,title,content,null);
		MyBoardDao dao=new MyBoardDao();
		int n=dao.insert(vo);
		if(n>0) {
			req.setAttribute("msg", "success");
		}else {
			req.setAttribute("msg", "error");
		}
		req.getRequestDispatcher("/board/result.jsp").forward(req, resp);
	}
}

package test.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.dao.MyBoardDao;
import test.vo.MyBoardVo;

@WebServlet("/board/insert")
public class InsertController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String writer=req.getParameter("writer");
		String title=req.getParameter("title");
		String pwd=req.getParameter("pwd");
		String content=req.getParameter("content");
		MyBoardVo vo=new MyBoardVo(0,writer,pwd,title,content,null);
		//전달받은 파라미터값들을 DB에 저장
		MyBoardDao dao=new MyBoardDao();
		int n=dao.insert(vo);
		String code="fail";
		if(n>0) {
			code="success";
		}
		req.setAttribute("code", code);
		req.getRequestDispatcher("/result.jsp").forward(req, resp);
	}
}

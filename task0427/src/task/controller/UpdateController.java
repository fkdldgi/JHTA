package task.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import task.dao.BoardDao;
import task.vo.BoardVo;

@WebServlet("/board/update.do")
public class UpdateController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int num=Integer.parseInt(req.getParameter("num"));
		BoardDao dao=new BoardDao();
		BoardVo vo=dao.select(num);
		req.setAttribute("vo", vo);
		req.getRequestDispatcher("/board/update.jsp").forward(req, resp);
	}
}

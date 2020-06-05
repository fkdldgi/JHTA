package task.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import task.dao.BoardDao;
import task.vo.BoardVo;

@WebServlet("/board/search.do")
public class SearchController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String title=req.getParameter("title");
		BoardDao dao=new BoardDao();
		ArrayList<BoardVo> list=dao.search(title);
		req.setAttribute("list", list);
		req.getRequestDispatcher("/board/searchOk.jsp").forward(req, resp);
	}
}

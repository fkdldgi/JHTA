package task.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import task.dao.BoardDao;

@WebServlet("/board/delete.do")
public class DeleteController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		int num=Integer.parseInt(req.getParameter("num"));
		BoardDao dao=new BoardDao();
		try {
			int n=dao.delete(num);
			resp.sendRedirect(req.getContextPath()+"/board/list.do");
		}catch(Exception e) {
			System.out.println(e.getMessage());
			req.setAttribute("errMsg", "글삭제 실패!!");
			req.getRequestDispatcher("/error.jsp").forward(req, resp);
		}
	}
}

package task.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import task.dao.BoardDao;
import task.vo.BoardVo;

@WebServlet("/board/write.do")
public class WriteController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String writer=req.getParameter("writer");
		String email=req.getParameter("email");
		String title=req.getParameter("title");
		String content=req.getParameter("content");
		
		BoardDao dao=new BoardDao();
		BoardVo vo=new BoardVo(0,writer,email,title,content,null);
		try {
			int n=dao.insert(vo);
			resp.sendRedirect(req.getContextPath()+"/board/list.do");
		}catch(Exception e) {
			System.out.println(e.getMessage());
			req.setAttribute("errMsg", "글쓰기 실패!");
			req.getRequestDispatcher("/error.jsp").forward(req, resp);;
		}
	}
}

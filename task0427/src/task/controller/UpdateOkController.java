package task.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import task.dao.BoardDao;
import task.vo.BoardVo;

@WebServlet("/board/updateOk.do")
public class UpdateOkController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		BoardDao dao=new BoardDao();
		int num=Integer.parseInt(req.getParameter("num"));
		String title=req.getParameter("title");
		String content=req.getParameter("content");
		BoardVo vo=new BoardVo(num,"","",title,content,null);
		int n=dao.update(vo);
		if(n>0) {
			resp.sendRedirect(req.getContextPath()+"/board/list.do");
		}else {
			req.setAttribute("errMsg", "글수정 실패!!");
			req.getRequestDispatcher(req.getContextPath()+"/error.jsp");
		}
	}
}

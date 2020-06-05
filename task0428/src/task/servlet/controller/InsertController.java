package task.servlet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import task.dao.BoardDao;
import task.vo.BoardVo;

@WebServlet("/board/insert.do")
public class InsertController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect(req.getContextPath()+"/board/insert.jsp");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String snum=req.getParameter("num");
		String writer=req.getParameter("writer");
		String title=req.getParameter("title");
		String content=req.getParameter("content");
		
		int num=0;
		int ref=0;
		int lev=0;
		int step=0;
		//����ϰ��
		if(snum!=null && !snum.equals("")) {
			num=Integer.parseInt(snum);
			ref=Integer.parseInt(req.getParameter("ref"));
			lev=Integer.parseInt(req.getParameter("lev"));
			step=Integer.parseInt(req.getParameter("step"));
		}
		BoardVo vo=new BoardVo(num,writer,title,content,ref,lev,step);
		BoardDao dao=new BoardDao();
		int n=dao.insert(vo);
		if(n>0) {
			req.setAttribute("msg", "���ۼ� �Ϸ�!");
		}else {
			req.setAttribute("msg", "���ۼ� ����!");
		}
		req.getRequestDispatcher("/board/result.jsp").forward(req, resp);
	}
}











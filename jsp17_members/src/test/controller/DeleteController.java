package test.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.dao.MembersDao;

@WebServlet("/members/delete.do")
public class DeleteController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int num=Integer.parseInt(req.getParameter("num"));
		MembersDao dao=new MembersDao();
		try {
			int n=dao.delete(num);
			resp.sendRedirect(req.getContextPath()+"/members/list.do");
		}catch(Exception e) {
			System.out.println(e.getMessage());
			req.setAttribute("errMsg", "회원삭제실패!");
			req.getRequestDispatcher("/error.jsp").forward(req,resp);
		}
	}
}

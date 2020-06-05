package test.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.dao.MembersDao;
import test.vo.MembersVo;

@WebServlet("/members/update.do")
public class UpdateController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int num=Integer.parseInt(req.getParameter("num"));
		MembersDao dao=new MembersDao();
		MembersVo vo=dao.select(num);
		req.setAttribute("vo", vo);
		req.getRequestDispatcher("/members/update.jsp").forward(req, resp);
	}
}

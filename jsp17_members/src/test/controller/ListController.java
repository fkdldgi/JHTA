package test.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.dao.MembersDao;
import test.vo.MembersVo;

@WebServlet("/members/list.do")
public class ListController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MembersDao dao=new MembersDao();
		ArrayList<MembersVo> list=dao.list();
		req.setAttribute("list", list);
		req.getRequestDispatcher("/members/list.jsp").forward(req, resp);
	}
}

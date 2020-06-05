package test.servlet.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import test.dao.LoginDao;

@WebServlet("/users/login.do")
public class LoginController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/users/login.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("id");
		String pwd=req.getParameter("pwd");
		HashMap<String, String> map=new HashMap<String, String>();
		map.put("id", id);
		map.put("pwd",pwd);
		LoginDao dao=LoginDao.getDao(); // DAO��ü ������
		int n=dao.isMember(map);
		if(n==1) { //ȸ���ΰ�� -> ���ǿ� ���̵� ���� �� home.do�� �̵��ϱ�
			HttpSession session=req.getSession();
			session.setAttribute("id", id);
			resp.sendRedirect(req.getContextPath()+"/home.do");
		}else { //ȸ���� �ƴѰ�� -> �����޽��� ���� �� login.jsp�� �̵��Ͽ� �޽��� ���̱�
			req.setAttribute("errMsg", "���̵� �Ǵ� ��й�ȣ�� ���� �ʾƿ�!!!");
			req.getRequestDispatcher("/users/login.jsp").forward(req, resp);
		}
	}
}

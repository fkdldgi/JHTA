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
		LoginDao dao=LoginDao.getDao(); // DAO객체 얻어오기
		int n=dao.isMember(map);
		if(n==1) { //회원인경우 -> 세션에 아이디 저장 후 home.do로 이동하기
			HttpSession session=req.getSession();
			session.setAttribute("id", id);
			resp.sendRedirect(req.getContextPath()+"/home.do");
		}else { //회원이 아닌경우 -> 오류메시지 저장 후 login.jsp로 이동하여 메시지 보이기
			req.setAttribute("errMsg", "아이디 또는 비밀번호가 맞지 않아요!!!");
			req.getRequestDispatcher("/users/login.jsp").forward(req, resp);
		}
	}
}

package test.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/member/loginOk")
public class LoginOkServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("id");
		String pwd=req.getParameter("pwd");
		HttpSession session=req.getSession(); //���ǰ�ü ������
		session.setAttribute("id", id);
		//�����̷�Ʈ������� main.jsp�� �̵��� ������.
		String cp=req.getContextPath();
		resp.sendRedirect(cp+"/main.jsp");
	}
}

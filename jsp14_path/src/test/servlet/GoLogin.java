package test.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/member/login")
public class GoLogin extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("login!!!!!");
		String cp=req.getContextPath();
		resp.sendRedirect(cp+"/1/login.jsp");//sendRedirect는 클라이언트의 요청(웹브라우저요청)과 같으므로 절대경로를 보내줘야한다
	}
}

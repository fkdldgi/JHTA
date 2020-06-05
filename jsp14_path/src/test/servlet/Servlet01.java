package test.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet01")
public class Servlet01 extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("msg", "hello~~~~~~~~");
		//forward�� ���ο��� �̵��ϴ°��̱� ������  
		RequestDispatcher rd=req.getRequestDispatcher("1/result.jsp"); //����� ���1
		//req.getRequestDispatcher("1/result.jsp").forward(req, resp); //����� ���2
		RequestDispatcher rd2=req.getRequestDispatcher("/1/result.jsp"); //������ ���1
		
		rd.forward(req, resp);
	}
}

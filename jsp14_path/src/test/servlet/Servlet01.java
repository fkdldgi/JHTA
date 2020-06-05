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
		//forward는 내부에서 이동하는것이기 때문에  
		RequestDispatcher rd=req.getRequestDispatcher("1/result.jsp"); //상대경로 방법1
		//req.getRequestDispatcher("1/result.jsp").forward(req, resp); //상대경로 방법2
		RequestDispatcher rd2=req.getRequestDispatcher("/1/result.jsp"); //절대경로 방법1
		
		rd.forward(req, resp);
	}
}

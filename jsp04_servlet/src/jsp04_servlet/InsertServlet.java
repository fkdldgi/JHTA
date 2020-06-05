package jsp04_servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/insert.do")
public class InsertServlet extends HttpServlet{
	/*
	//service메소드 -> get방식/post방식으로 요청시 모두 호출됨
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("요청방식:"+req.getMethod());
		System.out.println("service메소드 호출됨...");
	}
	*/
	//doGet메소드 ->
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet메소드 호출됨...");
		resp.sendRedirect("test01.html");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPost메소드 호출됨...");
		System.out.println("회원정보 db저장 완료!");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter pw=resp.getWriter();
		pw.print("<html>");
		pw.print("<head></head>");
		pw.print("<body>");
		pw.print("<h1>회원가입 성공!!!</h1>");
		pw.print("</body>");
		pw.print("</html>");
		pw.close();
	}
}

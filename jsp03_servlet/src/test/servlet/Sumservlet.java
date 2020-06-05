package test.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Sumservlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int num1=Integer.parseInt(req.getParameter("num1"));
		int num2=Integer.parseInt(req.getParameter("num2"));
		int num3=num1+num2;
		
		//������ ������Ÿ�԰� ���ڵ��������
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter pw=resp.getWriter();
		pw.print("<html>");
		pw.print("<head></head>");
		pw.print("<body>");
		pw.print("<h1>�μ��� ��</h1>");
		pw.print(num1+"+"+num2+"="+num3);
		pw.print("</body>");
		pw.print("</html>");
		pw.close();
	}
}

package test.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 *  [����]
 *  - �����ø����̼ǿ��� ����Ǵ� �ڹ�Ŭ����(�����ø����̼ǿ��� ����Ǵ�
 *  ���� ���α׷�-������� �����ȴ�.)
 *  - Ŭ���̾�Ʈ�� ��û�� �ް� Ŭ���̾�Ʈ���� ������ �� �ִ�.
 *  - ����� ���
 *  1. HttpServlet�� ��ӹ޴´�
 *  2. service �޼ҵ带 �������̵� �Ѵ�. -> �䫊�� ���信 ���õ� �۾� ����
 *  3. ������ ȣ���� ��θ� �����Ѵ�.(������̼� �Ǵ� web.xml���� ����)
 *  4. ���� �� ��η� ������ ȣ���Ѵ�.
 *  
 * 
 * 
 */
@WebServlet("/insert.do") //���������ϱ�(������̼�): Ȯ���ڴ� �������(���൵��)
public class InsertServlet extends HttpServlet{ //HttpServlet�� ��ӹ���
	/*
	 * request : ��û�� ���õ� ������ ����� ���� ��ü
	 * response : ���信 ���õ� ������ ����� ���� ��ü
	 * 
	 */
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Ŭ���̾�Ʈ���� ���� �ѱ��� ������ �ʵ��� ���ڵ� ����
		req.setCharacterEncoding("utf-8");
		String id=req.getParameter("id");
		String pwd=req.getParameter("pwd");
		String email=req.getParameter("email");
		System.out.println("<< ����ڰ� ������ ���� >>");
		System.out.println("id:"+id);
		System.out.println("pwd:"+pwd);
		System.out.println("email:"+email);
		
		//������ ������Ÿ�԰� ���ڵ��������
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter pw=resp.getWriter();
		pw.print("<html>");
		pw.print("<head></head>");
		pw.print("<body>");
		pw.print("<h1>����ڰ� ������ ����</h1>");
		pw.print("id:"+ id+"<br>");
		pw.print("pwd:"+pwd+"<br>");
		pw.print("email:"+email+"<br>");
		pw.print("</body>");
		pw.print("</html>");
		pw.close();
	}
}

package test.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 *  [서블릿]
 *  - 웹어플리케이션에서 실행되는 자바클래스(웹어플리케이션에서 실행되는
 *  작은 프로그램-스레드로 구동된다.)
 *  - 클라이언트의 요청을 받고 클라이언트에게 응답할 수 있다.
 *  - 만드는 방법
 *  1. HttpServlet을 상속받는다
 *  2. service 메소드를 오버라이딩 한다. -> 요쳥과 응답에 관련된 작업 구현
 *  3. 서블릿을 호출할 경로를 매핑한다.(어노테이션 또는 web.xml에서 설정)
 *  4. 매핑 된 경로로 서블릿을 호출한다.
 *  
 * 
 * 
 */
@WebServlet("/insert.do") //서블릿매핑하기(어노테이션): 확장자는 마음대로(안줘도됨)
public class InsertServlet extends HttpServlet{ //HttpServlet을 상속받음
	/*
	 * request : 요청과 관련된 정보와 기능을 갖는 객체
	 * response : 응답에 관련된 정보와 기능을 갖는 객체
	 * 
	 */
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//클라이언트에게 받은 한글이 깨지지 않도록 인코딩 설정
		req.setCharacterEncoding("utf-8");
		String id=req.getParameter("id");
		String pwd=req.getParameter("pwd");
		String email=req.getParameter("email");
		System.out.println("<< 사용자가 보내온 정보 >>");
		System.out.println("id:"+id);
		System.out.println("pwd:"+pwd);
		System.out.println("email:"+email);
		
		//응답할 콘텐츠타입과 인코딩방식지정
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter pw=resp.getWriter();
		pw.print("<html>");
		pw.print("<head></head>");
		pw.print("<body>");
		pw.print("<h1>사용자가 보내온 정보</h1>");
		pw.print("id:"+ id+"<br>");
		pw.print("pwd:"+pwd+"<br>");
		pw.print("email:"+email+"<br>");
		pw.print("</body>");
		pw.print("</html>");
		pw.close();
	}
}

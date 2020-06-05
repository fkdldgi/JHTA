package test.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet1 extends HttpServlet{
	/*
	 * init메소드
	 * - 최초로 서블릿이 생설될 때 딱 한번 호출된다.(생성자와 비슷함)
	 */
	String user;
	String pwd;
	String url;
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init메소드 호출....");
		//web.xml에 설정된 초기화 파라미터 값 읽어오기
		user=config.getInitParameter("user");
		pwd=config.getInitParameter("password");
		//서블릿 컨텍스트 객체 얻어오기
		ServletContext sc=config.getServletContext();
		url=sc.getInitParameter("url");
	}
	/*
	 * destroy메소드
	 * - 서블릿이 제거될 때(일정시간<30분>동안 요청이 없거나 웹서버가 종료될 때)
	 *  호출되는 메소드
	 */
	@Override
	public void destroy() {
		System.out.println("destroy메소드 호출....");
	}
	/*
	 * service메소드
	 * - 클라이언트가 요청할 때 마다 호출된다.
	 */
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("service메소드 호출");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter pw=resp.getWriter();
		pw.write("<h1>MyServlet1의 service메소드 호출..!</h1>");
		pw.write("user=>"+user+"<br>");
		pw.write("password=>"+pwd+"<br>");
		pw.write("url=>"+url+"<br>");
		pw.close();
	}
}

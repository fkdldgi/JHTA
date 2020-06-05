package task0417.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/update.do")
public class update extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		int num=Integer.parseInt(req.getParameter("num"));
		String writer=req.getParameter("writer");
		String email=req.getParameter("email");
		String title=req.getParameter("title");
		String content=req.getParameter("content");
		
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter pw=resp.getWriter();
		pw.print("<html>");
		pw.print("<head>");
		pw.print("</head>");
		pw.print("<body>");
		pw.print("<form action='updateOk.do' method='POST'>");
		pw.print("글번호 <input type='text' name='num' value='"+num+"'readonly='readonly'><br>");
		pw.print("작성자 <input type='text' name='writer' value='"+writer+"'readonly='readonly'><br>");
		pw.print("이메일 <input type='text' name='email' value='"+email+"'readonly='readonly'><br>");
		pw.print("글제목 <input type='text' name='title' value="+title+"><br>");
		pw.print("글내용 <input type='text' name='content' value="+content+"><br>");
		pw.print("<input type='submit' value='완료'>");
		pw.print("<input type='reset' value='취소' onclick='history.go(-1)'>");
		pw.print("</form>");
		pw.print("</body>");
		pw.print("</html>");
		pw.close();
	}
}

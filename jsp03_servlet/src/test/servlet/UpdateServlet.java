package test.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.db.JDBCUtil;

@WebServlet("/update.do")
public class UpdateServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("id");
		req.setCharacterEncoding("utf-8");
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=JDBCUtil.getConn();
			String sql="select * from myusers where id=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter pw=resp.getWriter();
			pw.print("<html>");
			pw.print("<head>");
			pw.print("</head>");
			pw.print("<body>");
			if(rs.next()) {
				do {
					String pwd=rs.getString("pwd");
					String email=rs.getString("email");
					Date regdate=rs.getDate("regdate");
					pw.print("<form method='post' action='update.do'>");
					pw.print("<p>아이디 <input type='text' name='id' value='"+id+"'></p>");
					pw.print("<p>비밀번호 <input type='text' name='pwd' value='"+pwd+"'></p>");
					pw.print("<p>이메일 <input type='text' name='email' value='"+email+"'></p>");
					pw.print("<p>가입일 <input type='text' name='regdate' value='"+regdate+"'></p>");
					pw.print("<p><input type='submit' value='저장'></p>");
					pw.print("</form>");
				}while(rs.next());
			}
			pw.print("</table>");
			pw.print("</body>");
			pw.print("</html>");
			pw.close();
		}catch(SQLException se) {
			System.out.println(se.getMessage());
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("id");
		String pwd=req.getParameter("pwd");
		String email=req.getParameter("email");
		String regdate=req.getParameter("regdate");
		
		Connection con=null;
		PreparedStatement pstmt=null;
		int n=0;
		try {
			con=JDBCUtil.getConn();
			String sql="update myusers set pwd=?,email=? where id=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, pwd);
			pstmt.setString(2, email);
			pstmt.setString(3, id);
			n=pstmt.executeUpdate();
		}catch(SQLException se) {
			System.out.println(se.getMessage());
		}finally {
			JDBCUtil.close(null,pstmt,con);
		}
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter pw=resp.getWriter();
		if(n>0) {
			resp.sendRedirect("list.do");
		}else {
			pw.print("<h1>회원정보 수정실패!</h1>");
		}
	}
}

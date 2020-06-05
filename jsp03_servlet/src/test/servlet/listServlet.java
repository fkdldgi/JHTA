package test.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.db.JDBCUtil;

public class listServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=JDBCUtil.getConn();
			String sql="select * from myusers";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter pw=resp.getWriter();
			pw.print("<html>");
			pw.print("<head>");
			pw.print("</head>");
			pw.print("<body>");
			pw.print("<table border='1'>");
			pw.print("<tr>");
			pw.print("<th>아이디</th><th>비밀번호</th><th>이메일</th><th>가입일</th><th>삭제</th><th>수정</th>");
			pw.print("</tr>");
			if(rs.next()) {
				do {
					String id=rs.getString("id");
					String pwd=rs.getString("pwd");
					String email=rs.getString("email");
					Date regdate=rs.getDate("regdate");
					pw.print("<tr>");
					pw.print("<td>"+id+"</td>");
					pw.print("<td>"+pwd+"</td>");
					pw.print("<td>"+email+"</td>");
					pw.print("<td>"+regdate+"</td>");
					pw.print("<td><a href='delete.do?id="+id+"'>삭제</a></td>");
					pw.print("<td><a href='update.do?id="+id+"'>수정</a></td>");
					pw.print("</tr>");
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
}

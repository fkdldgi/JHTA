package test.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.db.JDBCUtil;

public class deleteServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String id=req.getParameter("id");
		
		Connection con=null;
		PreparedStatement pstmt=null;
		int n=0;
		try {
			con=JDBCUtil.getConn();
			String sql="delete from myusers where id=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			n=pstmt.executeUpdate();
		}catch(SQLException se) {
			System.out.println(se.getMessage());
		}finally {
			JDBCUtil.close(null,pstmt,con);
		}
		if(n>0) {
			resp.sendRedirect("list.do"); //list.do(url)로 이동하기
		}else {
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter pw=resp.getWriter();
			pw.print("<html>");
			pw.print("<head></head>");
			pw.print("<body>");
			pw.print("<h1>회원삭제 실패!</h1>");
			pw.print("<a href='index.html'>메인</a>");
			pw.print("</body>");
			pw.print("</html>");
			pw.close();
		}
	}
}

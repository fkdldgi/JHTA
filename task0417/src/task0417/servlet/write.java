package task0417.servlet;

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

public class write extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect("tossWrite.html");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String writer=req.getParameter("writer");
		String email=req.getParameter("email");
		String title=req.getParameter("title");
		String content=req.getParameter("content");
		
		Connection con=null;
		PreparedStatement pstmt=null;
		int n=0;
		try {
			con=JDBCUtil.getConn();
			String sql="insert into board values(board_seq.nextval,?,?,?,?,sysdate)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, writer);
			pstmt.setString(2, email);
			pstmt.setString(3, title);
			pstmt.setString(4, content);
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
			pw.print("<h1>글쓰기 실패!</h1>");
			pw.print("<a href='history.go(-1)'>돌아가기</a>");
		}
	}
}

package task0417.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.db.JDBCUtil;

@WebServlet("/delete.do")
public class delete extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		int num=Integer.parseInt(req.getParameter("num"));
		
		Connection con=null;
		PreparedStatement pstmt=null;
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter pw=resp.getWriter();
		int n=0;
		try{
			con=JDBCUtil.getConn();
			String sql="delete from board where num=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,num);
			n=pstmt.executeUpdate();
		}catch(SQLException se){
			se.printStackTrace();
		}finally{
			JDBCUtil.close(null,pstmt,con);
		}
		if(n>0){
			resp.sendRedirect("list.do");
		}else{
			pw.print("<h1>글삭제에 실패했습니다!</h1>");
		}
		pw.print("<a href='index.jsp'>메인으로 가기</a>");
	}
}

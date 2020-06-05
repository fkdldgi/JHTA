package task0417.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.ProcessBuilder.Redirect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.db.JDBCUtil;

@WebServlet("/updateOk.do")
public class updateOk extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		int num=Integer.parseInt(req.getParameter("num"));
		String title=req.getParameter("title");
		String content=req.getParameter("content");

		Connection con=null;
		PreparedStatement pstmt=null;
		int n=0;
		try{
			con=JDBCUtil.getConn();
			String sql="update board set title=?,content=? where num=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,title);
			pstmt.setString(2,content);
			pstmt.setInt(3,num);
			n=pstmt.executeUpdate();
		}catch(SQLException se){
			se.printStackTrace();
		}finally{
			JDBCUtil.close(null,pstmt,con);
		}
		resp.setContentType("text/html;charset=utf=8");
		PrintWriter pw=resp.getWriter();
		if(n>0){
			resp.sendRedirect("list.do");
		}else{
			pw.print("<h1>수정 실패!!</h1>");
			pw.print("<a href='index.jsp'>메인으로 가기</a>");
		}
	}
}

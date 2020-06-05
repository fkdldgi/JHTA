package task0417.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.db.JDBCUtil;

@WebServlet("/view.do")
public class view extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		int num=Integer.parseInt(req.getParameter("num"));
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String writer="";
		String email="";
		String title="";
		String content="";
		
		try{
			con=JDBCUtil.getConn();
			String sql="select * from board where num=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,num);
			rs=pstmt.executeQuery();
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter pw=resp.getWriter();
			
			pw.print("<html>");
			pw.print("<head>");
			pw.print("<style>");
			pw.print("#wrap{text-align:center;}");
			pw.print("table{position: relative;margin:auto;}");
			pw.print("th{width:100px;}");
			pw.print("td{width:300px;}");
			pw.print("a{margin:10px;}");
			pw.print("</style>");
			pw.print("</head>");
			pw.print("<body>");
			pw.print("<div id='wrap'>");
			pw.print("<h1>SONG`s GUESTBOOK 내용</h1><br>");
			pw.print("<a href='write.do'>글쓰기</a>");
			if(rs.next()) {
					writer=rs.getString("writer");
					email=rs.getString("email");
					title=rs.getString("title");
					content=rs.getString("content");
					pw.print("<table border='1'>");
					pw.print("<tr>");
					pw.print("<th>글번호</th><td>"+num+"</td>");
					pw.print("</tr>");
					pw.print("<tr>");
					pw.print("<th>글쓴이</th><td>"+writer+"</td>");
					pw.print("</tr>");
					pw.print("<tr>");
					pw.print("<th>이메일</th><td>"+email+"</td>");
					pw.print("</tr>");
					pw.print("<tr>");
					pw.print("<th>글제목</th><td>"+title+"</td>");
					pw.print("</tr>");
					pw.print("<tr>");
					pw.print("<th>글내용</th><td>"+content+"</td>");
					pw.print("</tr>");
			}
			pw.print("</table>");
			pw.print("<a href='update.do?num="+num+"&writer="+writer+"&email="+email+"&title="+title+"&content="+content+"'>수정</a>");
			pw.print("<a href='delete.do?num="+num+"'>삭제</a>");
			pw.print("<a href='index.jsp'>목록</a>");
			pw.print("</div>");
			pw.print("</body>");
			pw.print("</html>");
			pw.close();
		}catch(SQLException se) {
			System.out.println(se.getMessage());
		}
	}
}

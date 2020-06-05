package task0417.servlet;

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

@WebServlet("/list.do")
public class list extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {			
			con=JDBCUtil.getConn();
			String sql="select * from board order by num";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter pw=resp.getWriter();
			pw.print("<html>");
			pw.print("<head>");
			pw.print("<style>");
			pw.print("#wrap{text-align:center;}");
			pw.print("table{position: relative;margin:auto;}");
			pw.print("a{margin:10px;}");
			pw.print("</style>");
			pw.print("</head>");
			pw.print("<body>");
			pw.print("<div id='wrap'>");
			pw.print("<h1>SONG`s GUESTBOOK 목록</h1><br>");
			pw.print("<a href='write.do'>글쓰기</a>");
			pw.print("<a href='index.jsp'>메인</a>");
			pw.print("<table border='1'>");
			pw.print("<tr>");
			pw.print("<th>글번호</th><th>작성자</th><th>이메일</th><th>글제목</th><th>날짜</th>");
			pw.print("</tr>");
			if(rs.next()) {
				do {
					int num=rs.getInt("num");
					String writer=rs.getString("writer");
					String email=rs.getString("email");
					String title=rs.getString("title");
					Date w_date=rs.getDate("w_date");
					
					pw.print("<tr>");
					pw.print("<td>"+num+"</td>");
					pw.print("<td>"+writer+"</td>");
					pw.print("<td>"+email+"</td>");
					pw.print("<td><a href='view.do?num="+num+"'>"+title+"</a></td>");
					pw.print("<td>"+w_date+"</td>");
					pw.print("</tr>");
					
				}while(rs.next());
			}
			pw.print("</table>");
			pw.print("</div>");
			pw.print("</body>");
			pw.print("</html>");
			pw.close();
		}catch(SQLException se) {
			System.out.println(se.getMessage());
		}
		
	}
}

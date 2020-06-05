<%@page import="java.sql.Date"%>
<%@page import="java.sql.SQLException"%>
<%@page import="test.db.JDBCUtil"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>SONG`s GUESTBOOK 목록</h1><br>
<a href="layout.jsp?file=writing.jsp">글쓰기</a>
<a href="layout.jsp?file=main.jsp">메인</a><br>
<table border="1" width="500px">
	<tr>
		<th>글번호</th><th>작성자</th><th>이메일</th><th>글제목</th><th>날짜</th>
	</tr>
	<%
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			con=JDBCUtil.getConn();
			String sql="select * from board order by num";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()){
				do{
					int num=rs.getInt("num");
					String writer=rs.getString("writer");
					String email=rs.getString("email");
					String title=rs.getString("title");
					String content=rs.getString("content");
					Date w_date=rs.getDate("w_date");
	%>
					<tr>
						<td><%=num %></td>
						<td><%=writer %></td>
						<td><%=email %></td>
						<td><a href="layout.jsp?file=view.jsp?num=<%=num%>"><%=title %></a></td>
						<td><%=w_date %></td>
					</tr>
	<%
					
				}while(rs.next());
			}
		}catch(SQLException se){
			se.printStackTrace();
		}
		
	
	%>
</table>














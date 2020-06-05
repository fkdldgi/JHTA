<%@page import="java.sql.SQLException"%>
<%@page import="test.db.JDBCUtil"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div>
	<ul>
		<li><a href="layout.jsp?file=main.jsp">홈</a><br></li>
	<%
		String id=(String)session.getAttribute("id");
		if(id!=null){
			Connection con=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			try{
				con=JDBCUtil.getConn();
				String sql="select * from myusers where id=?";
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1, id);
				rs=pstmt.executeQuery();
				if(rs.next()){
					String email=rs.getString("email");
					session.setAttribute("email", email);
				}
			}catch(SQLException se){
				se.getStackTrace();
			}finally{
				JDBCUtil.close(rs,pstmt,con);
			}
		%>
			<li><a href="layout.jsp?file=writing.jsp">글쓰기</a><br></li>
			<li><a href="layout.jsp?file=logout.jsp">로그아웃</a></li>
		<%
		}else{
		%>
			<li><a href="layout.jsp?file=register.jsp">회원가입</a><br></li>
			<li><a href="layout.jsp?file=login.jsp">로그인</a><br></li>
		<%
		}
	%>
		<li><a href="layout.jsp?file=list.jsp">글목록</a><br></li>
	</ul>
</div>

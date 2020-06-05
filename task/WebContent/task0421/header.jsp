<%@page import="java.sql.SQLException"%>
<%@page import="test.db.JDBCUtil"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<ul>
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
		<li><%=id %>님 환영합니다. <a href="logout.jsp">로그아웃</a></li>
		<li><a href="writing.jsp">글쓰기</a><br></li>
	<%
	}else{
	%>
		<li><a href="register.jsp">회원가입</a><br></li>
		<li><a href="login.jsp">로그인</a><br></li>
	<%
	}
%>
	<li><a href="list.jsp">글목록</a><br></li>
</ul>

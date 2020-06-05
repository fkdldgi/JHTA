<%@page import="java.sql.SQLException"%>
<%@page import="test.db.JDBCUtil"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String id=request.getParameter("id");
	String pwd=request.getParameter("pwd");
	String email=request.getParameter("email");
	
	Connection con=null;
	PreparedStatement pstmt=null;
	int n=0;
	try{
		con=JDBCUtil.getConn();
		String sql="insert into myusers values(?,?,?,sysdate)";
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1,id);
		pstmt.setString(2,pwd);
		pstmt.setString(3,email);
		n=pstmt.executeUpdate();
	}catch(SQLException se){
		se.getStackTrace();
	}
	if(n>0){
		%>
		<script type="text/javascript">
			alert("회원가입 성공!!");
			location.href="layout.jsp?file=main.jsp";
		</script>
		<%
	}else{
		%>
		<script type="text/javascript">
			alert("회원가입 실패!!");
			history.go(-1);
		</script>
		<%
	}
%>
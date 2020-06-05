<%@page import="java.sql.SQLException"%>
<%@page import="test.db.JDBCUtil"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>joinOk.jsp...</h1>
<%
	String id=request.getParameter("id");
	String pwd=request.getParameter("pwd");
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
			request.setAttribute("errMsg", "아이디가 존재합니다.");
			request.setAttribute("id",id);
			request.setAttribute("pwd",pwd);
			RequestDispatcher rd=request.getRequestDispatcher("join.jsp");
			rd.forward(request,response);
		}
	}catch(SQLException se){
		se.getStackTrace();
	}
%>
</body>
</html>
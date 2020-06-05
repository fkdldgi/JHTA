<%@page import="java.sql.SQLException"%>
<%@page import="test.db.JDBCUtil"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
	request.setCharacterEncoding("utf-8");
	int num=Integer.parseInt(request.getParameter("num"));
	String name=request.getParameter("name");
	String phone=request.getParameter("phone");
	String addr=request.getParameter("addr");
	
	Connection con=null;
	PreparedStatement pstmt=null;
	int n=0;
	try{
		con=JDBCUtil.getConn();
		String sql="update members set name=?,phone=?,addr=? where num=?";
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1,name);
		pstmt.setString(2,phone);
		pstmt.setString(3,addr);
		pstmt.setInt(4,num);
		n=pstmt.executeUpdate();
	}catch(SQLException se){
		se.printStackTrace();
	}finally{
		JDBCUtil.close(null,pstmt,con);
	}
	if(n>0){
		out.print("<h1>회원정보 수정 완료!</h1>");
	}else{
		out.print("<h1>수정 실패!!</h1>");
	}
%>
<a href="main.jsp">메인페이지로 이동</a>


</body>
</html>
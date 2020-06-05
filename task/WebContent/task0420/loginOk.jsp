<%@page import="java.sql.ResultSet"%>
<%@page import="test.db.JDBCUtil"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.SQLException"%>
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
	String id=request.getParameter("id");
	String pwd=request.getParameter("pwd");
	
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	int n=0;
	try{
		con=JDBCUtil.getConn();
		String sql="select * from myusers where id=? and pwd=?";
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.setString(2, pwd);
		rs=pstmt.executeQuery();
		if(rs.next()){
			session.setAttribute("id", id);
			response.sendRedirect("main.jsp");
		}else{
		%>
		<script type="text/javascript">
			alert("로그인 실패!!");
			history.go(-1);
		</script>
		<%
		}
	}catch(SQLException se){
		se.getStackTrace();
	}
%>
</body>
</html>
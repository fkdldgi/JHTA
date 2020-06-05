<%@page import="java.io.PrintWriter"%>
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
<%
	//1. 사용자 정보(id,password) 읽어오기
	String id=request.getParameter("id");
	String pwd=request.getParameter("pwd");
	//2. 해당정보가 DB에 존재하는지 검사하기
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	try{
		con=JDBCUtil.getConn();
		String sql="select * from myusers where id=? and pwd=?";
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.setString(2,pwd);
		rs=pstmt.executeQuery();
		//3. 해당정보가 존재하면 로그인처리(세션에 아이디 저장하기;)
		if(rs.next()){
			session.setAttribute("id", id);
			response.sendRedirect("main.jsp");
		}else{
		%>
			<script type="text/javascript">
				alert("아이디 또는 비밀번호가 맞지 않아요!");
				history.go(-1);
			</script>
		<%
		}
	}catch(SQLException se){
		out.print(se.getMessage());
	}finally{
		JDBCUtil.close(rs,pstmt,con);
	}
%>
</body>
</html>
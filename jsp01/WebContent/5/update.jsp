<%@page import="test.db.JDBCUtil"%>
<%@page import="java.sql.Date"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
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
	int num=Integer.parseInt(request.getParameter("num"));
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	try{
		con=JDBCUtil.getConn();
		String sql="select * from members where num=?";
		pstmt=con.prepareStatement(sql);
		pstmt.setInt(1,num);
		rs=pstmt.executeQuery();
		while(rs.next()){
			String name=rs.getString("name");
			String phone=rs.getString("phone");
			String addr=rs.getString("addr");
			Date regdate=rs.getDate("regdate");
%>
		<form action="updateOk.jsp">
			<input type="hidden" name="num" value="<%=num %>"> <!-- 보이지 않지만 서버로 전송가능 -->
			회원번호 <input type="text" name="num" value="<%=num %>" readonly="readonly"><br> <!-- disabled="disabled"은 서버로 전송 불가 -->
			이름 <input type="text" name="name" value="<%=name %>"><br>
			전화번호 <input type="text" name="phone" value="<%=phone %>"><br>
			주소 <input type="text" name="addr" value="<%=addr %>"><br>
			가입일 <input type="text" name="regdate" value="<%=regdate %>" readonly="readonly"><br>
			<input type="submit" value="저장"><br>
		</form>
<%
		}
	}catch(SQLException se){
		se.printStackTrace();
	}finally{
		JDBCUtil.close(rs,pstmt,con);
	}
%>

</body>
</html>
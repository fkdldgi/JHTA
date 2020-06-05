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
<h1>SONG`s GUESTBOOK 내용</h1><br>
<a href="layout.jsp?file=writing.jsp">글쓰기</a><br>
<%
	request.setCharacterEncoding("utf-8");
	int num=Integer.parseInt(request.getParameter("num"));
	
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	String writer="";
	String email="";
	String title="";
	String content="";
	try{
		con=JDBCUtil.getConn();
		String sql="select * from board where num=?";
		pstmt=con.prepareStatement(sql);
		pstmt.setInt(1,num);
		rs=pstmt.executeQuery();
		if(rs.next()){
			writer=rs.getString("writer");
			email=rs.getString("email");
			title=rs.getString("title");
			content=rs.getString("content");
			%>
			<table border="1" width="500px">
				<tr>
					<td>글번호</td><td><%=num %></td>
				</tr>
				<tr>
					<td>글쓴이</td><td><%=writer %></td>
				</tr>
				<tr>
					<td>이메일</td><td><%=email %></td>
				</tr>
				<tr>
					<td>글제목</td><td><%=title %></td>
				</tr>
				<tr>
					<td>글내용</td><td><%=content %></td>
				</tr>
			</table>
			<%
		}
	}catch(SQLException se){
		se.printStackTrace();
	}finally{
		JDBCUtil.close(rs,pstmt,con);
	}
%>

<a href="layout.jsp?file=update.jsp?num=<%=num%>&writer=<%=writer%>&email=<%=email%>
&title=<%=title%>&content=<%=content%>"><b>수정</b></a>|
<a href="delete.jsp?num=<%=num%>"><b>삭제</b></a>|
<a href="layout.jsp?file=list.jsp"><b>목록</b></a>
</body>
</html>
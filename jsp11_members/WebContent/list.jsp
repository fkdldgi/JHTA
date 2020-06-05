<%@page import="java.sql.Date"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="test.vo.MembersVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="dao" class="test.dao.MembersDao"></jsp:useBean>
<table border="1" width="500px">
	<tr>
		<th>번호</th><th>이름</th><th>전화번호</th><th>주소</th><th>가입일</th>
		<th>삭제</th><th>수정</th>
	</tr>
<%
	ArrayList<MembersVo> list=dao.list();
	Iterator<MembersVo> it=list.iterator();
	while(it.hasNext()){
		MembersVo vo=it.next();
		int num=vo.getNum();
		String name=vo.getName();
		String phone=vo.getPhone();
		String addr=vo.getAddr();
		Date regdate=vo.getRegdate();
		%>
			<tr>
				<td><%=num %></td>
				<td><%=name %></td>
				<td><%=phone %></td>
				<td><%=addr %></td>
				<td><%=regdate %></td>
				<td><a href="delete.jsp?num=<%=num %>">삭제</a></td>
				<td><a href="update.jsp?num=<%=num %>">수정</a></td>
			</tr>
		<%
	}
%>
</table>
</body>
</html>
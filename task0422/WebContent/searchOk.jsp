<%@page import="java.sql.Date"%>
<%@page import="task.vo.BoardVo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<% String title=request.getParameter("title"); %>
</head>
<body>
<jsp:useBean id="dao" class="task.dao.BoardDao"></jsp:useBean>
<h1>검색된 게시물</h1>
<table border="1" width=500px;>
	<tr>
		<th>회원번호</th><th>작성자</th><th>이메일</th><th>제목</th><th>내용</th><th>작성일</th>
		<th>수정</th><th>삭제</th>
	</tr>
<%
	ArrayList<BoardVo> vo=dao.search(title);
	for(BoardVo item:vo){
		int num=item.getNum();
		String title1=item.getTitle();
		String writer=item.getWriter();
		String email=item.getEmail();
		String content=item.getContent();
		Date w_date=item.getW_date();
		%>
			<tr>
				<td><%=num %></td>
				<td><%=writer %></td>
				<td><%=email %></td>
				<td><%=title1 %></td>
				<td><%=content %></td>
				<td><%=w_date %></td>
				<td><a href="update.jsp?num=<%=num%>">수정</a></td>
				<td><a href="delete.jsp?num=<%=num%>">삭제</a></td>
			</tr>
		<%
	}
%>
</table>
<a href="main.jsp">메인으로</a>
</body>
</html>
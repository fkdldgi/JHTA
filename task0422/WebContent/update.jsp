<%@page import="java.sql.Date"%>
<%@page import="task.vo.BoardVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<% int num=Integer.parseInt(request.getParameter("num")); %>
</head>
<body>
<jsp:useBean id="dao" class="task.dao.BoardDao"></jsp:useBean>
<%
	BoardVo vo=dao.select(num);
	String writer=vo.getWriter();
	String email=vo.getEmail();
	String title=vo.getTitle();
	String content=vo.getContent();
	Date w_date=vo.getW_date();
%>
<form action="updateOk.jsp">
	회원번호 <input type="text" name="num" value=<%=num%> readonly="readonly"><br>
	작성자 <input type="text" name="writer" value=<%=writer %> readonly="readonly"><br>
	이메일 <input type="text" name="email" value=<%=email %> readonly="readonly"><br>
	제목 <input type="text" name="title" value=<%=title %>><br>
	내용 <input type="text" name="content" value=<%=content %>><br>
	작성일 <input type="text" value=<%=w_date %> readonly="readonly"><br>
	<input type="submit" value="완료">
	<input type="reset" value="취소">
</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>result.jsp페이지...</h1>
<%
	String id=(String)request.getAttribute("id");
	String pwd=(String)request.getAttribute("pwd");
%>
<p>id: <%=id %></p>
<p>pwd: <%=pwd %></p>
</body>
</html>


<%@page import="jsp21_sessionListener.SessionCountListener"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>우리우리 쇼핑몰입니다...</h1>
<%
	int count=SessionCountListener.getUserCount();
%>
<div>
	현재 접속자 수 : <%=count %><br>
</div>
<h2>방문을 환영합니다.</h2>
</body>
</html>
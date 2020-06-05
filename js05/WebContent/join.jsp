<%@page import="java.util.Date"%>
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
	//자바코드...
	Date d=new Date();
	out.print(d+"<br>");
%>
<h1>회원가입을 성공했습니다!</h1>
<img src="images/1.png">
</body>
</html>
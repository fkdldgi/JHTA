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
	String num1=request.getParameter("num1");
	String num2=request.getParameter("num2");
	int num_1=Integer.parseInt(num1);
	int num_2=Integer.parseInt(num2);
	out.print("두수합:"+(num_1+num_2));
%>
</body>
</html>
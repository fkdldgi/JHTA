<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>test01.jsp</h1>
<% //스크립트릿 (스크립트릿 영역)
	String name="홍길동";
	out.write("name:"+name+"<br>");
	
%>
<%--  //jsp주석
<%
	String name="김길동";
%>
--%>
<form method="post" action="sum.jsp">
	수1<input type="text" name="num1"><br>
	수2<input type="text" name="num2"><br>
	<input type="submit" value="두수합">
</form>

</body>
</html>
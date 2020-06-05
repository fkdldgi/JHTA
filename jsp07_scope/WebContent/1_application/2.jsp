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
	String url=(String)application.getAttribute("url");
%>
<h1>어플리케이션에 저장된 url</h1>
url : <%=url %>
</body>
</html>
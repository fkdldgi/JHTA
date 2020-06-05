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
	String url="jdbc:oracle:thin:@localhost:1521:xe";
	//application스코프에 객체 넣기
	application.setAttribute("url", url);
	//application스코프에 저장된 객체 꺼내오기
	String a=(String)application.getAttribute("url");
%>
DB서버 URL: <%=a %>
</body>
</html>
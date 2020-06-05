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
	String id=request.getParameter("id");
	String pwd=request.getParameter("pwd");
	//세션유지시간 설정하기
	session.setMaxInactiveInterval(60*2); //초단위설정-2분
	
	session.setAttribute("id", id);
	session.setAttribute("pwd",pwd);
%>
<h1>세션에 저장완료!</h1>
id: <%=id %><br>
pwd: <%=pwd %><br>
<a href="mypage.jsp">마이페이지</a>
</body>
</html>
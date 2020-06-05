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
	//로그아웃기능
	//session.removeAttribute("id"); id 하나만 지우는 것이라 X
	session.invalidate();//세션방 무효화하기
%>
<h1>로그아웃되었습니다..</h1>
<a href="mypage.jsp">mypage.jsp</a>
</body>
</html>
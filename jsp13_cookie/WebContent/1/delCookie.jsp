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
	//쿠키삭제하기 -> 동일한 이름의 쿠키생성후 유지시간을 0으로 설정
	Cookie cookie=new Cookie("id","");
	cookie.setPath("/"); //생성된 쿠키와 경로가 동일해야됨
	cookie.setMaxAge(0); //쿠키가 더이상 서버로 전송되지 않음
	response.addCookie(cookie);
%>
<h1>쿠키삭제완료!</h1>
<a href="main.jsp">메인</a><br>
<a href="getCookie.jsp">쿠키보러가기</a><br>
</body>
</html>
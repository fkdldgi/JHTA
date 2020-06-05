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
	
	//사용자 정보 쿠키에 담기
	Cookie cookie1=new Cookie("id",id); //쿠키생성("쿠키이름",값(String만))
	cookie1.setPath("/"); //루트디렉토리(패스설정을 하지 않으면 다른디렉토리에서는 못꺼내옴)
	cookie1.setMaxAge(60*2); //쿠키유지시간 설정(초단위 - 2분)
	response.addCookie(cookie1); //응답객체에 쿠키담기
	Cookie cookie2=new Cookie("pwd",pwd); //쿠키생성
	cookie2.setMaxAge(60*2); //쿠키유지시간 설정(초단위 - 2분)
	response.addCookie(cookie2);
%>
<h1>쿠키에 저장완료!</h1>
<a href="main.jsp">메인</a><br>
<a href="getCookie.jsp">쿠키보러가기</a><br>
</body>
</html>
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
	String id=(String)session.getAttribute("id");
	if(id==null){
		response.sendRedirect("login.jsp");
	}else{
		
%>
<h1>마이페이지</h1>
<h2>회원님 정보</h2>
<ul>
	<li>이름:홍길동</li>
	<li>전화번호:010</li>
	<li>등급:골드회원</li>
</ul>
<%
	}
%>
</body>
</html>
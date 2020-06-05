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
	//세션에 저장된 정보 꺼내오기
	String id=(String)session.getAttribute("id");
	String pwd=(String)session.getAttribute("pwd");
%>
<h1>MyPage</h1>
<%=id %>님 환영합니다...<br>
<h3>회원님 정보</h3>
아이디: <%=id %><br>
비밀번호: <%=pwd %><br>
</body>
</html>
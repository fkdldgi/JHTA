<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>main페이지...</h1>
<%
	String id=(String)session.getAttribute("id");
%>
<!-- 로그아웃기능 추가하기(로그아웃 후 main.jsp로 페이지 이동되도록 하세요 -->
<ul>
	<%
	if(id==null){
	%>
		<li><a href="login.jsp">로그인</a></li>		
	<%
	}else{
	%>
		<li><a href="logout.jsp">로그아웃</a></li>
	<%
	}
	%>
	<li><a href="join.jsp">회원가입</a></li>
</ul>
</body>
</html>
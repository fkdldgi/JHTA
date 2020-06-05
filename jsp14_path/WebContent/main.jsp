<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main.jsp</title>
</head>
<body>
<%
	String cp=request.getContextPath();
%>
컨텍스트패스: <%=cp %><br>
<ul>
	<li><a href="1/login.jsp">로그인1</a></li>
	<li><a href="<%=cp %>/1/login.jsp">로그인2</a></li> <!-- jsp14_path는 contextPath -->
	<li><a href="servlet01">servlet01(상대)</a></li>
	<li><a href="/jsp14_path/servlet01">servlet02(절대)</a></li>
	<li><a href="member/login">GoLogin(상대)</a></li>
	<li><a href="/jsp14_path/member/login">GoLogin(절대)</a></li>
</ul>
</body>
</html>
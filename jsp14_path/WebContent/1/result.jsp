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
	String msg=(String)request.getAttribute("msg");
%>
msg : <%=msg %><br>
<a href="main.jsp">메인페이지(상대)</a><br>
<a href="<%=request.getContextPath()%>/main.jsp">메인페이지(절대)</a><br>

<a href="member/login">GoLogin(상대)</a><br>
<a href="<%=request.getContextPath()%>/member/login">GoLogin(절대)</a><br>
</body>
</html>
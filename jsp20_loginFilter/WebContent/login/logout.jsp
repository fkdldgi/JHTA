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
	session.invalidate();
%>
<h1>로그아웃되었습니다.....</h1>
<a href="${pageContext.request.contextPath }/main.jsp">메인</a>
</body>
</html>
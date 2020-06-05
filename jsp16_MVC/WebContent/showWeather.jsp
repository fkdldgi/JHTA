<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:choose>
	<c:when test="${param.day=='1' }">
		오늘의 날씨: ${requestScope.result }
	</c:when>
	<c:when test="${param.day=='2' }">
		내일의 날씨: ${requestScope.result }
	</c:when>
</c:choose>
<br>
<a href="main.jsp">메인</a>
</body>
</html>
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
	<c:when test="${code=='success' }">
		<h1>회원가입성공!!!!!!!!!!!!!!</h1>
	</c:when>
	<c:otherwise> test="${code=='success' }">
		<h1>회원가입실패!!!!!!!!!!!!!!</h1>
	</c:otherwise>
</c:choose>
<a href="${pageContext.request.contextPath }/main.jsp">메인페이지로 이동</a>
</body>
</html>
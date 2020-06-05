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
<h1>mylist</h1>
<c:forEach var="a" items="${list }">
	${a } &nbsp;
</c:forEach>
<br>
<a href="${pageContext.request.contextPath }/main.jsp">메인</a>
</body>
</html>
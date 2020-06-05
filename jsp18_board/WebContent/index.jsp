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
<h1>index페이지</h1>
<ul>
	<c:choose>
		<c:when test="${empty sessionScope.id }">
			<li><a href="${cp }/users/login.do">로그인</a></li>
		</c:when>
		<c:otherwise>
			<li>${id }님 반가워요! <a href="${cp }/users/logout.do">로그아웃</a></li>
		</c:otherwise>
	</c:choose>
	<li><a href="${cp }/board/insert.do">글등록</a></li>
	<li><a href="${cp }/board/list.do">글목록</a></li>
</ul>
</body>
</html>
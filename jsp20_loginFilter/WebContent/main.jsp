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
<h1>메인페이지</h1>
<c:set var="cp" value="${pageContext.request.contextPath }"/>
<ul>
	<c:choose>
		<c:when test="${not empty sessionScope.id }">
			<li><a href="${cp }/login/logout.jsp">로그아웃</a></li>
		</c:when>
		<c:otherwise>
			<li><a href="${cp }/login/login.jsp">로그인</a></li>
		</c:otherwise>
	</c:choose>
	<li><a href="${cp }/member/board.jsp">회원게시판</a></li>
	<li><a href="${cp }/member/mypage.jsp">마이페이지</a></li>
	<li><a href="${cp }/member/mylist">마이리스트</a></li>
</ul>
</body>
</html>
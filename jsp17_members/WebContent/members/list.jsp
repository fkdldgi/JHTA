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
<h1>회원목록</h1>
<table border="1" width="500">
	<tr>
		<th>회원번호</th><th>이름</th><th>전화</th><th>주소</th><th>가입일</th>
		<th>삭제</th><th>수정</th>
	</tr>
	<c:forEach var="vo" items="${requestScope.list }">
		<tr>
			<%--vo.getter()메소드가 호출된 것이다.(get메소드가 없으면 오류) --%>
			<td>${vo.num }</td>
			<td>${vo.name }</td>
			<td>${vo.phone }</td>
			<td>${vo.addr }</td>
			<td>${vo.regdate }</td>
			<c:set var="cp" value="${pageContext.request.contextPath }"/>
			<td><a href="${cp }/members/delete.do?num=${vo.num}">삭제</a></td>
			<td><a href="${cp }/members/update.do?num=${vo.num}">수정</a></td>
		</tr>
	</c:forEach>
</table>
</body>
</html>
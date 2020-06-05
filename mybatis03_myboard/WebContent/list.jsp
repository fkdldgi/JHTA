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
		<th>글번호</th>
		<th>작성자</th>
		<th>제목</th>
		<th>등록일</th>
		<th>삭제</th>
		<th>수정</th>
	</tr>
	<c:forEach var="vo" items="${list }">
		<tr>
			<td>${vo.num }</td>
			<td>${vo.writer }</td>
			<td>${vo.title }</td>
			<td>${vo.regdate }</td>
			<td><a href="${pageContext.request.contextPath }/myboard/delete?num=${vo.num }">삭제</a></td>
			<td><a href="${pageContext.request.contextPath }/myboard/update?num=${vo.num}&writer=${vo.writer}">수정</a></td>
		</tr>
	</c:forEach>
</table>
</body>
</html>
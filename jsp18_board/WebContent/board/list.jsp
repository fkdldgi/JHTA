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
<h1>글목록</h1>
<table border="1" width="500">
	<tr>
		<th>글번호</th>
		<th>작성자</th>
		<th>제목</th>
	</tr>
	<c:forEach var="vo" items="${requestScope.list }">
		<tr>
			<td>${vo.num }</td>
			<td>${vo.writer }</td>
			<td>
			<c:if test="${vo.lev>0 }">
				<c:forEach var="i" begin="1" end="${vo.lev }">
					&nbsp;&nbsp;
				</c:forEach>
				[re]
			</c:if>
			<a href="${cp }/board/detail.do?num=${vo.num }">${vo.title }</a>
			</td>
		</tr>
	</c:forEach>
</table>
<br>
<div><!-- 페이징처리 -->
	<!-- 한페이지씩 이동
	<c:choose>
		<c:when test="${pageNum==1}">
			[이전]
		</c:when>
		<c:otherwise>
			<a href="${cp }/board/list.do?pageNum=${pageNum-1}">[이전]</a>
		</c:otherwise>
	</c:choose>
	-->
	
	<!-- 10페이지 이상일경우 이전페이지로 이동 -->
	<c:if test="${startPageNum>10 }">
		<a href="${cp }/board/list.do?pageNum=${startPageNum-1}">[이전]</a>
	</c:if>
	<c:forEach var="i" begin="${startPageNum }" end="${endPageNum }">
		<c:choose>
			<c:when test="${i==pageNum }">
				<a href="${cp }/board/list.do?pageNum=${i}"><span style='color:blue'>[${i}]</span></a>
			</c:when>
			<c:otherwise>
				<a href="${cp }/board/list.do?pageNum=${i}"><span style='color:gray'>[${i}]</span></a>
			</c:otherwise>
		</c:choose>
	</c:forEach>
	<!-- 1-10페이지면 11-20페이지로 이동 -->
	<c:if test="${pageCount>endPageNum }">
		<a href="${cp }/board/list.do?pageNum=${endPageNum+1}">[다음]</a>
	</c:if>
	<!-- 한페이지 씩 이동
	<c:choose>
		<c:when test="${pageNum==pageCount }">
			[다음]
		</c:when>
		<c:otherwise>
			<a href="${cp }/board/list.do?pageNum=${pageNum+1}">[다음]</a>
		</c:otherwise>
	</c:choose>
	-->
</div>
</body>
</html>
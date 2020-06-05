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
			<a href="${cp }/board/detail.do?num=${vo.num }">${vo.title }</a>
			</td>
		</tr>
	</c:forEach>
</table>
<br>
<div>
	<c:if test="${startPageNum>4 }">
		<a href="${cp }/board/list.do?pageNum=${startPageNum-1}">[이전]</a>
	</c:if>
	<c:forEach var="i" begin="${startPageNum }" end="${endPageNum }">
		<c:choose>
			<c:when test="${i==pageNum }">
				<c:if test="${chk==1 }">
					<a href="${cp }/board/list.do?pageNum=${i}"><span style='color:blue'>[${i}]</span></a>
				</c:if>
				<c:if test="${chk==2 }">
					<a href="${cp }/board/search.do?pageNum=${i}&chkbox=${chkbox}&search=${search}"><span style='color:blue'>[${i}]</span></a>
				</c:if>
			</c:when>
			<c:otherwise>
				<c:if test="${chk==1 }">
					<a href="${cp }/board/list.do?pageNum=${i}"><span style='color:gray'>[${i}]</span></a>
				</c:if>
				<c:if test="${chk==2 }">
					<a href="${cp }/board/search.do?pageNum=${i}&chkbox=${chkbox}&search=${search}"><span style='color:gray'>[${i}]</span></a>
				</c:if>
			</c:otherwise>
		</c:choose>
	</c:forEach>
	<c:if test="${pageCount>endPageNum }">
		<c:if test="${chk==1 }">
			<a href="${cp }/board/list.do?pageNum=${endPageNum+1}">[다음]</a>
		</c:if>
		<c:if test="${chk==2 }">
			<a href="${cp }/board/search.do?pageNum=${endPageNum+1}&chkbox=${chkbox}&search=${search}">[다음]</a>
		</c:if>
	</c:if>
</div>
<div>
	<form method="post" action="${cp }/board/search.do">
		<select name="chkbox">
			<c:choose>
				<c:when test="${chkbox==1 }">
					<option value="1" selected>작성자</option>
					<option value="2">제목</option>
					<option value="3">내용</option>
				</c:when>
				
				<c:when test="${chkbox==2 }">
					<option value="1">작성자</option>
					<option value="2" selected>제목</option>
					<option value="3">내용</option>
				</c:when>
				<c:when test="${chkbox==3 }">
					<option value="1">작성자</option>
					<option value="2">제목</option>
					<option value="3" selected>내용</option>
				</c:when>
				<c:otherwise>
					<option value="1">작성자</option>
					<option value="2">제목</option>
					<option value="3">내용</option>
				</c:otherwise>
			</c:choose>
		</select>
		<input type="text" name="search">
		<input type="submit" value="검색">
	</form>
</div>
</body>
</html>
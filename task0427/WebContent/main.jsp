<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<ul>
	<li><a href="${pageContext.request.contextPath }/board/write.jsp">글쓰기</a></li>
	<li><a href="${pageContext.request.contextPath }/board/list.do">글목록</a></li>
	<li><a href="${pageContext.request.contextPath }/board/search.jsp">검색</a></li>
</ul>
</body>
</html>
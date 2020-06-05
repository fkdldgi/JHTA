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
	<li><a href="">홈으로</a></li>
	<li><a href="${cp }/board/insert.do">글작성</a></li>
	<li><a href="${cp }/board/list.do">글목록</a></li>
</ul>
</body>
</html>
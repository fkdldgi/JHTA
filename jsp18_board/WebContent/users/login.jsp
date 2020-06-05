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
<h1>회원로그인</h1>

<c:if test="${!empty errMsg}">
<script type="text/javascript">
	alert("${errMsg}");
</script>
</c:if>

<form method="post" action="${cp }/users/login.do">
	아이디<input type="text" name="id"><br>
	비밀번호<input type="password" name="pwd"><br>
	<div>${requestScope.errMsg }</div>
	<input type="submit" value="로그인">
</form>
</body>
</html>
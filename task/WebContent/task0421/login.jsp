<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="loginOk.jsp" method="post">
	아이디 <input type="text" name="id"><br>
	비밀번호 <input type="password" name="pwd"><br>
	<input type="submit" value="로그인">
	<input type="reset" value="취소" onclick=history.go(-1)>
</form>
</body>
</html>
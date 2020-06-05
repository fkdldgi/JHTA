<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 자바빈즈를 이용해서 loginOk.jsp에서 전달된 아이디와 비밀번호를 출력해보세요. --> 
<form method="post" action="loginOk.jsp">
	아이디 <input type="text" name="id"><br>
	비밀번호 <input type="password" name="pwd"><br>
	<input type="submit" value="로그인">
	<input type="reset" value="취소" onclick=history.go(-1)>
</form>
</body>
</html>
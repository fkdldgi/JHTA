<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id="Login" class="test.beans.Login" scope="session"/>
<jsp:setProperty property="*" name="Login"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>로그인 성공!</h1>
아이디: <jsp:getProperty property="id" name="Login"/><br>
비밀번호 <jsp:getProperty property="pwd" name="Login"/>
</body>
</html>
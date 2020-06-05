<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>사용자가 보내온 정보</h1>
작성자 : ${param.writer }<br>
제목 : ${param.title }<br>
내용 : ${param.content }<br>
</body>
</html>
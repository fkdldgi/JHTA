<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="searchOk.jsp">
	제목 <input type="text" name="title">
	<input type="submit" value="검색"><br>
	<input type="reset" value="뒤로가기" onclick=history.go(-1)>
</form>
</body>
</html>
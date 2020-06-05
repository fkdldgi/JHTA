<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>회원정보수정</h1>
<form method="post" action="${pageContext.request.contextPath }/myboard/update">
	<input type="hidden" name="num" value="${num }">
	작성자 <br>
	<input type="text" name="writer" value="${writer }" readonly="readonly"><br>
	비밀번호<br>
	<input type="password" name="pwd"><br>
	제목<br>
	<input type="text" name="title"><br>
	내용<br>
	<textarea rows="5" cols="60" name="content"></textarea><br>
	<input type="submit" value="등록">
</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/board/write.do">
	작성자 <input type="text" name="writer"><br>
	이메일 <input type="text" name="email"><br>
	제목 <input type="text" name="title"><br>
	내용 <input type="text" name="content"><br>
	<input type="submit" value="완료">
	<input type="reset" value="취소" onclick=history.go(-1)>
</form>
</body>
</html>
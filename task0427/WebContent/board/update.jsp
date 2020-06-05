<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/board/updateOk.do" method="post">
	회원번호 <input type="text" name="num" value="${requestScope.vo.num }" readonly="readonly"><br>
	작성자 <input type="text" name="writer" value="${requestScope.vo.writer }" readonly="readonly"><br>
	이메일 <input type="text" name="email" value="${requestScope.vo.email }" readonly="readonly"><br>
	제목 <input type="text" name="title" value="${requestScope.vo.title }"><br>
	내용 <input type="text" name="content" value="${requestScope.vo.content }"><br>
	<input type="submit" value="완료">
	<input type="reset" value="취소">
</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/members/updateOk.do">
	회원번호: <input type="text" name="num" value="${requestScope.vo.num }" readonly="readonly"><br>
	이름: <input type="text" name="name" value="${requestScope.vo.name }"><br>
	전화번호: <input type="text" name="phone" value="${requestScope.vo.phone }"><br>
	주소: <input type="text" name="addr" value="${requestScope.vo.addr }"><br>
	<input type="submit" value="완료">
	<input type="reset" value="취소">
</form>
</body>
</html>
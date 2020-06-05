<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	session.invalidate(); //세션방 무효화하기(세션메모리 전체 다 지우기)
%>
<script type="text/javascript">
	alert("로그아웃되었습니다.");
	location.href='main.jsp';
</script>
</body>
</html>
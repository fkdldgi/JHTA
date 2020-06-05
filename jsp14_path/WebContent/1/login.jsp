<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="../main.jsp">메인페이지(상대경로)</a><br>
<a href="/jsp14_path/main.jsp">메인페이지(절대경로)</a><br> <!-- 톰캣서버에 저장될 때 WebContent는 사라짐 -->
<%
	String cp=request.getContextPath();
%>
<h1>회원로그인</h1>
<form method="post" action="<%=cp %>/member/loginOk">
	아이디<input type="text" name="id"><br>
	비밀번호<input type="password" name="pwd"><br>
	<input type="submit" value="로그인">
</form>
</body>
</html>

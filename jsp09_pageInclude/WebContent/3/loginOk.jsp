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
	String id=request.getParameter("id");
	String pwd=request.getParameter("pwd");
	if(id.equals("admin") && pwd.equals("admin")){
		session.setAttribute("id", id);
		response.sendRedirect("layout.jsp?file=main.jsp");
	}else{
%> 
	<script>
		alert("아이디 또는 비밀번호가 맞지 않아요!");
		history.go(-1);
	</script>
<%
	}
%>
</body>
</html>
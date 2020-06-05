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
	if(id.equals("test") && pwd.equals("1234")){
		session.setAttribute("id", id);
		response.sendRedirect(request.getContextPath()+"/main.jsp");
	}else{
		response.sendRedirect(request.getContextPath()+"/login/login.jsp");
	}
%>
</body>
</html>
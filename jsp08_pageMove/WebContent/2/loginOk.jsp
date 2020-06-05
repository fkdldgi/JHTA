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
	if(id.equals("admin") && pwd.equals("1234")){ //회원인 경우
		session.setAttribute("id", id);
		response.sendRedirect("main.jsp");
	}else{ //회원이 아닌경우
		request.setAttribute("errMsg","아이디 또는 비밀번호가 틀려요.");
		request.setAttribute("id",id);
		request.setAttribute("pwd",pwd);
		pageContext.forward("login.jsp");
	}
%>
</body>
</html>
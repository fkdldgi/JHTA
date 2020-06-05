<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>loginOk.jsp페이지...</h1>
<%
	String id=request.getParameter("id");
	String pwd=request.getParameter("pwd");
	//request스코프 값 담기
	request.setAttribute("id", id);
	request.setAttribute("pwd",pwd);
	//리다이렉트방식으로 페이지 이동하기
	//response.sendRedirect("result.jsp");
	//포워드방식으로 페이지 이동하기
	RequestDispatcher rd=request.getRequestDispatcher("result.jsp");
	rd.forward(request,response);
%>
</body>
</html>
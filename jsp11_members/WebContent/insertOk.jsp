<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="mem" class="test.vo.MembersVo"/>
<jsp:setProperty property="*" name="mem"/>
<jsp:useBean id="dao" class="test.dao.MembersDao"/>
<%
	int n=dao.insert(mem);
	if(n>0){
%>
	<h1>회원가입성공!!!!!!!!!!!!</h1>
<%
	}else{
%>
	<h1>회원가입실패!!!!!!!!!!!!!!!</h1>
<%
	}
%>
<a href="main.jsp">main</a>
</body>
</html>
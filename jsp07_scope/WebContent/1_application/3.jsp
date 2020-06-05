<%@page import="java.util.Enumeration"%>
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
	//application 스코프에 저장된 객체들의 이름들 얻어오기
	Enumeration em=application.getAttributeNames();
	while(em.hasMoreElements()){
		String name=(String)em.nextElement();
		Object attr=application.getAttribute(name);
		out.print("<p>"+name+":"+attr+"</p>");
	}
%>
</body>
</html>
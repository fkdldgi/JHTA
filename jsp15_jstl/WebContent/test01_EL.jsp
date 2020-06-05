<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--
	EL (Expression Language) - 수식언어
	1) 형식 ${표현식}
	2) EL연산자 : +,-,*,/,%,empty,not,mod,<,<=,>,>=,lt(<),gt(>),le(<=),ge(>=),eq(==),ne(!=),
				&&,||,or,...
	3) EL내장객체
	   - requestScope,sessionScope,applicationScope,param,pageContext,
	     paramValues,header,headerValues,cookie,initParam,...
 --%>
 10+20= <%=10+20 %><br>
 10+20= ${10+20 }<br>
 10==20 = ${10 eq 20 }<br>
 10>20 = ${10 gt 20 }<br>
 <%
 	String id="admin";
 	session.setAttribute("id",id);
 	request.setAttribute("name", "홍길동");
 	
 %>
 <%
 	String a=(String)session.getAttribute("id");
 %>
 아이디1: <%=a %><br>
 아이디2: ${sessionScope.id }<br>
 이름 : ${requestScope.name }<br>
num1: ${param.num1 }<br>
num2: ${param.num2 }<br>
</body>
</html>
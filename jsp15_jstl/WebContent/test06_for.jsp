<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% int[] a={10,20,30,40,50}; %>
<c:set var="a" value="<%=a %>"/>
<%-- 배열이나 컬렉션객체(ArrayList,...)등은 items속성을 사용하여 쉽게 요소를
꺼내올 수 있다. --%>
<c:forEach var="n" items="${a }"> <%--배열 요소가 순차적으로 n에 저장됨 --%>
	${n } &nbsp;
</c:forEach>
<br>
<%-- varStatus: 상태값에 대한 정보를 갖음 --%>
<c:forEach var="n" items="${a }" varStatus="st">
	${st.index} : ${n } &nbsp;
</c:forEach>
<br>
<%
	ArrayList<String> list=new ArrayList<String>();
	list.add("홍길동");
	list.add("이길동");
	list.add("김길동");
	request.setAttribute("list", list);
%>
<%-- requestScope 생략 가능. 생략되면 requestScope,sessionScope,applicationScope순서로 찾는다--%>
<c:forEach var="name" items="${requestScope.list }">
	${name } &nbsp;
</c:forEach>
</body>
</html>
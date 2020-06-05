 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="header">
	<%@include file="header.jsp" %>
</div>
<div id="content">
	<h1>중앙HTA</h1>
	<p>환영합니다!!!!</p>
	
	<%--
	<jsp:include page="삽입페이지"/> => 응답결과(html)가 삽입됨
	<%@include file="삽입파일"/> => 자바코드자체가 결합됨
	 --%>
	<!-- 자바코드와 결합되므로 header.jsp에서 선언된 변수를 사용할 수 있다. -->
	<p>프로젝트명:<%=context %></p>
</div>
<div id="footer"></div>
</body>
</html>
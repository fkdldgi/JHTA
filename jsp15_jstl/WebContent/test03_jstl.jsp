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
<%-- jstl에서 변수선언하기 --%>
<c:set var="name" value="홍길동"/>
name : ${name }<br>
<%
	String userName="김길동";
%>
userName: <%=userName %><br>
userName: =${userName } <%-- 스크립트릿에서 선언된 변수는 EL로 사용못함 --%>
<%--
	<c:if test="${조건식}">
		조건이 참일 때 수행할 문장
	</c:if>
 --%>
 <% session.setAttribute("id", "admin"); %>
 <c:if test="${sessionScope.id=='admin'}">
 	당신은 관리자이군요!<br>
 </c:if>
 <c:if test="${sessionScope.id!='admin'}">
 	당신은 일반회원이군요!<br>
 </c:if>
 <c:set var="grade" value="gold"/>
 <c:choose>
 	<c:when test="${grade=='gold' }">
 		당신의 등급은 GOLD입니다.<br>
 	</c:when>
 	<c:when test="${grade=='silver' }">
 		당신의 등급은 silver입니다.<br>
 	</c:when>
 	<c:otherwise>
 		당신은 일반회원입니다.<br>
 	</c:otherwise>
 </c:choose>
</body>
</html>
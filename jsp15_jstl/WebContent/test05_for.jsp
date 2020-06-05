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
<%--
 <c:forEach var="변수명" begin="초기값" end="끝값" step="증가값">
 	반복문장
 </c:forEach>
 --%>
 <!-- 1부터 100까지 출력하기 -->
 <c:forEach var="i" begin="1" end="100" step="1">
 	${i } &nbsp;
 </c:forEach>
 <c:forEach var="i" begin="1" end="100"> <%-- step이 1인경우 생략가능 --%>
 	<c:set var="sum" value="${sum+i }"/>
 </c:forEach>
 <br>1부터 100까지의 합 : ${sum }<br>
 
  <c:forEach var="i" begin="1" end="100"> <%-- step이 1인경우 생략가능 --%>
 	<c:if test="${i mod 2 == 0 }">
 		<c:set var="sum1" value="${sum1+i }"/>
 	</c:if>
 </c:forEach>
 1부터 100까지의 짝수 합 : ${sum1 }<br>
 
 <!-- 
 	2단~9단 출력
 	한단은 한줄에 출력
 -->
 <c:forEach var="i" begin="2" end="9">
 	${i }단:
 	<c:forEach var="j" begin="1" end="9">
 		${i } * ${j } = ${i*j } &nbsp;
 	</c:forEach>
 	<br>
 </c:forEach>
</body>
</html>
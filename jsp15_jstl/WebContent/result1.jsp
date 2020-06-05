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
<c:if test="${param.num1 mod 2==0 }">
	방법1:짝수입니다<br>
</c:if>
<c:if test="${param.num1 mod 2==1 }">
	방법1:홀수입니다<br>
</c:if>

<c:choose>
	<c:when test="${param.num1 mod 2==0 }">
		방법2:짝수입니다<br>
	</c:when>
	<c:otherwise>
		방법2:홀수입니다<br>
	</c:otherwise>
</c:choose>

</body>
</html>
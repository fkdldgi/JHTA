<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>냉장고 상세페이지</h1>
<ul>
	<li>1.모델명: xxx냉장고</li>
	<li>2.가격: 1,000,000원</li>
	<li>3. 제조사 : LG</li>
</ul>
<%
	//쿠키에 상품정보 담기
	Cookie cook=new Cookie("item1","냉장고");
	cook.setMaxAge(60*60);
	response.addCookie(cook);
%>
<a href="list.jsp">목록페이지</a>
</body>
</html>
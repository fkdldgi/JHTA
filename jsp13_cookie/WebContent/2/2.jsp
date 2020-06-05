<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>TV 상세페이지</h1>
<ul>
	<li>1.모델명: xxxTV</li>
	<li>2.가격: 2,000,000원</li>
	<li>3. 제조사 : 삼성</li>
</ul>
<%
	//쿠키에 상품정보 담기
	Cookie cook=new Cookie("item2","TV");
	cook.setMaxAge(60*60);
	response.addCookie(cook);
%>
<a href="list.jsp">목록페이지</a>
</body>
</html>
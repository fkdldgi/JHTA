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
	//클라이언트에서 서버로 보내진 쿠키 얻어오기(배열)
	Cookie[] cooks=request.getCookies();
	if(cooks!=null){
		for(Cookie cookie:cooks){
			String cookieName=cookie.getName();
			String cookieValue=cookie.getValue();
			out.print(cookieName+": "+cookieValue+"<br>");
		}
	}else{
%>
	<h1>전송된 쿠키가 없어요!</h1>
<%

	}

%>
<a href="main.jsp">메인</a>
</body>
</html>
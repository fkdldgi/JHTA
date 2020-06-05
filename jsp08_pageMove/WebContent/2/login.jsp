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
	String errMsg=(String)request.getAttribute("errMsg");
	if(errMsg==null){
		errMsg="";
	}
	String id=(String)request.getAttribute("id");
	//String id=request.getParameter("id");
	String pwd=(String)request.getAttribute("pwd");
	if(id==null && pwd==null){
		id="";
		pwd="";
	}
%>
<h1>회원로그인</h1>
<form method="post" action="loginOk.jsp">
<!-- 아이디와 비밀번호가 틀린경우 -->
	아이디<input type="text" name="id" value=<%=id %>><br>
	비밀번호<input type="password" name="pwd" value=<%=pwd %>><br>
	<div id="errMsg"><%=errMsg %></div>
	<input type="submit" value="로그인">
</form>
<br>
</body>
</html>
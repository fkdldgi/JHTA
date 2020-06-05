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
	String id=(String)session.getAttribute("id");
	String email=(String)session.getAttribute("email");
%>
<form action="writeOk.jsp">
	작성자 <input type="text" name="writer" value=<%=id %> readonly="readonly"><br>
	이메일 <input type="text" name="email" value=<%=email %> readonly="readonly"><br>
	글제목 <input type="text" name="title"><br>
	글내용 <input type="text" name="content"><br>
	<input type="submit" value="저장" style="margin-left:55px; width:85px">
	<input type="reset" value="취소" style="width:85px" onclick="history.go(-1)">
</form>
</body>
</html>
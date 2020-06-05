<%@page import="test.vo.MembersVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% int num=Integer.parseInt(request.getParameter("num")); %>
<jsp:useBean id="mem" class="test.dao.MembersDao"/>
<%
	MembersVo vo=mem.select(num);
%>
<form action="updateOk.jsp" method="post">
	회원번호<input type="text" name="num" value="<%=vo.getNum() %>" readonly="readonly"><br>
	이름<input type="text" name="name" value="<%=vo.getName() %>"><br>
	전화번호<input type="text" name="phone" value="<%=vo.getPhone() %>"><br>
	주소<input type="text" name="addr" value="<%=vo.getAddr() %>"><br>
	가입일<input type="text" value="<%=vo.getRegdate() %>" readonly="readonly"><br>
	<input type="submit" value="완료">
	<input type="reset" value="취소" onclick=history.go(-1)>
</form>
</body>
</html>
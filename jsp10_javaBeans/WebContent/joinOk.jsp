<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>
<%-- Members members=new Members();와 동일한 의미 --%>    
 <jsp:useBean id="members" class="test.beans.Members"/>
 <%-- members.setName(request.getParameter("name"));와 동일한 의미
 <jsp:setProperty property="name" name="members"/>
 <jsp:setProperty property="phone" name="members"/>
 <jsp:setProperty property="addr" name="members"/>
  --%>
 <!-- 전달된 모든 파라미터값들을 멤버변수에 저장 -->
 <jsp:setProperty property="*" name="members"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>전송된 회원정보</h1>
이름<jsp:getProperty property="name" name="members"/><br>
전화번호<jsp:getProperty property="phone" name="members"/><br>
주소<jsp:getProperty property="addr" name="members"/><br>
</body>
</html>
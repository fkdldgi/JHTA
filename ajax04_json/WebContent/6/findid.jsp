<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String email=request.getParameter("email");
	String pwd=request.getParameter("pwd");
	String id="";
	boolean find=false;
	if((email!=null && email.equals("test@daum.net")) && (pwd!=null && pwd.equals("1234"))){
		id="hellohello";
		find=true;
	}
	if(find==true){
%>
		<h1>회원님의 아이디는 <%=id%>입니다.</h1>
<%
	}else{
%>
		<h1>요청하신 정보를 찾지 못했어요~~~</h1>
<%
	}
%>
<img src="../images/1.png">
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
	String id=request.getParameter("id");
	String pwd=request.getParameter("pwd");
	String chk=request.getParameter("chk");
	
	Cookie cook1=new Cookie("id",id);
	cook1.setPath("/");
	
	Cookie cook2=new Cookie("pwd",pwd);
	cook2.setPath("/");
	
	Cookie cook3=new Cookie("chk",chk);
	cook3.setPath("/");
	
	if(chk==null){  //자동로그인이 체크되어있지 않을 경우
		cook1.setMaxAge(0); //쿠키삭제
		cook2.setMaxAge(0);
		cook3.setMaxAge(0);
	}else{ 			//자동로그인이 체크되어 있을 경우
		cook1.setMaxAge(60*60*24*30); //한달
		cook2.setMaxAge(60*60*24*30);
		cook3.setMaxAge(60*60*24*30);
	}
	response.addCookie(cook1);
	response.addCookie(cook2);
	response.addCookie(cook3);
%>
<h1>로그인 성공!!</h1>
<a href="<%=request.getContextPath()%>/login.jsp">로그아웃</a>
</body>
</html>
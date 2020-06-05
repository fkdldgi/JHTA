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
	String id="";
	String pwd="";
	String chk="";
	Cookie[] cooks=request.getCookies();
	if(cooks!=null){
		for(Cookie cookie:cooks){
			if(cookie.getName().equals("id")){
				id=cookie.getValue();
			}else if(cookie.getName().equals("pwd")){
				pwd=cookie.getValue();
			}else if(cookie.getName().equals("chk")){
				chk=cookie.getValue();
				if(chk==null){
					chk="";
				}else{
					chk="checked";
				}
			}
		}
	}
%>
<h1>회원로그인</h1>
<form method="post" action="loginOk.jsp">
	아이디<input type="text" name="id" value=<%=id %>><br>
	비밀번호<input type="password" name="pwd" value=<%=pwd %>><br>
	<input type="checkbox" name="chk" <%=chk %>> 자동로그인<br>
	<input type="submit" value="로그인">
	<input type="reset" value="취소">
</form>
</body>
</html>
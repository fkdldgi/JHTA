<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<form action="registerOk.jsp" method="post">
	아이디 <input type="text" name="id"><br>
	비밀번호 <input type="password" name="pwd"><br>
	이메일 <input type="text" name="email"><br>
	<input type="submit" value="완료">
	<input type="reset" value="취소" onclick=history.go(-1)>
</form>
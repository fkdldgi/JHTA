<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function pwdCheck(){
		var pwd=document.getElementById("pwd").value;
		var inputPwd=document.getElementById("inputPwd").value;
		if(pwd==inputPwd){
			return true;
		}else{
			var span=document.getElementById("span");
			span.innerHTML="비밀번호가 일치하지 않습니다.";
			return false;
		}
	}	
</script>
</head>
<body>
<h1>상세글보기</h1>
<table border="1" width="600">
	<tr>
		<td>글번호</td>
		<td>${vo.num }</td>
	</tr>
	<tr>
		<td>작성자</td>
		<td>${vo.writer }</td>
	</tr>
	<tr>
		<td>제목</td>
		<td>${vo.title }</td>
	</tr>
	<tr>
		<td>내용</td>
		<td><div style="width:500px; height:300px;">${vo.content }</div></td>
	</tr>
</table>
<div>
	<form action="${cp }/board/delete.do" onsubmit="return pwdCheck();">
		<input type="hidden" name="num" value="${vo.num }">
		<input type="hidden" name="pwd" id="pwd" value="${vo.pwd }">
		비밀번호<input type="text" name="inputPwd" id="inputPwd">
		<input type="submit" value="삭제"><span id="span"></span>
	</form>
</div>
</body>
</html>
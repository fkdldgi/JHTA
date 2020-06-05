<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>상세글보기</h1>
<table border="1" width="600">
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
	<tr>
		<td colspan="2">
			<a href="${cp }/board/insert.do?num=${vo.num}&ref=${vo.ref}&lev=${vo.lev}&step=${vo.step}">답글</a>
		</td>
	</tr>
</table>
</body>
</html>
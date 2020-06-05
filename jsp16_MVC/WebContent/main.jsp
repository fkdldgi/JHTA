<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<ul>
	<li><a href="fortune.do">오늘의 운세</a></li>
	<li><a href="weather.do?day=1">오늘의 날씨</a></li>
	<li><a href="weather.do?day=2">내일의 날씨</a></li>
</ul>

<form method="post" action="sum.do">
	수1<input type="text" name="n1"><br>
	수2<input type="text" name="n2"><br>
	<input type="submit" value="합구하기">
</form>
</body>
</html>
<%@page import="test.vo.FileinfoVo"%>
<%@page import="test.dao.FileinfoDao"%>
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
	int filenum=Integer.parseInt(request.getParameter("filenum"));
	FileinfoDao dao=new FileinfoDao();
	FileinfoVo vo=dao.select(filenum);
%>
<h1>수정하기</h1>
<form action="updateOk.jsp" method="post" enctype="multipart/form-data">
	파일번호<br><input type="text" name="filenum" value=<%=filenum %> readonly="readonly"><br>
	작성자 <br><input type="text" name="writer" value=<%=vo.getWriter() %> readonly="readonly"><br>
	제목 <br><input type="text" name="title" value=<%=vo.getTitle() %>><br>
	내용 <br><textarea rows="5" cols="50" name="content" ><%=vo.getContent() %></textarea><br>
	저장된파일명 <br><input type="text" name="file1" value=<%=vo.getSavefilename() %> readonly="readonly"><br>
	수정할파일<br><input type="file" name="file2"><br>
	<input type="submit" value="완료">
	<input type="reset" value="취소" onclick=history.go(-1)>
</form>
</body>
</html>
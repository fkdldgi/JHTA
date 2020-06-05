<%@page import="test.vo.FileinfoVo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="test.dao.FileinfoDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
	tr{text-align: center;}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>파일목록</h1>
<table border="1" width="600px">
	<tr>
		<th>파일번호</th>
		<th>작성자</th>
		<th>제목</th>
		<th>원본파일명</th>
		<th>파일크기</th>
		<th>삭제</th>
		<th>수정</th>
		<th>이미지</th>
	</tr>
<%
	FileinfoDao dao=new FileinfoDao();
	ArrayList<FileinfoVo> list=dao.selectAll();
	for(FileinfoVo vo:list){
		int filenum=vo.getFilenum();
		String writer=vo.getWriter();
		String title=vo.getTitle();
		String content=vo.getContent();
		String orgfilename=vo.getOrgfilename();
		String savefilename=vo.getSavefilename();
		long filesize=vo.getFilesize();
		String upload=application.getRealPath("upload");
		%>
			<tr>
				<td><%=filenum %></td>
				<td><%=writer %></td>
				<td><%=title %></td>
				<td><%=orgfilename %></td>
				<td><%=filesize %></td>
				<td><a href="delete.jsp?filenum=<%=filenum%>">삭제</a></td>
				<td><a href="update.jsp?filenum=<%=filenum %>">수정</a></td>
				<td><img src="upload/<%=vo.getSavefilename()%>"
											style="width:100px; height:100px"></td> <!-- 웹상의 주소를 가져와야된다 -->
			</tr>
		<%
	}
%>
</table>
</body>
</html>
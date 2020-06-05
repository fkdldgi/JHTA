<%@page import="test.vo.FileinfoVo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="test.dao.FileinfoDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	img{width:200px;height: 200px;}
	th{width:200px;height:200px;}
</style>
</head>
<body>
<%
	String upload=application.getRealPath("upload");
	FileinfoDao dao=new FileinfoDao();
%>
<h1>이미지게시판</h1>
<table border="1" width="600px">
	<tr>
<%
	ArrayList<FileinfoVo> list=dao.selectAll();
	for(int i=0; i<list.size(); i++){
		FileinfoVo vo=list.get(i);
		if(i!=0 && i%3==0){
		%>
			</tr>
			<tr>
		<%
		}
		%>
			<th><img src="upload/<%=vo.getSavefilename() %>"><br><%=vo.getTitle() %></th>
		<%
	}
%>
	</tr>
</table>
</body>
</html>
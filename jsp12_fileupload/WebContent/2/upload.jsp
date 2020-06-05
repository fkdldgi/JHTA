<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
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
	String upload=application.getRealPath("/upload");
	MultipartRequest mr=new MultipartRequest(request,upload,1024*1024*5,"utf-8",new DefaultFileRenamePolicy());
	String writer=mr.getParameter("writer");
	String title=mr.getParameter("title");
	String content=mr.getParameter("content");
%>
<%=upload %><br>
작성자 <%=writer %><br>
제목 <%=title %><br>
내용 <%=content %><br>
<%
	//전송된 파일들의 파라미터명 얻어오기(몇개의 파일이 넘어올 지 모르기 때문에 사용)
	Enumeration<String> em=mr.getFileNames();
	while(em.hasMoreElements()){
		String file=em.nextElement();
		String orgfilename=mr.getOriginalFileName(file);
		String savefilename=mr.getFilesystemName(file);
		out.print("전송된 파일명:" + orgfilename + "<br>");
		out.print("저장된 파일명:" + savefilename + "<br>");
	}
%>
</body>
</html>
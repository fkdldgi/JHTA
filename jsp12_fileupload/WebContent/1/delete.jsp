<%@page import="java.io.File"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
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
	//업로드된 파일경로
	String upload=application.getRealPath("/upload");
	FileinfoDao dao=new FileinfoDao();
	int filenum=Integer.parseInt(request.getParameter("filenum"));

	//실제 파일삭제
	String savefileName=dao.selectPath(filenum);
	File file=new File(upload+"\\"+savefileName);
	//DB삭제
	try{
		file.delete();
		dao.delete(filenum); //2.DB에서 삭제
	}catch(Exception e){
		System.out.println(e.getMessage());
		out.print("오류로 인해 삭제 실패!!!!");
	}
%>
</body>
</html>
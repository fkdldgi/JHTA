<%@page import="test.dao.FileinfoDao"%>
<%@page import="test.vo.FileinfoVo"%>
<%@page import="java.io.File"%>
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
	out.println("path:"+upload);
	
	MultipartRequest mr=new MultipartRequest(
			request, //request 객체(getParameter 불가)
			upload, //업로드할 디렉토리
			1025*1024*5, //최대업로드 크기(5MB)
			"utf-8", //인코딩방식
			new DefaultFileRenamePolicy() //중복되는 파일명이 업로드되면
		);
	int filenum=Integer.parseInt(mr.getParameter("filenum"));
	String writer=mr.getParameter("writer");
	String title=mr.getParameter("title");
	String content=mr.getParameter("content");
	String delFile=mr.getParameter("file1");
	String saveFile=mr.getParameter("file2");

	//수정할 파일
	String orgfilename=mr.getOriginalFileName("file2");
	String savefilename=mr.getFilesystemName("file2");
	
	FileinfoVo vo=null;
	FileinfoDao dao=new FileinfoDao();
	try{
		FileinfoVo vo1=dao.select(filenum); //기존정보를 갖는vo 객체
		if(orgfilename!=null){ //수정할 파일이 전송된 경우
			//1.기존파일 삭제하기
			File file1=new File(upload+"\\"+delFile);
			file1.delete();
			File file2=mr.getFile("file2");
			long filesize=file2.length(); //전송된 파일크기 얻어오기
			//2. 수정된 정보로 갱신하기
			
			vo= 
			new FileinfoVo(filenum,writer,title,content,orgfilename,savefilename,filesize);
		}else{ //수정할 파일이 전송되지 않은 경우 -기존파일 유지
			vo=new FileinfoVo(
					filenum,writer,title,content,vo1.getOrgfilename(),vo1.getSavefilename(),vo1.getFilesize());
		}
		dao.update(vo);
		response.sendRedirect("list.jsp");
	}catch(Exception e){
		e.printStackTrace();
		out.print("<h1>수정 실패!!</h1>");
	}
	

	
	
	
	
	
	
%>
</body>
</html>
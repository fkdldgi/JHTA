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
	request.setCharacterEncoding("utf-8");
	String writer=request.getParameter("writer");
	String title=request.getParameter("title");
	String content=request.getParameter("content");
	String scnt=request.getParameter("cnt");
	int cnt=0;
	//처음에는 scnt가 null이므로 조건문 넣어줌
	if(scnt!=null){
		cnt=Integer.parseInt(scnt);
	}else{
		writer="";
		title="";
		content="";
		scnt="0";
	}
%>
<h1>파일업로드하기</h1>

<!-- 
	< 파일업로드시 설정하기 >
	enctype="multipart/form-data"
	method="post"
 -->
<form method="post" action="insert.jsp">
	작성자<br>
	<input type="text" name="writer" value=<%=writer %>><br>
	제목<br>
	<input type="text" name="title" value=<%=title %>><br>
	내용<br>
	<textarea rows="5" cols="50" name="content" ><%=content %></textarea><br>
	첨부파일갯수<br>
	<input type="text" name="cnt" value=<%=scnt %>><br>
	<input type="submit" value="확인">
</form>

<form action="upload.jsp" method="post" enctype="multipart/form-data">
	<input type="hidden" name="writer" value="<%=writer %>">
	<input type="hidden" name="title" value="<%=title %>">
	<input type="hidden" name="content" value="<%=content %>">
	<%
		for(int i=1; i<=cnt; i++){
			
	%>
		첨부파일<%=i %> <input type="file" name="file<%=i %>"><br>
	<%
		}
	
	%>
	<input type="submit" value="전송">
</form>
</body>
</html>
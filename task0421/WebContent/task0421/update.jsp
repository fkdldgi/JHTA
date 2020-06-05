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
	String id=(String)session.getAttribute("id");
	request.setCharacterEncoding("utf-8");
	int num=Integer.parseInt(request.getParameter("num"));
	String writer=request.getParameter("writer");
	String email=request.getParameter("email");
	String title=request.getParameter("title");
	String content=request.getParameter("content");
	if(!id.equals(writer)){
		%>
		<script type="text/javascript">
			alert("다른사람의 게시글을 수정할 수 없습니다!");
			history.go(-1);
		</script>
		<%
	}
%>
<form action="updateOk.jsp" method="post">
	글번호 <input type="text" name="num" value=<%=num %> readonly="readonly"><br>
	글쓴이 <input type="text" name="writer" value=<%=writer %> readonly="readonly"><br>
	이메일 <input type="text" name="email" value=<%=email %> readonly="readonly"><br>
	글제목 <input type="text" name="title" value=<%=title %>><br>
	글내용 <input type="text" name="content" value=<%=content %>><br>
	<input type="submit" value="저장">
	<input type="reset" value="취소" onclick="history.go(-1)">
</form>
</body>
</html>
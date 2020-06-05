<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="dao" class="task.dao.BoardDao"/>
<%
	int num=Integer.parseInt(request.getParameter("num"));
	int n=dao.delete(num);
	if(n>0){
		response.sendRedirect("list.jsp");
	}else{
	%>
		<script type="text/javascript">
			alert("글삭제 실패!");
			history.go(-1);
		</script>
	<%
	}
%>
</body>
</html>
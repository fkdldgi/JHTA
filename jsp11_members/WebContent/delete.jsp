<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% int num=Integer.parseInt(request.getParameter("num")); %>
<jsp:useBean id="dao" class="test.dao.MembersDao"></jsp:useBean>
<%
	int n=dao.delete(num);
	if(n>0){
		response.sendRedirect("list.jsp");
		//pageContext.forward("list.jsp"); //링크가 바뀌지 않아서 삭제 후 새로고침하면 또 삭제되서 오류발생
	}else{
	%>
		<script type="text/javascript">
			alert("삭제 실패!!!");
			history.go(-1);
		</script>
	<%
	}
%>
</body>
</html>
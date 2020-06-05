<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/common.css"> 
</head>
<body>
<%
	String file=request.getParameter("file");
	if(file==null){
		file="main.jsp";
	}
%>
<div id="wrap">
	<div id="header">
		<jsp:include page="header.jsp"/>
	</div>
	<div id="main">
		<jsp:include page="<%=file %>"/>
	</div>
	<div id="footer">
		<jsp:include page="footer.jsp"/>
	</div>
</div>
</body>
</html>
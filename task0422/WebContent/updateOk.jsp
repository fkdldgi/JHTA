<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="vo" class="task.vo.BoardVo"/>
<jsp:setProperty property="*" name="vo"/>
<jsp:useBean id="dao" class="task.dao.BoardDao"/>
<%
	int n=dao.update(vo);
	if(n>0){
		response.sendRedirect("list.jsp");
	}else{
	%>
		<script type="text/javascript">
			alert("글 수정 실패!");
			history.go(-1);
		</script>
	<%
	}
%>
</body>
</html>
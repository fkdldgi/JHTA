<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	session.invalidate(); //세션방 초기화
%>
<script type="text/javascript">
	alert("로그아웃 되었습니다!");
	location.href="layout.jsp?file=main.jsp";
</script>

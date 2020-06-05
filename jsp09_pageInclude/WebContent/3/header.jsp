<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- header.jsp --%>
<%
	String id=(String)session.getAttribute("id");
%>
<ul>
	<li><a href="layout.jsp?file=main.jsp">홈으로</a></li>
	<%
		if(id==null){
	%>
		<li><a href="layout.jsp?file=login.jsp">로그인</a></li>
	<%
		}else{
	%>
		<li><a href="logout.jsp">로그아웃</a></li>
	<%
		}
	%>
	<li><a href="layout.jsp?file=educenter.jsp">교육센터</a></li>
	<li><a href="layout.jsp?file=course.jsp">과정소개</a></li>
	<li><a href="layout.jsp?file=qna.jsp">문의게시판</a></li>
</ul>
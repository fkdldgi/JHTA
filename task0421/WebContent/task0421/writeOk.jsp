<%@page import="java.sql.SQLException"%>
<%@page import="test.db.JDBCUtil"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("utf-8");
	String writer=request.getParameter("writer");
	String email=request.getParameter("email");
	String title=request.getParameter("title");
	String content=request.getParameter("content");
	Connection con=null;
	PreparedStatement pstmt=null;
	int n=0;
	try{
		con=JDBCUtil.getConn();
		String sql="insert into board values(board_seq.nextval,?,?,?,?,sysdate)";
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1,writer);
		pstmt.setString(2,email);
		pstmt.setString(3,title);
		pstmt.setString(4,content);
		n=pstmt.executeUpdate();
	}catch(SQLException se){
		se.printStackTrace();
	}finally{
		JDBCUtil.close(null,pstmt,con);
	}
	if(n>0){
		response.sendRedirect("layout.jsp?file=list.jsp");
	}else{
	%>
		<script type="text/javascript">
			alert("글쓰기 실패!");
			history.go(-1);
		</script>
	<%
	}
%>

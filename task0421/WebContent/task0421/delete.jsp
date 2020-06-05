<%@page import="test.db.JDBCUtil"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.SQLException"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%
	String id=(String)session.getAttribute("id");
	request.setCharacterEncoding("utf-8");
	int num=Integer.parseInt(request.getParameter("num"));
	
	Connection con=null;
	PreparedStatement pstmt=null;
	int n=0;
	try{
		con=JDBCUtil.getConn();
		String sql="delete from board where num=? and writer=?";
		pstmt=con.prepareStatement(sql);
		pstmt.setInt(1,num);
		pstmt.setString(2,id);
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
			alert("다른사람의 게시글을 삭제할 수 없습니다!");
			history.go(-1);
		</script>
	<%
	}
%>

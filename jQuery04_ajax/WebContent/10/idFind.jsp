<%@page import="java.io.PrintWriter"%>
<%@page import="java.sql.SQLException"%>
<%@page import="test.db.ConnectionPool"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String email=request.getParameter("email");
	String pwd=request.getParameter("pwd");
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	String id="";
	boolean using=false;
	try{
		con=ConnectionPool.getConn();
		String sql="select RPAD( SUBSTR(id,1,3),LENGTH(id),'*') id from myusers where pwd=? and email=?";
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1, pwd);
		pstmt.setString(2, email);
		rs=pstmt.executeQuery();
		if(rs.next()){
			id=rs.getString("id");
			using=true;
		}
	}catch(SQLException se){
		System.out.println(se.getMessage());
	}finally{
		try{
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(con!=null) con.close();
		}catch(SQLException se){
			se.printStackTrace();
		}
	}
	response.setContentType("text/xml;charset=utf-8");
	PrintWriter pw=response.getWriter();
	pw.print("<?xml version=\"1.0\" encoding=\"UTF-8\"?>"); //큰따음표안에 큰따음표를 사용하고싶으면 \"로 사용
	pw.print("<result>");
	pw.print("<using>"+using+"</using>");
	pw.print("<id>"+id+"</id>");
	pw.print("</result>");
%>
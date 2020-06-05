<%@page import="java.io.PrintWriter"%>
<%@page import="org.json.JSONObject"%>
<%@page import="java.sql.Date"%>
<%@page import="java.sql.SQLException"%>
<%@page import="test.db.ConnectionPool"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	int num=Integer.parseInt(request.getParameter("num"));
	
	try{
		con=ConnectionPool.getConn();
		String sql="select * from members where num=?";
		pstmt=con.prepareStatement(sql);
		pstmt.setInt(1, num);
		rs=pstmt.executeQuery();
		JSONObject json=new JSONObject();
		if(rs.next()){
			String name=rs.getString("name");
			String phone=rs.getString("phone");
			String addr=rs.getString("addr");
			Date regdate=rs.getDate("regdate");
			json.put("name",name);
			json.put("phone",phone);
			json.put("addr",addr);
			json.put("regdate",regdate);
		}
		response.setContentType("text/plain;charset=utf-8");
		PrintWriter pw=response.getWriter();
		pw.println(json);
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
	
%>
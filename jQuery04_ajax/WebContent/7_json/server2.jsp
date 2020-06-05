<%@page import="java.io.PrintWriter"%>
<%@page import="org.json.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//server2.jsp
	String id="admin";
	String pwd="1234";
	int age=30;
	JSONObject json=new JSONObject();
	json.put("id",id);
	json.put("pwd",pwd);
	json.put("age",age);
	response.setContentType("text/plain;charset=utf-8");
	PrintWriter pw=response.getWriter();
	pw.println(json);
%>
<%@page import="java.io.PrintWriter"%>
<%@page import="org.json.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//라이브러리 이용
	String id="test";
	String pwd="1234";
	String email="test@daum.net";
	JSONObject json=new JSONObject();
	json.put("id",id);
	json.put("pwd",pwd);
	json.put("email",email);
	//json으로 응답하기
	response.setContentType("text/plain;charset=utf-8"); //'text/plain':단순문자열
	PrintWriter pw=response.getWriter();
	pw.print(json); //json문자열로 응답

%>
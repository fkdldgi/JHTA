<%@page import="java.io.PrintWriter"%>
<%@page import="org.json.JSONArray"%>
<%@page import="org.json.JSONObject"%>
<%@page import="test.vo.CommentsVo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ArrayList<CommentsVo> list=new ArrayList<CommentsVo>();
	list.add(new CommentsVo(1,1,"길동1","좋아요!"));
	list.add(new CommentsVo(2,1,"길동2","재밌어요!"));
	list.add(new CommentsVo(3,1,"길동3","GOOD!"));
	list.add(new CommentsVo(4,1,"길동4","추천해요!!"));
	
	JSONArray jarr=new JSONArray();//json객체를 배열로 담기위한 객체
	for(CommentsVo vo:list){
		JSONObject json=new JSONObject();
		json.put("num",vo.getNum());
		json.put("mnum",vo.getMnum());
		json.put("id",vo.getId());
		json.put("comments",vo.getComments());
		jarr.put(json);
	}
	response.setContentType("text/plain;charset=utf-8");
	PrintWriter pw=response.getWriter();
	pw.print(jarr);
%>
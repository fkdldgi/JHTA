<%@page import="java.io.PrintWriter"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.net.HttpURLConnection"%>
<%@page import="java.net.URL"%>
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String search1=request.getParameter("search");
	String start=request.getParameter("start");
	if(search1==null) search1="jquery";
	if(start==null) start="1";
	
	StringBuffer sb=new StringBuffer();
	search1=URLEncoder.encode(search1,"UTF-8");
	String surl="https://openapi.naver.com/v1/search/book.xml?query=" + search1 + //query는 필수요소
			 "&display=5&start=" + start;	//display는 한번 받아올때의 갯수, start는 시작값
	URL url=new URL(surl);
	HttpURLConnection conn=(HttpURLConnection)url.openConnection(); //자바에서 네이버에 요청
	conn.setRequestProperty("X-Naver-Client-Id","m7Mtx6WOovpqN0TANr5d");
    conn.setRequestProperty("X-Naver-Client-Secret", "VjT7dWeewk");
    if(conn!=null){
    	conn.setConnectTimeout(10000);//접속대기시간 10초 설정
    	conn.setUseCaches(false);//캐쉬사용안하기
    	if(conn.getResponseCode()==HttpURLConnection.HTTP_OK){//서버로부터 응답이 성공적으로 왔으면
    		BufferedReader br=
    		 new BufferedReader(new InputStreamReader(conn.getInputStream(),"utf-8"));
    		String line="";
    		while((line=br.readLine())!=null){
    			sb.append(line);
    		}
    		br.close();
    		conn.disconnect();//네이버와 접속해제
    	}
    }
	response.setContentType("text/xml;charset=utf-8");
	PrintWriter pw=response.getWriter();
	pw.print(sb.toString());
	pw.close();
%>

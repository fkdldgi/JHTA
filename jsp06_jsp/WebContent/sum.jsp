<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%! //선언부
int sum(int num1,int num2){
	return num1+num2;
}
%>
<%	
	int num1=Integer.parseInt(request.getParameter("num1"));
	int num2=Integer.parseInt(request.getParameter("num2"));
	int num3=sum(num1,num2);
%>
<%=num1 %>+<%=num2 %>=<%=num3 %>
</body>
</html>
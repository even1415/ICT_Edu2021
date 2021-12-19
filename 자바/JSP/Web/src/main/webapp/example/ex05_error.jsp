<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage="myerror.jsp" %>    
    
<!--  ex05_error.jsp -->
<h1>JSP페이지에서 발생된 에러를 처리하는 방법</h1>
<h2>page지시어에 에러를 처리할 페이지를 지정한다. errorPage속성을 이용</h2>
<%
	String str="100a";

%>
<h2><%=str%></h2>
 
<%
	int num = Integer.parseInt(str);
	out.println(num*2);
%>
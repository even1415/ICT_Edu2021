<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*, java.text.*" %>
<!-- 1. html주석 -->
<%
   //2. java 주석
   /*3. 자바
   주석*/
   Random ran=new Random();
   int num = ran.nextInt(100)+50;
%>
<h1 style='color:tomato'><%=num%></h1>
<%-- 4. jsp주석 <%=%> : 출력식(expression)   --%>

<%
   Date d = new Date();
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	String str=sdf.format(d);
	//내장객체: out ==> JspWriter타입
	out.println("<h3>"+str+"</h3>");	//[1] 출력방법: out을 이용	
%>
<%=d.toString()%>
<%-- [2] 출력식(<%=%>)을 이용해 출력 --%>
<hr color='blue'>
<%--
for루프 이용해서 이미지 b.png를 5번 출력하세요
 --%>
<% 
	//webapp/example/ex02.jsp
	//webapp/images/b.png
	for(int i=0;i<5;i++){
		out.println("<img src='../images/b.png'>");
	}
%> 
<hr color='red'>
 <%
 	for(int i=0;i<5;i++){
 %>
 	<img src='../images/c.png'>		
<% 		
 	}
 %>
 
 
 
 
 




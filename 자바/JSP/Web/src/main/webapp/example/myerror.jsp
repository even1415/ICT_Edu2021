<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  isErrorPage="true"  %>
    
<!-- myerror.jsp 

에러 처리 페이지에서는 반드시 page지시어에 isErrorPage라는 속성값으로 true를 줘야 한다.
true를 주면 exception내장객체를 사용할 수 있다.
-->
<style>
	div#err{
		width:70%;
		margin:50px auto;
		padding:2rem;
		color:red;
		background-color:beige;
		text-align:center;
	}
</style>
<div id="err">
	<h1>Server Error: <%=exception.getMessage() %></h1>
	<% 
		exception.printStackTrace();
	
	%>
	<p>
	
		<a href="javascript:history.back()">이전 페이지로 돌아가기</a>
		<!--  href에 자바스크립트 코드를 적용하려면 "javascript:"을 붙여줘야 한다. -->
		
		<a href="#" onclick="history.go(-1)">이전 페이지 돌아가기</a>
		
		<button onclick="history.back()">이전페이지 돌아가기</button>
	</p>
</div>





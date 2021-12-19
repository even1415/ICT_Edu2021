<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>구구단 7단을 jsp를 이용해 출력해봅시다.(table형태로 출력하기)</h1>
<style>
	td{
		text-align:center;
	}
	th{
		background-color:#abc;
	}
	
</style>

<table border=1 style='width:200px'> 
<%
for(int i = 1;i<=9;i++){
	%>
	<tr>
		<td>7x<%=i%>=<%=7*i%></td>
	</tr>
<% 
}
%>
</table>
<hr>
<h1>구구단 전체 테이블</h1>
<table border='1' style="width:90%;margin:20px auto">
	<tr>
	<% for(int k=2;k<10;k++){ %>
		<th> <%=k%> 단</th>
	<%} %>
	</tr>
	<%for(int i=1;i<10;i++){ %>
		<tr>
		<%for(int j=2;j<10;j++){ %>
			<td><%=j%>X<%=i%>=<%=i*j%></td>
		<%} %>
		</tr>
	<%} %>
</table>









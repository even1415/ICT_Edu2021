<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
/*
	//String getParameter("파라미터이름");
	String id = request.getParameter("uid");
	//request : 내장객체 HttpServletRequest 탕입
	//response : 내장객체 HttpServletResponse 타입
	out.println("<h1>"+id+"</h1>");
*/

String uid = request.getParameter("uid");
String java = (request.getParameter("java")=="")? "0" : request.getParameter("java");
String db = (request.getParameter("db")=="")? "0" : request.getParameter("db");
String jsp = (request.getParameter("jsp")=="")? "0" : request.getParameter("jsp");

int avg = (Integer.parseInt(java)+Integer.parseInt(db)+Integer.parseInt(jsp)) / 3;
%>

<html>
</head>
<style>
	td {
		text-align:center;
		width: 50px;
	}
</style>

<body>
<h1>처리 결과</h1>
<form name="f" action="input.jsp" method="post">
<table border=1 width="300px">
<tr>
	<td colspan=3>사번</td>
	<td colspan=3>
		<%out.println(uid); %>
	</td>
</tr>
<tr>
	<td rowspan=3>과목</td>
	<td colspan=2>Java</td>
	<td colspan=3><%out.println(java); %></td>
</tr>
<tr>
	<td colspan=2>Database</td>
	<td colspan=3><%out.println(db); %></td>
</tr>
<tr>
	<td colspan=2>JSP</td>
	<td colspan=3><%out.println(jsp); %></td>
</tr>
<tr>
	<td colspan=3>평균</td>
	<td colspan=3><%out.println(avg); %></td>
</tr>
<tr>
	<td colspan=6>
		<button>입력화면</button>
	</td>
</tr>

</table>

</form>
</body>
</html>
<%@ page contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!-- page directive (page지시어) -->
<!DOCTYPE html>
<html>
	<head>
		<title>ex01.jsp</title>
	</head>
	<body>
	<!-- 1. html주석  -->
		<div id="wrap">
			<h1>Hello JSP</h1>
			<% 
				//2. 자바 단문 주석
				//scriptlet태그 안에서는 자바코드를 자유롭게 사용할 수 있다.
				
				/*
				3. 자바 복문 주석
				*/
				for(int i=1;i<=10;i++){
					//System.out.println("Hello World~"+i);
			%>
					<h2>Hello World~ <%=i%></h2>
			<%	
				}				
			%>
			
			<%--4. JSP주석 --%>
						
		</div>
	</body>
</html>



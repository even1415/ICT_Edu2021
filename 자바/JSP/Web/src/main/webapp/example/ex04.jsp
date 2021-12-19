<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>ex04.jsp</h1>
<%
	//scriptlet태그 안에서 변수를 선언하면 => 지역변수가 된다
	String str="Hello(지역변수)";
	
	//scriptlet태그에 기술된 코드들은 ===> __jspService() 메소드 안에 들어간다. 
%>
<h1><%=str%></h1>

<%! 
	//선언문(declaration): 멤버변수를 선언하거나 사용자 정의 메소드를 구성할 수 있다.
	String global="Global(멤버변수)";

	public String sum(int a, int b){
		return a+"+"+b+"="+(a+b);
	}
	
%>
<h2><%=global%></h2>
<hr color='red'>

<!--  sum()호출해보기 -->
<h2><%=sum(20,33) %></h2>
<%--이클립스 서블릿 생성되는 곳
C:\Users\ict01-00\WebWorkspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\work
 --%>


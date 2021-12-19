<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import="java.util.*"  %>
<%
//이름, 아이디, 이메일, 직업 입력값 받아서 아래에 출력하세요
String name=request.getParameter("name");
String id=request.getParameter("id");
String email=request.getParameter("email");
String job=request.getParameter("job");
/*
[1] 단일값을 받아올 때: String getParameter("파라미터명")
[2] 다중값을 받아올 때: String[] getParameterValues("파라미터명")
		=> 사용자가 입력한 값들을 배열에 담아서 반환한다
		
취미, 언어 값들 받아서 아래에 출력하세요		
*/

String[] hobby = request.getParameterValues("hobby");
String[] lang = request.getParameterValues("lang");
//이름만 null일경우 redirect로 ex12_request.jsp로 이동시키세요
if(name==null){
	response.sendRedirect("ex12_request.jsp");
	return;
}
%>
<h1>이름:<%=name %> </h1>
<h1>아이디:<%=id %> </h1>
<h1>이메일:<%=email %> </h1>
<h1>직업:<%=job %> </h1>
<h1>취미: 
<%
if(hobby!=null){
	for(String h:hobby){
		out.println(h+",");
	}
}
%>
</h1>
<h1>사용언어:
<%
	if(lang!=null){
		for(int i=0;i<lang.length;i++){
			out.println(lang[i]+",");
		}
	}
%>
 </h1>
<hr color='red'>
<h1>request객체의 주요 메소드</h1>
<%
	String server=request.getServerName();//서버의 도메인명(IP주소)
	int port = request.getServerPort();//포트번호
	StringBuffer buf =request.getRequestURL(); //URL을 반환
	//http://192.168.0.7:9090/Web/example/ex12_requestResult.jsp
	String uri = request.getRequestURI();//URI반환
	//컨텍스트명(/Web)이후의 경로를 반환
	///Web/example/ex12_requestResult.jsp
	String query = request.getQueryString();
	//name=aaa&id=swanbaek&email=aaa%40naver.com&hobby=music&job=Developer&lang=C
			
	String cip = request.getRemoteAddr();//클라이언트 ip주소	
	String proto=request.getProtocol();
	String serverPath=request.getServletPath();
	String ctx = request.getContextPath();
%>
<h2>서버 도메인명: <%=server %></h2>
<h2>서버 포트번호: <%=port %></h2>
<h2>요청 URL: <%=buf.toString() %></h2>
<h2>요청 URI: <%=uri %></h2>
<h2>Query String: <%=query %></h2>

<h2>클라이언트 IP: <%=cip %></h2>
<h2>프로토콜: <%=proto %></h2>
<h2>서블릿 경로: <%=serverPath %></h2>
<h2>컨텍스트명: <%=ctx %></h2>

<hr color='blue'>
<h1>request의 Header정보를 추출해보자.</h1>
<% 
	Enumeration<String> en = request.getHeaderNames();
	//헤더의 key값들을 Enumeration타입으로 반환한다.
	
	while(en.hasMoreElements()){
		String headerName=en.nextElement();//key값
		String headerValue=request.getHeader(headerName);//value값
		out.println("<h3>"+headerName+": "+headerValue+"</h3>");
	}

%>















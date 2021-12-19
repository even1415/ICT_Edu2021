<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 
<%
   //String getParameter("파라미터이름");
   String id = request.getParameter("uid");
   String java = request.getParameter("Java");
   String db = request.getParameter("Database");
   String jsp = request.getParameter("JSP");
  if(id==null||java==null||db==null||jsp==null){
	   response.sendRedirect("input.jsp");
	   return;
   }
  
  String j1=(java.trim().equals(""))?"0":java.trim();
  String j2=(db.trim().equals(""))?"0":db.trim();
  String j3=(jsp.trim().equals(""))?"0":jsp.trim();
  
   
   //request:내장객체 HttpServletRequest타입
   //reponse:내장객체 HttpServletResponse타입
   int result = (Integer.parseInt(j1)+Integer.parseInt(j2)+Integer.parseInt(j3))/3;
   
   /*
   out.println("<h1>처리 결과</h1>");
   out.println("<h2>사번: "+id+"</h2>");
   out.println("<h2>Java: "+java+"</h2>");
   out.println("<h2>Database: "+db+"</h2>");
   out.println("<h2>JSP: "+jsp+"</h2>");
   out.println("<h2>평균: "+result+"</h2>");
   */
%>

<style>
   td{
      width:70px;
      text-align:center;
   }
   
   td#rs{
      width:150px;
   }
</style>

</head>

<body>
   <h1>출력 창</h1>
   <form name="f" action="input.jsp" method="post">
      <table border="1">
         <tr>
            <td colspan="2">사번</td>
            <td id="rs"><%=id%></td>
         </tr>
         
         <tr>
            <td rowspan="3">과목</td>
            <td>Java</td>
            <td><%=j1%></td>
         </tr>
         <tr>   
            <td>Database</td>
            <td><%=j2%></td>
         </tr>
         <tr>
            <td>JSP</td>   
            <td><%=j3%></td>
         </tr>
         
         <tr>
            <td colspan="2">평균</td>
            <td><%=result%></td>
         </tr>
         
         <tr>
            <td colspan="3"><button id="bt" onclick="history.back()">확인</button></td>
         </tr>
         
      </table>
   </form>

</body>
</html>




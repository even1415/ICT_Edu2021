<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
<% 
	//컨텍스트명 얻어오기
	String myctx = request.getContextPath();
// "/Web"
%>    
    <link rel="stylesheet" href="<%=myctx%>/css/layout_flex.css" type="text/css">

</head>
<body>
    <div id="wrap">
        <header class="header">
            <a class="logo" href="#home"><img src="<%=myctx%>/images/logo3.png"></a>
            <nav>
              <!-- nav영역 -->
            <ul class="nav-items">
              <li><a href="<%=myctx%>/index.jsp">Home</a></li>
              <li><a href="<%=myctx%>/member/join.jsp">Signup</a></li>
              <li><a href="<%=myctx%>/member/list.jsp">Users</a></li>
              <li><a href="<%=myctx%>/login/login.jsp">Login</a></li>
            </ul>
          </nav>
        </header>
    
        <div id="content-wrap">
          <aside>
            <h1>Aside</h1>
            <ul>
              <li><a href="#" class="active">London</a></li>
              <li><a href="#">Paris</a></li>
              <li><a href="#">Tokyo</a></li>
              <li><a href="#">Newyork</a></li>
            </ul>
          </aside>
          <section class="section">
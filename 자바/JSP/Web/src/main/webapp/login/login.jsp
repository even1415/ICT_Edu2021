<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/top.jsp" />

<div id="content">
   
   <form name="loginF" action="loginEnd.jsp" method="post">
      <table class="table" style="width:60%;margin:auto">
         <tr>
            <th colspan="2"><h1>Login</h1></th>
         </tr>
         <tr>
            <td style="text-align:right"><b>아이디</b></td>
            <td>
               <input type="text" name="userid" 
               autofocus="autofocus" placeholder="User ID" class="box">
            </td>
         </tr>
         <tr>
            <td style="text-align:right"><b>비밀번호</b></td>
            <td>
               <input type="password" name="pwd" 
                placeholder="Password" class="box">
            </td>
         </tr>
         <tr>
            <td colspan="2" style="text-align:right">
            <label for="saveId">
               <input type="checkbox" name="saveId" id="saveId">아이디 저장
            </label>
            <button type="button" class="btn" onclick="loginCheck()">로그인</button>
            </td>
         </tr>
      </table>
   </form>
</div>
<script>
   var loginCheck = function(){
      if(!loginF.userid.value){
         alert('아이디를 입력하세요');
         loginF.userid.focus();
         return;
      }
      if(!loginF.pwd.value){
         alert('비밀번호를 입력하세요');
         loginF.pwd.focus();
         return;
      }
      loginF.submit();
   }
</script>


<jsp:include page="/foot.jsp" />
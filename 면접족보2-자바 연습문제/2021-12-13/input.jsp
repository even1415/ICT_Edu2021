<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
	td {
		text-align:center;
	}
</style>

<body>
<h1>성적 입력</h1>
<form name="f" action="result.jsp" method="post">
<table border=1 width="300px">
<tr>
	<td colspan=3>사번</td>
	<td colspan=3>
		<input type="text" name="uid">
	</td>
</tr>
<tr>
	<td rowspan=3>과목</td>
	<td colspan=2>Java</td>
	<td colspan=3><input type="text" name="java"></td>
</tr>
<tr>
	<td colspan=2>Database</td>
	<td colspan=3><input type="text" name="db"></td>
</tr>
<tr>
	<td colspan=2>JSP</td>
	<td colspan=3><input type="text" name="jsp"></td>
</tr>
<tr>
	<td colspan=6>
		<button type="submit" value="submit" onclick="return check();">저장</button>
	</td>
</tr>

</table>

</form>
<script>
function check(){
	if (document.f.uid.value == ""){
		alert("사번을 입력해 주세요.");
		document.f.uid.focus();
		return false;
	}
	return true;
}
</script>
</body>
</html>
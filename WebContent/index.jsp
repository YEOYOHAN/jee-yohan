<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>한스은행</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
<div>
	<h1>환영합니다</h1>
	<table border='1'>
		<tr>
			<td>로그인</td>
			<td><input id="btn" type="button" value="LOGIN"/></td>
		</tr>
		<tr>
			<td>회원가입</td>
			<td><a id="link" href="#">바로가기</a></td>
		</tr>
	</table>
	
</div>
<script>
$('#btn').click(function() {
	alert('버튼클릭');
	location.assign('<%=request.getContextPath() %>/member.do?action=move&dest=login');
});
$('#link').click(function() {
	alert('이동하자');
	location.assign('<%=request.getContextPath() %>/member.do?action=move&dest=join');
});
</script>
</body>
</html>
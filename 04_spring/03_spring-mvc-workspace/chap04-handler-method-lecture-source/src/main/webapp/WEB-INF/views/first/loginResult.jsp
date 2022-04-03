<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1 align="center">Session에 담긴 값 확인하기</h1>
	<h3 align="right">${sessionScope.id }님 환영합니다.</h3>
	<h3 align="right">비밀번호 확인용 : ${sessionScope.pwd}</h3>
	<div align="right">
		<button onclick="location.href='logout1'">로그아웃1</button><br>
		<button onclick="location.href='logout2'">로그아웃2</button>
	</div>

</body>
</html>
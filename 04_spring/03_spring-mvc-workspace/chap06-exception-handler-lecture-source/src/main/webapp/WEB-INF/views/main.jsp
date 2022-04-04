<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1 align="center">Exception Handler 사용하기</h1>

	<h3>SimpleMappingExceptionResolver를 이용한 방식</h3>
	<button onclick="location.href='simple-null'">NullPointerException 테스트</button><br>
	<button onclick="location.href='simple-user'">사용자정의 Exception 테스트</button>
	
	<h3>@Exception handler를 이용한 방식</h3>
	<button onclick="location.href='annotation-null'">NullPointer Exception 테스트</button><br>
	<button onclick="location.href='annotation-user'">사용자정의 Exception 테스트</button>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">include directive</h1>
<!-- 
	 include 지시자 태그를 이용하여 file속성에 jsp경로를 지정해주면 해당 jsp에 작성한 내용을 그대로 포함시켜 현재 jsp파일을 동작시킨다.
	     동일한 변수 이름을 include 이후에 또 사용하게 되면 한 페이지 내에 동일한 변수가 생성되는 것이므로 컴파일 에러가 발생하게된다.
 -->
<div align="right"> <%@ include file="today.jsp" %></div>


</body>
</html>
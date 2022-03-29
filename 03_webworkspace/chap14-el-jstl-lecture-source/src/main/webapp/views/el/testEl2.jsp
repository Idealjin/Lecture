<%@page import="com.ohgiraffers.el.model.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2> 전달된request 객체에 저장된 member 객체 필드값 출력하기</h2>
	<% MemberDTO member = (MemberDTO)request.getAttribute("member"); %>
	
	이름 : <%= member.getName() %> <br>
	나이 : <%= member.getAge() %> <br>
	전화번호 : <%= member.getPhone() %> <br>
	이메일 : <%= member.getEmail() %> <br>

	<hr>
	<%-- ${저장이름.필드명} --%>
	이름 : ${ member.name } <br>
	나이 : ${ requestScope.member.age } <br>
	전화번호 : ${ member.phone } <br>
	이메일 : ${ member.email } <br>

</body>
</html>
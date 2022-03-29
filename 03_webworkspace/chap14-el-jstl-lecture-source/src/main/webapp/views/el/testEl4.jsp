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

	<h2>requestScope와 sessionScopte테스트</h2>
	<h3> requestScope값 출력하기 </h3>
	<% MemberDTO member1 = (MemberDTO) request.getAttribute("member");	%>
	<%= member1.getName() %> <br>
	이름 : ${ requestScope.member.name } <br>
	나이 : ${ requestScope.member.age } <br>
	전화번호 : ${ requestScope.member.phone } <br>
	이메일 : ${ requestScope.member.email } <br>
	
	<hr>
	
	<h3> sessionScope값 출력하기 </h3>
	
	<% HttpSession session1 = request.getSession();
		MemberDTO memberDTO = (MemberDTO) session1.getAttribute("member");
	%>
	<%= memberDTO.getName() %> 
	이름 : ${ sessionScope.member.name } <br>
	나이 : ${ sessionScope.member.age } <br>
	전화번호 : ${ sessionScope.member.phone } <br>
	이메일 : ${ sessionScope.member.email } <br>
	
	<hr>
	
	<h3> 우선순위 테스트 </h3>
	이름 : ${ member.name } <br>
	나이 : ${ member.age } <br>
	전화번호 : ${ member.phone } <br>
	이메일 : ${ member.email } <br>
</body>
</html>
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
	<% 
	String name = request.getParameter("name");
	int price = Integer.parseInt(request.getParameter("price"));
	String[] no = request.getParameterValues("no");
	String option = request.getParameter("option");
	%>

	
	상품명 : <%=name %> <br>
	가격 : <%=price %> <br>
	제품번호 : <%=no[0] %> 와 <%=no[1] %> <br>
	옵션 : <%=option %> <br>
	
	<hr>
	
	상품명 : ${ param.name } <br>
	가격 : ${ param.price } <br>
	제품번호 : ${ paramValues.no["0"]}  와 ${ paramValues.no["1"]}  <br>
	옵션 :${ (empty param.option)? "옵션없음" : param.option } <br>
	

</body>
</html>
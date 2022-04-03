<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">Spring MVC Mapping TEST</h1>
	
	<h2> 1. 메소드에 요청 매핑하기</h2>
	<!--요청방식을 지정하지 않은 핸들러 메소드에 get방과 post방식의 요청을 둘 다 보내볼 예정 -->
	<h3> GET : /menu/regist </h3>
	<button onclick="location.href='${pageContext.servletContext.contextPath}/menu/regist/'">
	GET메뉴
	</button>
	
	<h3> POST : /menu/regist </h3>
	<form action="${pageContext.servletContext.contextPath}/menu/regist/" method="post">
		<button type="submit">POST 메뉴 등록 요청</button>
	
	</form>
	
	<h3>GET : /menu/modify </h3>
	<button onclick="location.href='${pageContext.servletContext.contextPath}/menu/modify'">
		GET 메뉴 수정 요청
	</button>

	<!-- post방식 메소드는 HTTP상태 405 발생하게 된다. -->
	<h3>POST : /menu/modify</h3>
	<form action="${pageContext.servletContext.contextPath}/menu/modify" method="post">
		<button type="submit">POST 메뉴 수정 요청</button>
	</form>
	
	<!-- @GetMapping or @PostMApping을 이용해 매핑 -->
	<h3>Get : /menu/delete</h3>
	<button onclick="location.href='${pageContext.servletContext.contextPath}/menu/delete'">
		GET 메뉴 삭제 요청
	</button>
	
	<h3>POST : /menu/delete</h3>
	<form action="${pageContext.servletContext.contextPath}/menu/delete" method="post">
		<button type="submit">POST 메뉴 삭제 요청</button>
	</form>
	
	<h2> 2. 클래스에 요청 매핑하기</h2>
	<!--REquestMapping은 컨트롤러 클래스 레벨에도 사용이 가능하다. -->
	<h3>GET : /order/regist</h3>
	<button onclick="location.href='${pageContext.servletContext.contextPath}/order/regist'">
		GET 주문 등록 요청
	</button>

	<h3>POST : /order/modify </h3>
	<form action="${pageContext.servletContext.contextPath}/order/modify" method="post">
		<button type="submit">POST 주문 수정 요청</button>
	</form>
	
	<form action="${pageContext.servletContext.contextPath}/order/delete" method="post">
		<button type="submit">POST 주문 삭제 요청</button>
	</form>
	
	<!-- pathVarialbe 테스트 -->
	<h3> GET : /detail/{orderNo} </h3>
	
	<button onclick="location.href='${pageContext.servletContext.contextPath}/order/detail/3'">
		GET 주문 상세보기 요청
	</button>
	
</body>
</html>
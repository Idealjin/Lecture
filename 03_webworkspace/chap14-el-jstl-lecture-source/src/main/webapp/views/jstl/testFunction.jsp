<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1 align="center">JSTL Function Library Tag Test</h1>
<h3> 문자열 처리에 관련된 함수들이다.</h3>
<h3> el 안에서 값 처리용으로 사용되거나 value 속성에 대입 시에 사용된다.</h3>

<c:set var="str" value="How are you?"/>

str = ${str} <br>

you가 포함되어 있나 : ${fn:contains(str,'you')} <br>
how가 포함되어 있나 : ${fn:contains(str,'how')} <br>
대소문자 구분 없이 how가 포함되었는지 확인 :  ${fn:containsIgnoreCase(str,'how')}<br>
모두 대문자로 : ${ fn:toUpperCase(str) } <br>
모두 소문자로 : ${ fn:toLowerCase(str) } <br>
are의 위치는 : ${ fn:indexOf(str, "are")} <br>
How를 Where로 바꿔보자 : ${fn:replace(str, "How","Where")}<br>
</body>
</html>
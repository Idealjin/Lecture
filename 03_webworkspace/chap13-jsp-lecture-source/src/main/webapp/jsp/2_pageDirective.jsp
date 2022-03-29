<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="errorPage.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 
지시자태그에서 사용 가능한 속성들은 여러 가지들이 있지만 알고있어야 하는 속성은 많지않다.
errorPage : 현재 페이지에서 익셉션이 발생하게 되면 속값에 설정한 jsp경로로 익셉션을 고친다.
isErrorPage : 현재 페이지를 익셉션을 처리할 페이지인경우트루로 지정 기본값 폴스
import : 자바 랭 패키지 이외의 클래스를 현 jsp파일에서 사용할 때 임포트 속성에 정의하게 되면 임포트 선언부를 작성하는것 같다.,

또한 지시자 태그는 page,include, tablib가 있다.\
page :현 jsp페이지에 대한 설정을 하는 지시자 태그
include : 다른 JSP 파일을 포함하기 위해 사용하는 지시자 태그
taglib : xml문법 기반의 라이브러리인 JSTL을 이용하기 위해 선언하는 지시자 태그 
 -->
 <%
 	Date date = new Date();
 	System.out.println(date);
 %>
 <%
	String str = null;
 	char ch = str.charAt(0);
 %>


</body>
</html>
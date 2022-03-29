<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">JSTL Core Library Tag Test</h1>
	
	<h2> C:set 태그 : 변수 선언 </h2>
	<c:set var="num1" value="100" scope="session"/>
	<!-- scope 생략시 기본은 pagescope다. -->
	<c:set var="num2" value="200" scope="session"/>
	<c:set var="sum" value="${num1 + num2 }"/>
	num1 + num2 = ${ sum }<br>
	
	<hr>
	
	<h2>C:set 태그 : 배열 또는 컬렉션으로 사용할 문자열 선언 </h2>
	<c:set var="colors">
		red, yellow, green, orange, blue, magenta
	</c:set>
	Color 배열 값 확인 : ${ colors } <br>
	
	<script>
		window.onload = function(){
			let colors = '${colors}'.split(', ');
			console.log(colors);
		}
	</script>
	
	<hr>
	
	<h2>c:remove 태그 : 변수 삭제</h2>
	num1 변수 값 : ${ num1 } <br>
	num2 변수 값 : ${ num2 } <br>
	<!--  삭제시에 스코프 지정안하면 모든 변수 제거 --> -->
	<c:remove var="num1" scope="session"/>
	<c:remove var="num2" scope="session"/>
	num1 변수 값 : ${ num1 } <br>
	num2 변수 값 : ${ num2 } <br>
	
	<h2>이스케이프시퀀스 : <, >, & 등의 특수문자를 &lt;과 &gt; 과 &amp; 로 바꿔서 인식한다.</h2>
	<h2>c:out 태그 : 값 출력용</h2>
	<c:out value="core 라이브러리의 <out> 태그는 값을 화면에 출력하는 태그이다." />
	<!-- escapeXml을 false로 지정하면 < , > 등을 태그로 인식하고, true로 지정하면 문자로 인식한다. -->
	<c:out value="<h2>데이터출력</h2>" escapeXml="false" /> <br>
	<c:out value="<h2>데이터출력</h2>" escapeXml="true"/> <br>
	<!--  기본값은 true이다. -->
	<c:out value="<h2>데이터출력</h2>" />
	
	<h2>c:out 태그의 default 속성</h2>
	<c:out value="${ param.name }" default="아무개님"/><br>
	
	<h2>c:if 태그 : 조건문</h2> 
	<c:set var="value1" value="1" scope="page" />
	<c:set var="value2" value="2" scope="page" />
	value1의 값은 <c:out value="${ value1 }"/>이고, value2의 값은 <c:out value="${ value2 }" />입니다.
	
	<c:if test="${ value1 >= value2 }">
	    <h3>value1 이 큽니다 : ${ value1 }</h3>
	</c:if>
	<c:if test="${ value1 < value2 }">
	    <h3>value2가 큽니다 : ${ value2 }</h3>
	</c:if>
	
	<hr>
	
	<h2>c:choose : switch문, c:when : case문, c:otherwise : defualt문</h2>
	<c:set var="no" value="${ param.no }"/>
	
	param.no의 값은 <c:out value="${ param.no }" /> 입니다.
	
	<c:choose>
	  <c:when test="${ no == 1 }"><h3>안녕하세요</h3></c:when>
	  <c:when test="${ no eq 2 }"><h3>반갑습니다.</h3></c:when>
	  <c:otherwise><h3>환영합니다.</h3></c:otherwise>
	</c:choose>
	
	<hr>
	
	<h2>c:forEach 태그 : for문</h2>
	<c:forEach begin="1" end="10">
	   반복실행<br>
	</c:forEach>
	<br>
	
	<c:forEach var="size" begin="1" end="7" step="1">
	   <font size="${ size }">글자크기 ${ size }</font><br>
	</c:forEach>
	
	<br>
	
	<h2>c:forEach 태그 : 배열 또는 컬렉션 연속처리에 for~each(향상된for문)문 처럼 사용한다.</h2>
	<!-- varStatus를 통해 상태를 관리할 수 있다.
	     index : 제로기반 인덱스
	     count : 1기반 인덱스
	 -->
	<c:forEach var="color" items="${ colors }" varStatus="st">
		<font color="${ color }">
		<%-- 	${ st.index }, <!-- 0 1 2 3 4 5 -->
			${ st.count }<br> --%>
			<%-- ${ st.current }
			${ st.first }
			${ st.last } --%>
			${ st.count } : 글자색 ${ color }
		</font>	<br>
	</c:forEach>
	
	<hr>
	
	<h2>c:forTokens 태그 : 문자열을 토큰으로 분리 처리할 때 사용</h2>
	<c:forTokens var="color" items="yellow blue pink red green" delims=" ">
	   <li>${ color }</li>
	</c:forTokens>
	
	<h2>c:url 태그 : 링크 설정 정보 별도 지정시 사용하는태그</h2>
	<a href="test.jsp?name=홍길동&age=20&gender=남"></a>
	<c:url var="fmtlink" value="testJstlCoreResult.jsp">
		<c:param name="name" value="홍길동"/>
	</c:url>
	<a href="${fmtlink}"> 결과 화면 연결</a> }
	
</body>
</html>
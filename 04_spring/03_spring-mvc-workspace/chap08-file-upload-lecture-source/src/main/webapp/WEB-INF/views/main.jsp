<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1 align="center">파일 업로드 하기</h1>
	
	<h3>single file 업로드하기</h3>
	<!-- 파일 업로드 기능을 사용하기 위해서 꼭 체크하고 선언해야하는 게 있다.
	     1. form 태그의 method는 post방식이어야한다.
	     2. form태그의 encType속성에 multipart/form-data라는 속성을 추가해주어야한다.
	 -->
	<form action="single-file" method="post" encType="multipart/form-data"> 
		파일 : <input type="file" name="singleFile"><br>
		파일 설명 : <input type="text" name="singleFileDescription"><br>
		<input type="submit">
	</form>


</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <script>
 	(function(){
 		const successCode = '${requestScope.successCode}';
 		
 		let successMessage = '';
 		let movePath = '';
 		
 		switch(successCode){
 		case 'insertEmp' :
 			successMessage = '신규 직원 등록 성공!';
 			movePath= '${pageContext.servletContext.contextPath}';
 			break;
 		}
 		alert(successMessage);
 		location.href = movePath;
 	})();
 </script>
</body>
</html>
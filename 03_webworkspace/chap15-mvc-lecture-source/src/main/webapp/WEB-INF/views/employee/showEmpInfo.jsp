<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<jsp:include page="../common/header.jsp"/>
	사원번호 : ${ requestScopte.selectEmp.empId } <br> 
	사원명 : ${ requestScopte.selectEmp.empName } <br> 
	부서코드 : ${ requestScopte.selectEmp.deptCode} <br> 
	직급코드: ${ requestScopte.selectEmp.jobCode } <br> 
	급여 : ${ requestScopte.selectEmp.salary } <br> 
</body>
</html>
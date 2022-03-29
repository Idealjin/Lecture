
<!-- 1. 페이지 지시자 태그 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- JSP는 표면상으로는 HTML문서와 유사하다.
	하지만 JSP 컨테이너가 최초 JSP를 요청할 시 JSP를 서블릿으로 변환시킨 후, 서블릿 컨테이너가 변환된 서블릿을 이용해 인스턴스를 생성하고 호출한다.
	JSP는 매 요청 시 마다 기존 JSP파일이 변환되었는지 확인하여 변경이 없는 경우에는 기존에 생성해둔 인스턴스를 사용하고,
	변경이 있는 경우에는 translate 과정을 거쳐 인스턴스를 다시 생성한다.
	
	jsp는 translate -> compile -> instance 생성 -> run이 되는 순서이다.
	 -->
	<!-- 2. jsp 주석태그 -->
	<%-- html 주석은 클라이언트에 노출되지만, jsp주석은 클라이언트에 노출되지 않는다. --%>
	
	<!-- 3. 선언태그 -->
	<%!
		private String name;
		private int age;
	%>

	<!-- 4. scriptlet 태그 -->	
	<%
		//간단한 자바 코드를 작성할 수 잇는 부분이다.
		//스크립틀릿 태그 내에서의 주석은 자바 주석과 동일하다.
		//선언 태그에서 작성한 내용을 초기하하고 출력할수도 있으며, 간단한 로직 처리도 가능하다.
		name = "홍길동";
		age = 20;
		
		System.out.println("이름은 " + name + "이고, 나이는 " + age + "살 입니다.");
		
		//간단한 로직처리도 작성 가능하다.
		for(int i=0; i < name.length(); i++){
		System.out.print(name.charAt(i));			
		}
	%>
	
	<!-- 5. expression 태그  -->
	<!-- PrintWriter를 이용하여 브라우저에값을 내보내기하여 브라우저에서 보여지게 한다  -->

	name : <%= name %> <br>
	
	
	

</body>
</html>
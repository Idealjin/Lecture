package com.ohgiraffers.section01.response;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/response")
public class ResponseTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
    public ResponseTestServlet() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* 서블릿이 하는 역할은 크게 3가지로 볼 수 있다. 
		 * 1. 요청 받기(HTTP method GET/POST 요청에 따른 parameter로 전달받은 데이터를 꺼내올 수 있다.)
		 * 2. 비지니스 로직 처리(DB접속과 CRUD에 대한 로직 처리 --> 서비스를 호출하는 쪽으로 해결(MVC) 
		 * 3. 응답하기(문자열로 동적인 웹(HTML태그)페이지를 만들어서 스트림을 이용하여 내보내기
		 * */
		
		/* 이번 챕터는 사용자 브라우저에 스트림을 이용하여 페이지를 내보내는 것을 해볼 예정이다.*/
		
		
		
		StringBuilder responseBuilder = new StringBuilder();
		
		//문자열을 이용해 사용자에게 내보내기를 할 페이지를 작성한다.
		responseBuilder.append("<!doctype html>\r\n")
					   .append("<html>\n")
					   .append("<head>\n")
					   .append("</head>\n")
					   .append("<body>\n")
					   .append("<h1>안녕 Hello Servlet response</h1>\n")
					   .append("</body>\n")
					   .append("</html>");
		
		//브라우저로 내보내기를 할 데이터의 타입을 응답
		System.out.println("default response type : " + response.getContentType());
		/*
		 * 기본값은 text/plain이지만 html태그를 사용하면 요청시 text/html도 응답 수락 가능하도록
		 * 헤더 설정이 되어 있기 때문에 자동으로 text/html로 인식하게 된다.
		 * 하지만 명시적으로 text/plain으로 설정하게 되면 html태그로 인식하지 않고 문자열로 인식하게 된다.
		 * */
//	1	response.setContentType("text/html"); //text/html은 html형식으로 , plain은 일반 텍스트로 내보낸다.
		
		
		System.out.println("deault response encoding : " + response.getCharacterEncoding());
//	2	response.setCharacterEncoding("UTF-8");
		System.out.println("deault response encoding : " + response.getCharacterEncoding());
		
		
		 /* 응답할 인코딩 방식이 UTF-8임을 응답 헤더에 알려주게 되면 브라우저가 이를 해석할떄 UTF-8로인식하고 해석하게 된다.
		  * 즉, 한글이 깨지지 않게 된다.
		  * 주의할 점은 반드시 getWrite()로 스트림을 얻어오기 전에 설정해야 한다.
		  * 따라서 위에서 스트림을 생성한 것을 인코팅 변경 후로 위치를 바꿔줘야한다.
		  * */
		// 위의 두개(1,2번)의 설정을 한번에 설정할 수 있따.
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.print(responseBuilder.toString());
		out.flush();
		out.close();
	}

}

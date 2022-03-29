package com.ohgiraffers.section01.querystring;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/queryString")
public class QueryStringTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public QueryStringTestServlet() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//HttpServlet 클래스의 service메소드가 요청 방식에 의해 GET요청은 doGet()메소드를 호출하며 request와 response를 전달해준다.
		/*톰캣 서블릿 컨테이너가 해당 요청 url로 매핑된 Servlet클래스의 인스턴스를 생성하여 service()메소드를 호출하고
		 * httpServlet을 상속받아 오버라이딩한 현재 클래스의 doGet()메소드가 동적 바인딩에 의해 호출이 된다.
		 * 
		 * service로부터 전달받은 HttpServletRequest는 요청 시 전달한 값을 getParemeter()메소드로 추출해 올 수 있다.
		 * 
		 * 이 때 인자로 input태그에 지정한 name 속성의 값을 문자열 형태로 전달해주어야 한다.
		 * 화면에서 전달한 form 내의 모든 input태그의 값을 hashMap으로 관리하고 있는데, 원하는 값을 찾기 위해서는 key역할을 하는 문자열이 필요하기
		 * 때문이다.
		 * */
		System.out.println(request.getQueryString());
		String name = request.getParameter("name");
		System.out.println("이름 : " + name);
		/* getparameter는 리턴타입이 문자열 형태이다.
		 * 즉, 숫자를 전달해도 문자열 형태로 전달되는 것에 주의하자
		 * 숫자로 된 값이 필요하다면 검증 후에 parsing을 해주어야 한다.
		 * */
		int age = Integer.parseInt(request.getParameter("age"));
		System.out.println("나이 : " + age);
		
		//java.sql.Date 타입으로 저장하고 싶은 경우에도 parameter를 Date type으로 변경해야 한다.
		java.sql.Date birthday = java.sql.Date.valueOf(request.getParameter("birthday"));
		System.out.println("생일 : " + birthday);
		
		//radiobutton으로 전달된 값은 여러 값 중 한가지만 전달되기 때문에 parameter로 전달받은 값을 꺼내기만 하면 된다.
		//혹시 가공처리가 필요한 경우 별도의 처리를 해준다.
		String gender = request.getParameter("gender");
		System.out.println("성별 : " + gender);
		
		
		//select box를 이용한 방식도 크게 다르지 않다.
		String national = request.getParameter("national");
		System.out.println("국적 : " + national);
		
		//check 박스는 다중으로 입력을 할 수 있기 떄문에 선택된 값이 문자열이 아닌 문자열 배열로 전달된다.
		// getParameterValues() 메소드를 이용하여 문자열 배열 형태로 값을 반환 받을 수 있다.
		String[] hobbies =request.getParameterValues("hobbies");
		for(String hobby : hobbies) {
			System.out.println(hobby);
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}

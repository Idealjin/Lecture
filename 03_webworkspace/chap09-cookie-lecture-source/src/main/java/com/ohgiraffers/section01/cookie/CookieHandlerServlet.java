package com.ohgiraffers.section01.cookie;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/cookie")
public class CookieHandlerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CookieHandlerServlet() {
        super();
   
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8");
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		
		System.out.println("firstName : " + firstName);
		System.out.println("lastName : " + lastName);
		
		//redirect는 url을 재작성해야 하기 때문에 url을 이용해서 요청하는 방식이기 때문에 get방식의 요청이다.
		//따라서 redirect되는 서블릿은 doGet메소드 쪽에서 처리해야 한다.
//		response.sendRedirect("redirect");
		
		/* 쿠키를 사용하는 방법 : 쿠키를 사용하는 절차가 있다.
		 * 1. 쿠키를 생성한다.
		 * 2. 해당 쿠키의 만료시간을 설정한다.
		 * 3. 응답헤더에 쿠키를 담는다.
		 * 4. 응답한다.
		 *  */
		
		/* 쿠키의 일부 제약항목
		 * 쿠키의 이름은 ascii 문자만을 사용해야 하며 한 번 설정한 쿠키의 이름은 변경할 수 없다.
		 * 또한 공백문자와 일부 특수문자([ ] ( ) = , " \ ? @ : ;)을 사용할 수 없다.
		 * */
		
		Cookie firstNameCookie = new Cookie("firstName", firstName); 
		Cookie lastNameCookie = new Cookie("lastName", lastName);
		
		firstNameCookie.setMaxAge(60 * 60 * 24); // 초단위 (하루를 만료 시간으로 두는 경우의 예시)
		lastNameCookie.setMaxAge(60 * 60 * 24);
		
		response.addCookie(firstNameCookie);
		response.addCookie(lastNameCookie);
		
		response.sendRedirect("redirect");
	}

}

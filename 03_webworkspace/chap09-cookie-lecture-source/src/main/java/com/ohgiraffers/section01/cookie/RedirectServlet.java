package com.ohgiraffers.section01.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/redirect")
public class RedirectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public RedirectServlet() {
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		
		System.out.println("firstName : " + firstName);
		System.out.println("lastName : " + lastName);
		
		/* 쿠키 사용
		 * 1. request에서 쿠키 목록을 쿠키 배열 형태로 꺼내온다.
		 * 2. 쿠키의 getName과 getValue를 이용해서 쿠키에 담긴 값을 이용한다.
		 * 
		 *  */
		Cookie[] cookies = request.getCookies();
		
		for(int i =0; i < cookies.length; i++) {
			System.out.println("[cookie] : " + cookies[i].getName() +  " : " +cookies[i].getValue());
			
			if("firstName".equals(cookies[i].getName())) {
				firstName = cookies[i].getValue();
			} else if("lastName".equals(cookies[i].getName())) {
				lastName = cookies[i].getValue();
			}
			
		}
		
		StringBuilder redirectText = new StringBuilder();
		redirectText.append("<!docType html>\n")
					.append("<head>\n")
					.append("</head>\n")
					.append("<body>\n")
					.append("<h3>your first name is ")
					.append(firstName)
					.append(" and your last name is ")
					.append(lastName)
					.append("</h3>\n")
					.append("</body>\n")
					.append("</html>\n");
		
		response.setContentType("text/html; charset=UTF8");
		PrintWriter out = response.getWriter();
		out.print(redirectText.toString());
		
		out.flush();
		out.close();
		
	}

}

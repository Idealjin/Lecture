package com.ohgiraffers.section02.otherservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/redirect")
public class RedirectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("이 서블릿으로 redirect가 성공!");
		
		StringBuilder redirectText = new StringBuilder();
		redirectText.append("<!docType html>\n")
					.append("<head>\n")
					.append("</head>\n")
					.append("<body>\n")
					.append("<h1> 이 서블릿으로 redirect 성공!</h1>")
					.append("</body>\n")
					.append("</html>\n");
		
		response.setContentType("text/html; charset=UTF8");
		PrintWriter out = response.getWriter();
		out.print(redirectText.toString());
		
		out.flush();
		out.close();
		
		/* redirect를 한 경우 url이 재작성되어 새로고침 하는 경우 redirect된 페이지에 대한 요청만을 반복하게 된다.
		 * 즉, 이전 요청에 남아 있던 정보는 더 이상 남아있지 않게된다.
		 * 또한 url이 변경되는 것이 redirect의 특징이다.
		 * 
		 * http 요청은 요청시 잠시 Connection을 맺고 응답 시에도 잠시 connection을 맺으며
		 * 요청 단위당 request객체는 한 개만 생성이 된다.
		 * 따라서 첫 요청시 request와 현재 redirect된 페이지의 request는 서로 다른 객체이다.
		 * 그렇기 때문에 redirect를 이용하게 되면 이전 서블릿의 값을 공유해서 사용할 수 없게 된다.
		 * */
	}

}

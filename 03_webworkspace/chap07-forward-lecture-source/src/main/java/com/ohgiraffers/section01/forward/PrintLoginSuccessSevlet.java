package com.ohgiraffers.section01.forward;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/print")
public class PrintLoginSuccessSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		/*
		 * forward 받은 서블릿에서도 요청 방식이 get이면 doGet메소드를, 요청 방식이 post이면 doPost메소드를 호출한다.
		 * request에 ReciveInfomation쪽 서블릿에서 전달하려는 정보를 담았기 때문에 해당 서블릿에서는
		 * 다시 Request에서 꺼내온다.
		 * */
		
		String userId = (String) request.getAttribute("userId");
		String password = (String) request.getAttribute("password");
		
		String password2 = request.getParameter("password");
		
		System.out.println("print : " + userId);
		System.out.println("print : " + password);
		System.out.println("print : " + password2);
		
		StringBuilder responseText = new StringBuilder();
		responseText.append("<!doctype html>\n")
				    .append("<html>\n")
				    .append("<head>\n") 
			 	    .append("</head>\n")
				    .append("<body>\n")
			    	.append("<h3 align=\"center\">")
				    .append(userId)
				    .append("님 환영합니다.</h3>")
				    .append("</body>\n")
				    .append("</html>\n");
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.print(responseText.toString());
		
		out.flush();
		out.close();
		
		/*
		 * 변수의 기본 스코프 메소드(해당 페이지) 이기 때문에 다른 페이지(사블릿) 으로 데이터를 공유할 수 없다.
		 * forward 방식은 reques와 response를 넣어서 위임하기 때문에 request에 정보를 저장하여 forward하기 되면
		 * 위임당한 서블릿에서도 서블릿의 정보를 공유할수 있게 된다.
		 * 이 방식을 forward라고 한다.
		 * 
		 *  forward는 해당 서블릿의 존재는 client가 알 필요가 없기 때문에 url자체가 변경되지 않는다.
		 *  사용자는 그저 결과 화면만 제대로 돌려받으면 되기 때문이다.
		 *  
		 *   forword방식의 또 다른 특징은 요청시 서버로 전송한 데이터가 남아있는 상태로 새로고침(재요청)을 하게되면
		 *   요청을계속 반복하기 때문에, 데이터베이스에 insert 등의 행위를 하는것은 중복된 행이 삽입될 가능성이 없게 된다.
		 *  따라서 그런경우는 또 다른 페이지 전환 방식을 이용하게 되는데
		 *  sendredirect 라고 불리는 방식이다.
		 * */
		
	}

}

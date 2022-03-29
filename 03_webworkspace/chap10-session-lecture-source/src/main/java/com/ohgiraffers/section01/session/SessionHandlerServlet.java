package com.ohgiraffers.section01.session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/session")
public class SessionHandlerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		
		System.out.println("firstName : " + firstName);
		System.out.println("lastName : " + lastName);
		
		
//		response.sendRedirect("redirect");
		
		HttpSession session = request.getSession();
		
		/*
		 * 세션에 설정된 기본 시간은 30분(1800)이고 필요에 따라 늘리거나 줄이면된다.
		 * 
		 * */
		
		System.out.println("Session 디폴트 유지 시간 : " + session.getMaxInactiveInterval());
		
		session.setMaxInactiveInterval(60*10); // 만료시간 10분으로 설정
		System.out.println(" 변경후 Session 디폴트 유지 시간 : " + session.getMaxInactiveInterval());
		
		//세션은 브라우저당 한 개씩 고유한 아이디를 가지고 하나의 인스턴스를 이용한다.
		//매번 반복적인 요청시 동일한 session id를 리턴한다.
		System.out.println("session id : " + session.getId());
		
		
			
		
		
		
		
		
	}

}

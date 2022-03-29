package com.ohgiraffers.section02.sessionlistener;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/session")
public class SessionListenerTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SessionListenerTestServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		System.out.println("발급받은 session id : " + session.getId());
		
		//added 동작
		session.setAttribute("username", "honggildong");
		session.setAttribute("age", 20);
		session.setAttribute("gender", "M");
		//replaced 동작
		session.setAttribute("username", "hong");
		//removed 동작
		session.removeAttribute("gender");
		//세션 만료 -> destroyed
//		session.setMaxInactiveInterval(1);
		session.invalidate();
		
	}

}

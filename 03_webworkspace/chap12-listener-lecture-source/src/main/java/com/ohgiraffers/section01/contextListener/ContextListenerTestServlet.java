package com.ohgiraffers.section01.contextListener;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/context")
public class ContextListenerTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public ContextListenerTestServlet() {
        super();
    
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Context Listener 확인용 서블릿");
		
		ServletContext context = request.getServletContext();
		
		//context에 attr을 추가하면 attributeadded()메소드가 동작한다.
		context.setAttribute("test", "value");
		
		//동일한 key로 attribute를 추가하면, 리플레이스 메소드가 동작한다.
		context.setAttribute("test", "value2");
		
		// context에서 attribute를 제거하면 attributeRemoved()메소드가 동작한다.
		context.removeAttribute("test");
	}

}

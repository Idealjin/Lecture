package com.ohgiraffers.section01.servicemethod;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/request-service")
public class ServiceMethodTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public ServiceMethodTestServlet() {
        super();
       
    }

	
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		//method : get, post, delete, put...
		//httprequest의 getmethod() 메소드는 어떠한 http메소드 요청이 들어온 것인지를 문자열 형태로 반환
		String httpMethod = httpRequest.getMethod();
		
		//a 태그에 href 속성은 url창의 내용을 변경하는 요청이며, GET요청에 해당한다.
		System.out.println("http method : " + httpMethod);
		
		if(("GET").equals(httpMethod)) {
			doGet(httpRequest, httpResponse);
		} else if(("POST").equals(httpMethod)) {
			doPost(httpRequest, httpResponse);
		}
		
	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("POST 요청을 처리할 메소드 호출됨...");
	}


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("GET! 요청을 처리할 메소드 호출됨...");
	}

}

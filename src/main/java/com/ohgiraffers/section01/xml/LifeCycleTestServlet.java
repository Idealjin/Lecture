package com.ohgiraffers.section01.xml;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/xml-lifecycle")
public class LifeCycleTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private int initCount = 1;
	private int serviceCount = 1;
	private int destroyCount = 1;

	
    public LifeCycleTestServlet() {
        super();
        
    }
    //서블링 요청이 최초인 경우 한번 동작하는 메소드
	public void init(ServletConfig config) throws ServletException {
		System.out.println("xml 매핑 init() 메소드 호출 : " + initCount++) ;
	}

	public void destroy() {
		// 컨테이너가 종료될때 호출되는 메소드이며 주로 자원을 반납하는 용도로 사용한다.
		System.out.println("xml 매핑 destroy() 메소드 호출 " + destroyCount++);
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		System.out.println("xml 매핑 service() 메소드 호출 : " + serviceCount++);
		
	}

}

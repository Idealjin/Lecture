package com.ohgiraffers.section01.annotation;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//loadOnStartup에 우선순위를 지정하면 ( 낮을술고 우선순위가 높다)
// 서버가 start될 때 인스턴스를 생성하고 init() 메소드를 요청한다.
@WebServlet(name = "LifeCycleTestServlet1", urlPatterns = { "/annotation-lifecycle"}, loadOnStartup = 1)
public class LifeCycleTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private int initCount = 1;
	private int serviceCount = 1;
	private int destroyCount = 1;
	
    public LifeCycleTestServlet() {
        
    }


	public void init(ServletConfig config) throws ServletException {
		System.out.println("xml 매핑 init() 메소드 호출 : " + initCount++) ;
	}

	public void destroy() {
		System.out.println("xml 매핑 destroy() 메소드 호출 " + destroyCount++);
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("annotation 매핑 service() 메소드 호출 " + serviceCount++);
	}

}

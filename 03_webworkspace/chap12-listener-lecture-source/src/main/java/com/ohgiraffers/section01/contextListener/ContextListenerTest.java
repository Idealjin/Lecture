package com.ohgiraffers.section01.contextListener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


@WebListener
public class ContextListenerTest implements ServletContextListener, ServletContextAttributeListener {

	/* 리스너는 특정 이벤트 행위가 동작하는 경우 컨테이너에 의해 호출되는 메소드들을 인터페이스에 정의해두었다.
	 * 이를 상속받아 구혆나 메소드가 특정 이벤트가 발생하는 경우 필요한 로직을 작성하게 되는데 크게 3가지 범주의 이벤트로 분류한다.
	 * 1. context
	 * 	1-1 ServletContextListener : 웹 어플리케이션의 시작, 종료에 대한 이벤트 리스터
	 * 	1-2 ServletContextAttributeListener : context에 attribute를 추가, 제거, 수정에 대한 이벤트 리스너
	 * 2. session
	 * 	2-1. HttpSessionListener : Http 세션의 시작, 종료에 대한 이벤트 리스너
	 * 	2-2. HttpSessionAttributeListener : HttpSession에 Attribute를 추가, 제거, 수정에 대한 이벤트 리스너
	 * 3. Request
	 * 	3-1. ServletRequestListener : ServletRequest 생성과 소멸에 대한 이벤트 리스너
	 * 	3-2. ServletRequest에 Attribute를 추가, 제거, 수정에 대한 이벤트 리스너
	 * */
   
    public ContextListenerTest() {
    	System.out.println("context Listener 인스턴스 생성");
    }

	
    public void attributeAdded(ServletContextAttributeEvent scae)  { 
         //context에 attribute가 추가될때 동작한다.
    	System.out.println("context attribute added");
    }

	
    public void attributeRemoved(ServletContextAttributeEvent scae)  { 
        // context에 attribute가 제거될때 동작한다.
    	System.out.println("context attribute Removed!");
    }

	
    public void contextDestroyed(ServletContextEvent sce)  { 
    	// context가 소멸할때 동작한다.    	
    	System.out.println("context Destroyed!");
        
    }


    public void attributeReplaced(ServletContextAttributeEvent scae)  { 
    	 // context에 attribute가 수정될때 동작한다.
    	System.out.println("context attribute Replaced!");
    }

	
    public void contextInitialized(ServletContextEvent sce)  { 
    	// context가 최초 생성될떄 셍성자 호출이후 동작
    	System.out.println("context init!");
    	
         
    }
	
}

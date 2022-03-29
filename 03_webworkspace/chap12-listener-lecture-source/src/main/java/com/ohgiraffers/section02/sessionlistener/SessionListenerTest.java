package com.ohgiraffers.section02.sessionlistener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


@WebListener
public class SessionListenerTest implements HttpSessionListener, HttpSessionAttributeListener {

  
    public SessionListenerTest() {
        System.out.println("session listener 인스턴스 생성");
    }

    public void sessionCreated(HttpSessionEvent se)  { 
        //세션이 생성될떄
    	System.out.println("Session Created");
    	System.out.println("todtjdehls session ID : " + se.getSession().getId());
    }


    public void sessionDestroyed(HttpSessionEvent se)  { 
    	System.out.println("Session Destroyed");
      
    }

	
    public void attributeAdded(HttpSessionBindingEvent se)  { 
    	System.out.println("Session Attribute Added");
    	System.out.println("추가된 session ID : " + se.getName() + " , " + se.getValue());
         
    }


    public void attributeRemoved(HttpSessionBindingEvent se)  { 
    	System.out.println("Session Attribute Removed");
    	System.out.println("제거된 session attribute ID : " + se.getName() + " , " + se.getValue());
         
    }

	
    public void attributeReplaced(HttpSessionBindingEvent se)  { 
    	System.out.println("Session Attribute Replaced");
    	System.out.println("수정된 session attribute ID : " + se.getName() + " , " + se.getValue());
        
    }
	
}

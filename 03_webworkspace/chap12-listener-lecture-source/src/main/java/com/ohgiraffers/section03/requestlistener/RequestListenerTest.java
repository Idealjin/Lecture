package com.ohgiraffers.section03.requestlistener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class RequestListenerTest implements ServletRequestListener, ServletRequestAttributeListener {

  
    public RequestListenerTest() {
    	// context가 로드될 때 생성자 호출하여 인스턴스는 생성된다.
    	System.out.println("request Listener 인스턴스 생성!");
    }


    public void requestDestroyed(ServletRequestEvent sre)  { 
       //소멸시
    	System.out.println("request Destroyed!");
    }

	
    public void attributeRemoved(ServletRequestAttributeEvent srae)  { 
        //제거시
    	System.out.println("request attribute Removed!");
    }

    public void requestInitialized(ServletRequestEvent sre)  { 
   
    	System.out.println("request init!");
    }


    public void attributeAdded(ServletRequestAttributeEvent srae)  { 
    	System.out.println("request Added!");
    	
    }


    public void attributeReplaced(ServletRequestAttributeEvent srae)  { 
    	//org.apache.catalina.ASYNC_SUPPORTED라는 attribute가 자동 수정되기 때문에 한번은 호출은 된다.
    	System.out.println("request Replaced!");
    	System.out.println(srae.getName() + " , " + srae.getValue());
    }
	
}

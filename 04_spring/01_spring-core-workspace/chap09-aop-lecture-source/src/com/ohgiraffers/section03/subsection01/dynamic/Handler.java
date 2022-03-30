package com.ohgiraffers.section03.subsection01.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/* 호출에 따른 프록시에서 처리할 메소드를 구현하기 위해서는 
 * InvocationHandler를 구현한 클래스를 작성한다. 
 * */
public class Handler implements InvocationHandler {
	
	//메소드 호출을 위해 타켓 인스턴스가 필요하다.
	private final Student student; 
	
	public Handler(Student student) {
		this.student = student;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		
		System.out.println("=================== 공부가 너무 하고 싶습니다. =============================");
		System.out.println("호출 대상 메소드 : " + method);
		for(Object arg : args) {
			System.out.println("전달된 인자 : " + arg);
		}
		
		/* 타켓 메소드를 호출한다.*/
		method.invoke(student, args);
		
		System.out.println("==================== 공부를 마치고 수면 학습을 시작합니다. =======================");
		 
		return proxy;
	}

}

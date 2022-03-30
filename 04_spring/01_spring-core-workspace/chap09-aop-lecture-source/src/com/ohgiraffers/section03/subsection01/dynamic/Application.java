package com.ohgiraffers.section03.subsection01.dynamic;

import java.lang.reflect.Proxy;

public class Application {

	public static void main(String[] args) {
		
		/*
		 * 프록시란?
		 * 
		 * 실제 Target의 기능을 수행하면서 기능을 확장하거나 추가하는 실제 객체를 의미한다.
		 * */
		
		Student student = new OhgiraffersStudent();
		Handler handler = new Handler(student);
		
		/* 클래스로더, 프록시를 만들 클래스 메타정보(인터페이스만 가능), 프록시 동작할 때 적용될 핸들러 */
		Student proxy = (Student) Proxy.newProxyInstance(Student.class.getClassLoader(), new Class[] {Student.class}, handler);
		
		/* 프록시로 감싸진 인스턴스의 메소드를 호출하게되면 핸들러에 정의한 메소드가 호출된다.*/
		proxy.study(16);
		
		/* 프록시 생성은 크게 두 가지 방식이 제공된다.
		 * 1. JDK Dynamic Proxy 방식
		 * 2. CGLib 방식
		 * */
		
		
	}
}

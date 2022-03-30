package com.ohgiraffers.section03.subsection02.cglib;

import org.springframework.cglib.proxy.Enhancer;

public class Application {

	public static void main(String[] args) {
		
		OhgiraffersStudent student = new OhgiraffersStudent();
		Handler handler = new Handler(student);
		
		/* 인터페이스 없이 구현 가능하다.
		 * Enhancer 클래스의 create static 메소드를 통해서 타켓 클래스의 메타정보와 핸들러를 전달하면 proxy를 생성해서 반환한다.
		 * */
		OhgiraffersStudent proxy 
			= (OhgiraffersStudent) Enhancer.create(OhgiraffersStudent.class, new Handler(new OhgiraffersStudent()));
				
		proxy.study(20);		
	}
}

package com.ohgiraffers.section01.xmlconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Application {

	public static void main(String[] args) {
		
		//Bean Factory란?
		/* 스프링컨테이너의 최상위컨테이너이며, Application Context와 함께 스프링 컨테이너라고 한다.
		 * Bean의 생성, 관리 등의 역할을 하고 있따.
		 * */
		
		
		
		
		ApplicationContext context = new GenericXmlApplicationContext("com/ohgiraffers/section01/xmlconfig/spring-context.xml");
	
		//1. bean의 id를 이용해 bean을가져오는 방법 - > 다운캐스팅 필요
//		MemberDTO member = (MemberDTO) context.getBean("member");
		// -> MemberDTO member = new MemberDTO();
		
		
		//2. Bean의 클래스 메타 정보를 전달하여 가져오는 방법
//		MemberDTO member = context.getBean(MemberDTO.class);
		
		//3. bean의 id와 클래스 메타정보를 전달하여 가져오는 방법
		MemberDTO member = context.getBean("member",MemberDTO.class);
		
		System.out.println(member);
	}
	
}

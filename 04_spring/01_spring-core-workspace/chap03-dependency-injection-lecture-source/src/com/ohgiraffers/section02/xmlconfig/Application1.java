package com.ohgiraffers.section02.xmlconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.ohgiraffers.section01.javaconfig.config.ContextConfiguration1;

public class Application1 {

	public static void main(String[] args) {
	
		ApplicationContext context = new GenericXmlApplicationContext("com/ohgiraffers/section02/xmlconfig/config/spring-context.xml");
		
		String[] beanNames = context.getBeanDefinitionNames();
		for(String beanName : beanNames) {
			System.out.println("beanName : " + beanName);
		}
		
		MemberDTO member = context.getBean(MemberDTO.class);
		
		System.out.println(member);
		
		System.out.println(member.getPersonalAccount().getBalance());
		System.out.println(member.getPersonalAccount().deposit(1000000));
		System.out.println(member.getPersonalAccount().getBalance());
		System.out.println(member.getPersonalAccount().withDraw(50000));
		System.out.println(member.getPersonalAccount().getBalance());
		
	}
}

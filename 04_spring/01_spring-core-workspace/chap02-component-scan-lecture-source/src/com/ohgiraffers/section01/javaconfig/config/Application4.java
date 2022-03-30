package com.ohgiraffers.section01.javaconfig.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application4 {

	public static void main(String[] args) {
		
		//베이스 패키지로 사용할 경로를 문자형 형태의 인자로 전달하면
		//해당 경로를 basePackage로 설정하여 스캔한다.
		// 여러 개의 basePackage를 설정할 수 있다.
		ApplicationContext context = new AnnotationConfigApplicationContext(
					"com.ohgiraffers.section01.javaconfig.config");
	
		String[] beanNames = context.getBeanDefinitionNames();
		
		for(String beanName : beanNames) {
			System.out.println("beanName : " + beanName);
		}
		
	}
	
}

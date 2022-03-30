package com.ohgiraffers.section01.advice.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

	public static void main(String[] args) throws Exception {
		
		/* advice 종류 */
		ApplicationContext context = new AnnotationConfigApplicationContext("com.ohgiraffers.section01.advice.annotation");
		
		String[] beanNames =context.getBeanDefinitionNames();
		for(String beanName : beanNames) {
			System.out.println("beanName : " + beanName);
		}
		
		Student normalStudent = context.getBean("normalStudent", Student.class);
		
		System.out.println("============== Normal Student ==================");
		AchievementResult normalResult = normalStudent.study(new Passion(10));
		System.out.println("NormalStudent Result : " + normalResult);
		
		Student ohgiraffersStudent = context.getBean("ohgiraffersStudent", Student.class);
		System.out.println("============== ohgiraffers Student ==================");
		AchievementResult ohgiraffersResult = ohgiraffersStudent.study(new Passion(10));
		System.out.println("ohgiraffers Result : " + ohgiraffersResult);
		
	}
	
	
}

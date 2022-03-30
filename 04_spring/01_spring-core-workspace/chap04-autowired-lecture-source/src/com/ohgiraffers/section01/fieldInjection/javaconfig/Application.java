package com.ohgiraffers.section01.fieldInjection.javaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

	public static void main(String[] args) {
		
		//@Autowired를 이용한 의존성 주입
		
		
		ApplicationContext context = 
				new AnnotationConfigApplicationContext("com.ohgiraffers.section01.fieldInjection.javaconfig");
		
		BookService bookService = context.getBean("bookService", BookService.class);
		
		for(BookDTO b : bookService.selectAllBooks()) {
			System.out.println(b);
		}
		
		System.out.println(bookService.searchBookBySequence(1));
		
	}
	
}

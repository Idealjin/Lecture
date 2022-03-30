package com.ohgiraffers.section03.xmlconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;


public class Application {

	public static void main(String[] args) {
		
		ApplicationContext context = 
				new GenericXmlApplicationContext("com/ohgiraffers/section03/xmlconfig/config/spring-context.xml");
		
		Product carpBread = context.getBean("carpBread", Bread.class);
		Product milk = context.getBean("milk", Beverage.class);
		Product water = context.getBean("water", Beverage.class);
		
		ShoppingCart cart1 = context.getBean("cart", ShoppingCart.class);
		cart1.addItem(carpBread);
		cart1.addItem(milk);
		
		System.out.println("cart1에 담긴 내용 : " + cart1.getItem());
		
		ShoppingCart cart2 = context.getBean("cart", ShoppingCart.class);
		cart2.addItem(water);
		
		System.out.println("cart2에 담긴 내용 : " + cart2.getItem());
		
		/* 강제로 컨테이너를 종료시키면 폐기 메소드가 동작한다. */
		((GenericXmlApplicationContext) context).close();
		
	}
	
}

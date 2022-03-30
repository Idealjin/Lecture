package com.ohgiraffers.section04.resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

	public static void main(String[] args) {
		
		// 스프링 전용인 @Autowired 대신 자바 표준 어노테이션 @Resource로 POJO연결
		
		ApplicationContext context = new AnnotationConfigApplicationContext("com.ohgiraffers.section04.resource");
		
		PokemonService pokemonService = context.getBean("pokemonService", PokemonService.class);
		
		pokemonService.pokemonAttack();
		
		
		
	}
	
}

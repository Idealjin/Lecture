package com.ohgiraffers.section03.collection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

	public static void main(String[] args) {
		
		// 세 개의 빈 모두 사용해야하는 경우
		
		ApplicationContext context = new AnnotationConfigApplicationContext("com.ohgiraffers.section03.collection");
		
		PokemonService pokemonService = context.getBean("pokemonService", PokemonService.class);
		
		pokemonService.pokemonAttack();
	}
	
}

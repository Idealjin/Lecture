package com.ohgiraffers.section04.resource;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PokemonService {

	/* 리소스는 기본적으로 이름(id)으로 주입받는다. 하지만 빈의 이름이 일치하지 않으면 타입으로 주입을 받는다.
	 * 1. 같은 타입의 bean이 여러개*/
	
	@Resource(name="charmander")
	private Pokemon pokemon;

	@Autowired
	public PokemonService(Pokemon pokemon) {
		this.pokemon = pokemon;
	}
	
	public void pokemonAttack() {
			pokemon.attack();
	}
	
	
	
	
}

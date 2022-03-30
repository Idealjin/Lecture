package com.ohgiraffers.section02.qualifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class PokemonService {

	/*@Qualifier으로 의존성 주입을 하는 경우 타입이 아닌 이름(id)으로 주입한다.
	 * @primary보다 우선권을 가진다.
	 *  */
	
	//필드 주입을 이용한 경우
	@Autowired
	@Qualifier("pikachu")
	private Pokemon pokemon;
	
	//생성자 주입을 이용한 경우
//	@Autowired
//	public PokemonService(@Qualifier("charmander") Pokemon pokemon) {
//		this.pokemon = pokemon;
//	}
	
	public void pokemonAttack() {
		pokemon.attack();
	}
	
}

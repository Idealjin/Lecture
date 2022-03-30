package com.ohgiraffers.section05.inject;

import org.springframework.stereotype.Component;

@Component
public class Charmander implements Pokemon {

	@Override
	public void attack() {
		System.out.println("파이리가 공격을 합니다. 화염방사~~~~!");
		
	}

}

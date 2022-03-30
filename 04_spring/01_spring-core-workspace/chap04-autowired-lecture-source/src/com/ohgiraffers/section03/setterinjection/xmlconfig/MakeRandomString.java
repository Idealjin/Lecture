package com.ohgiraffers.section03.setterinjection.xmlconfig;

import org.springframework.beans.factory.annotation.Autowired;

public class MakeRandomString {
		
	private RandomGenerator random;
	
	@Autowired
	public void setRandom(RandomGenerator random) {
		this.random = random;
	}
	
	public String getRandomLengthString() {
		
		StringBuilder sb = new StringBuilder();
		
		int randomNumber = random.getRandomNumber();
		for(int i = random.getStartNum(); i <= randomNumber; i++) {
			sb.append("*");
		}
		
		return sb.toString();
	}
}

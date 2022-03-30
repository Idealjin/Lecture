package com.ohgiraffers.section03.setterinjection.xmlconfig;

public interface RandomGenerator {
	
	// 난수 발생
	int getRandomNumber();
	// 난수 시작 값
	public int getStartNum();
	// 난수 범위 종료 값 
	public int getEndNum();
	
}

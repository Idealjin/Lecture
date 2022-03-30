package com.ohgiraffers.section01.advice.annotation;


/* 
 * 학생은 공부를 해야한다.
 * */
public interface Student {

	AchievementResult study(Passion passion) throws Exception;
	
	
}

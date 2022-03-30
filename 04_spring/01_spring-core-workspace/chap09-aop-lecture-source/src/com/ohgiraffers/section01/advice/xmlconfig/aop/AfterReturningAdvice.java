package com.ohgiraffers.section01.advice.xmlconfig.aop;

import org.aspectj.lang.JoinPoint;
import com.ohgiraffers.section01.advice.xmlconfig.AchievementResult;


public class AfterReturningAdvice {
	
	public void afterAttending(JoinPoint joinPoint, Object result) {
		
		/* 조인포인트로 처리할 수 있는 정보는 동일하며, after advice보다 먼저 동작한다. */
		System.out.println("=================== after returning attending ===========================");
		System.out.println("보람찬! 하루일을! 끝마치고서~~~ 두 다리 쭉 펴면 고향의 안방~~~~~!!");
		System.out.println("오늘의 이해도 : " + (((AchievementResult) result).getUnderstandingScore()));
		System.out.println("오늘의 만족도 : " + (((AchievementResult) result).getSatisfactionScore()));
		
		double employeementRate = ((AchievementResult) result).getEmployeementRate();
		double percent = employeementRate / 1000.0 * 100;
		System.out.println("증가된 취업율 : " + percent + "%");
		
		// 리턴할 결과값을 변경해 줄 수 도 있따. 
		((AchievementResult) result).setEmployeementRate(percent);
		System.out.println("=======================================================");
	}
}

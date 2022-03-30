package com.ohgiraffers.section01.advice.annotation.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.ohgiraffers.section01.advice.annotation.AchievementResult;

@Aspect
@Component
public class AfterReturningAdvice {

	//Returning 속성을 가지고 있다.
	// returning 속성은 리턴값으로 받아올 매개변수 이름과 동일해야 한다.
	//또한 조인포인트는 반드시 첫번째 매개변수로선언해야한디.
	@AfterReturning(pointcut = "execution(* com.ohgiraffers.section01.advice.annotation..*(..))", returning = "result")
	public void afterAttending(JoinPoint joinpoint, Object result) {
		System.out.println("================ after returning attending ===============");
		System.out.println("보람찬 하루일을 끝마치고서~~~");
		System.out.println("오늘으 ㅣ이해도  : " + (((AchievementResult) result).getUnderstandingScore()));
		System.out.println("오늘으 ㅣ이해도  : " + (((AchievementResult) result).getSatisfactionScore()));
		
		double employeementRate = ((AchievementResult) result).getEmployeementRate();
		double percent = employeementRate / 1000.0 *100;
		System.out.println("증가된 취업율 : " + percent + "%");
		
		// 리턴할 결과값 변경해줄수도있
		((AchievementResult) result).setEmployeementRate(percent);
		System.out.println("==========================================================");
		
	}
	
}

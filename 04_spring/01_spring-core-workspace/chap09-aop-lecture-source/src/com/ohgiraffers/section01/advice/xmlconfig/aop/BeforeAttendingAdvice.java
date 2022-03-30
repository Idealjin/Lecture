package com.ohgiraffers.section01.advice.xmlconfig.aop;

import org.aspectj.lang.JoinPoint;
import com.ohgiraffers.section01.advice.xmlconfig.Passion;

public class BeforeAttendingAdvice {

	public void beforeAttending(JoinPoint joinPoint) {
		
		System.out.println("================ before attending ===================");
		System.out.println("오늘도 신나게 등원해서 입실 카드를 찍는다.");
		System.out.println("수강생 타입 : " + joinPoint.getTarget().getClass()); 
		System.out.println("수강생의 행위 : " + joinPoint.getSignature());
		System.out.println("행위 요약 : " + joinPoint.getSignature().getName());
		System.out.println("수강생의 열정 : " + ((Passion) joinPoint.getArgs()[0]).getScore());
		
	}
}

package com.ohgiraffers.section01.advice.annotation.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.ohgiraffers.section01.advice.annotation.Passion;

// aspectj 라이브러리를 추가하여 pointcut과 advice를 하나의 클래스 단위로 정의하기 위한 라이브러리
@Aspect
@Component
public class BeforeAttendingAdvice {

	/*
	 * 포인트컷으로 패치한 실행 지점을 조인포인트라고 한다.
	 * 포인트컷은 여러 조인포인트를 매치하기 위해 지정한 표현식이고, 이렇게 매치된
	 * 조인 포인트에서 해야할 일이 어드바이스이다.
	 * */
//	@Before("execution(* com.ohgiraffers.section01.advice.annotation..*(..))")
	@Before("StudentPointcut.studyPointcut()")
	public void beforeAttending(JoinPoint joinPoint) {
		
		System.out.println("===================== before attending ======================");
		System.out.println("오늘도 신나게 등원해서 입실 카드를 찍는다.");
		System.out.println("수강생 타입 : " + joinPoint.getTarget().getClass());
		System.out.println("수강생 타입 : " + joinPoint.getSignature());
		System.out.println("수강생 타입 : " + joinPoint.getSignature().getName());
		System.out.println("수강생 타입 : " + ((Passion) joinPoint.getArgs()[0]).getScore());
		
	}
}

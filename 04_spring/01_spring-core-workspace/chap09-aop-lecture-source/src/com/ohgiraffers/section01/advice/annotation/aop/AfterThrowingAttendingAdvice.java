package com.ohgiraffers.section01.advice.annotation.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AfterThrowingAttendingAdvice {

	//exception이 throws된 경우에 동작한다.
	@AfterThrowing(pointcut = "execution(* com.ohgiraffers.section01.advice.annotation..*(..))", throwing="exception")
	public void afterThrowingAttending(JoinPoint joinpoint, Throwable exception) {
		System.out.println("============== after throwing attending ===============");
		System.out.println(exception.getMessage());
		System.out.println("=======================================================");
		
		
	}
	
}

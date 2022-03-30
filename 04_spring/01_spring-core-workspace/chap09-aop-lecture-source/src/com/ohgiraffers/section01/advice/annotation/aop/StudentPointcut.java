package com.ohgiraffers.section01.advice.annotation.aop;

import org.aspectj.lang.annotation.Pointcut;

public class StudentPointcut {

	@Pointcut("execution(* com.ohgiraffers.section01.advice.annotation..*(..))")
	private void studyPointcut() {}
	
}

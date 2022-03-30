package com.ohgiraffers.section01.advice.xmlconfig.aop;

import org.aspectj.lang.JoinPoint;
import com.ohgiraffers.section01.advice.xmlconfig.Passion;

public class AfterAttendingAdivce {

	public void afterAttending(JoinPoint joinPoint) {
		System.out.println("================ after attending =====================");
		System.out.println("내일도 학원에 가서 열심히 공부해야지!! 라는 마음으로 잠자리에 듭니다.");
		System.out.println("수강생 타입 : " + joinPoint.getTarget().getClass()); // 타겟 클래스의 정보
		System.out.println("수강생의 행위 : " + joinPoint.getSignature()); // 리턴타입을 포함한 시그니쳐
		System.out.println("행위 요약 : " + joinPoint.getSignature().getName());  // 메소드의 이름만 반환
		System.out.println("수강생의 열정 : " + ((Passion) joinPoint.getArgs()[0]).getScore());
	}
}

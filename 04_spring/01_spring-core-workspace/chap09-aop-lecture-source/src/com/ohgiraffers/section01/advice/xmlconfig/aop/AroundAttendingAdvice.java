package com.ohgiraffers.section01.advice.xmlconfig.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

import com.ohgiraffers.section01.advice.xmlconfig.OhgiraffersStudent;

public class AroundAttendingAdvice {

	public Object aroundAttending(ProceedingJoinPoint joinPoint) throws Throwable {
		
		System.out.println("=============== around attending before =========================");
		System.out.println("오늘도 학원에 가서 열심히 공부해야지!! 라는 마음으로 아침 일찍 일어납니다.");
		System.out.println("=================================================================");
		
		/* 공부 시간을 체크 */
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		
		/* 원본 조인포인트를 실행한다. */
		Object result = joinPoint.proceed();
		
		System.out.println("====================== around attending after ============================");
		/* 만약에 Ohgiraffers학생이면 학원 문이 닫을 때 까지 열심히 스터디를 합니다. */
		if(joinPoint.getTarget() instanceof OhgiraffersStudent) {
			System.out.println("수업이 끝나도 학원이 닫을 때 까지는 끝난게 아닙니다. 자율적 스터디 그룹과 함꼐 다시 공부합시다!!");
		}
		
		System.out.println("열심히 공부했으니 퇴실 카드를 찍는다.");
		
		stopWatch.stop();
		
		System.out.println("총 공부 소요 시간 : " + stopWatch.getTotalTimeMillis() + "(ms)");
		System.out.println("======================================================================");
		
		return result;
	}
}









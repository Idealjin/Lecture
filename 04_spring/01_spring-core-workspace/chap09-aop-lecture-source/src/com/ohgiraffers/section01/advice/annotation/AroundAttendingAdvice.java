package com.ohgiraffers.section01.advice.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class AroundAttendingAdvice {

//	@Around("execution(* com.ohgiraffers.section01.advice.annotation..*(..))")
	@Around("AroundAttendingAdvice.studentAroundPointcut()")
	public Object aroundAttending(ProceedingJoinPoint joinPoint) throws Throwable {
		
		System.out.println("=============== aroundAttending before ================");
		System.out.println("오늘도 학원에 가서 열심히 공부해야지 ! 라는 마음으로 아침 일찍 일어납니다.");
		System.out.println("=======================================================");
		
		//공부 시간을 체크
		StopWatch stopwatch = new StopWatch();
		stopwatch.start();
		//원본 조인포인트를 실행한다
		Object result = joinPoint.proceed();
		
		System.out.println("=============== around attending after ==================");
		if(joinPoint.getTarget() instanceof OhgiraffersStudent) {
			System.out.println("수업이 끝나도 학원이 닫을 때까지는 끝난게 아닙니다. 자율적스터디합시다! ");
		}
		
		System.out.println("열심히 공부했으니 퇴실카드를 찍는다.");
		
		stopwatch.stop();
		
		System.out.println("총 공부 소요 시간 : " + stopwatch.getTotalTimeMillis() + "(ms)");
		System.out.println("============================================================");
		
		return result;
	}
	
	//void형 메소드로 작성하고 표현식을 작성한 뒤 메소드 이름이 포인트컷의 이름이 된다.
	@Pointcut("execution(* com.ohgiraffers.section01.advice.annotation..*(..))")
	private void studentAroundPointcut() {}
	
	
}

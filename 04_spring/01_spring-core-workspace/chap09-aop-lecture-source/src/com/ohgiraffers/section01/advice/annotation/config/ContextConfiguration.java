package com.ohgiraffers.section01.advice.annotation.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
// aspectj의 autoproxy 사용에 관한 설정을 해줘야 advice가 동작한다.
// weaver라이브러리를 추가하면 joinpoint에 advice를 끼넣는 행위 위빙을 해줄수있다.
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class ContextConfiguration {

	
	
}

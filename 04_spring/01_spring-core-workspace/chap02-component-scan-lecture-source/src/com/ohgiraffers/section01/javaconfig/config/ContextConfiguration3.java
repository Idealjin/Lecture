package com.ohgiraffers.section01.javaconfig.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import com.ohgiraffers.section01.javaconfig.MemberDAO;

/*
 * 	useDefaultFilters = false로 하면 모든 어노테이션을스캔하지 않는다.
 * 이 때 스캔할 대상 클래스만 따로 지정할 수도 있다.
 * */

@Configuration
@ComponentScan(basePackages = "com.ohgiraffers.section01.javaconfig",
				useDefaultFilters = false,
				includeFilters = {
						@ComponentScan.Filter(type=FilterType.ASSIGNABLE_TYPE,
											classes = {MemberDAO.class})

				}
		)
public class ContextConfiguration3 {

	
	
}

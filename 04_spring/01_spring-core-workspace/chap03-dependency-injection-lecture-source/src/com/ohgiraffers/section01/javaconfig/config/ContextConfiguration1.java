package com.ohgiraffers.section01.javaconfig.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ohgiraffers.section01.javaconfig.Account;
import com.ohgiraffers.section01.javaconfig.MemberDTO;
import com.ohgiraffers.section01.javaconfig.PersonalAccount;

@Configuration
public class ContextConfiguration1 {

	@Bean
	public Account accountGenerator() {
		
		return new PersonalAccount(20, "110-230-123455", "1234");
	}
	
	/* 생성자를 통해 Account를 생성하는 메소드를 호출한 리턴값을 사용하여 bean을 조립*/ 
	@Bean
	public MemberDTO memberGenerator() {
		
		return new MemberDTO(1, "홍길동", "010-1234-5678", "hong123@gmail.com", accountGenerator());
	}
}

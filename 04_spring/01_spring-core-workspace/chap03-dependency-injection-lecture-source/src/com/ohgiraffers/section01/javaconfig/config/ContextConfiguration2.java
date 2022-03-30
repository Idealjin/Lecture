package com.ohgiraffers.section01.javaconfig.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ohgiraffers.section01.javaconfig.Account;
import com.ohgiraffers.section01.javaconfig.MemberDTO;
import com.ohgiraffers.section01.javaconfig.PersonalAccount;

@Configuration
public class ContextConfiguration2 {

	@Bean
	public Account accountGenerator() {
		
		return new PersonalAccount(20, "110-230-123455", "1234");
	}
	
	
	@Bean
	public MemberDTO memberGenerator() {
		
		MemberDTO member = new MemberDTO();
		Account account = accountGenerator();
		
		member.setSequence(1);
		member.setName("홍길동");
		member.setPhone("010-1234-5678");
		member.setEmail("hong123@ohgiraffers.com");
		member.setPersonalAccount(account); // 인자가 들어가는 자리에서 바로 메소드 호출해도 가능하다.
		
		return member;
	}
}

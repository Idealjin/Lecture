package com.ohgiraffers.section02.constinjection.javaconfig.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.ohgiraffers.section02.constinjection.javaconfig.RandomGenerator;
import com.ohgiraffers.section02.constinjection.javaconfig.RandomNumberGenerator;

@Configuration
@ComponentScan("com.ohgiraffers.section02.constinjection")
public class ContextConfiguration {

	@Bean
	public RandomGenerator randomGenerator() throws Exception {
		
		return new RandomNumberGenerator(1, 10);
	}
}

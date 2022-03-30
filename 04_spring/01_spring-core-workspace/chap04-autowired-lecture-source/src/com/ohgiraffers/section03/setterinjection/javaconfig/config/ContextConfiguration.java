package com.ohgiraffers.section03.setterinjection.javaconfig.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.ohgiraffers.section03.setterinjection.javaconfig.RandomGenerator;
import com.ohgiraffers.section03.setterinjection.javaconfig.RandomNumberGenerator;

@Configuration
@ComponentScan("com.ohgiraffers.section03.setterinjection.javaconfig")
public class ContextConfiguration {

	public RandomGenerator randomGenerator() throws Exception {
		return new RandomNumberGenerator(1, 10);
	}
	
}

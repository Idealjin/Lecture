package com.ohgiraffers.section02.qualifier;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary   //primary를 설정하면 @Autowired로 동일한 타입의여러 빈을 찾게되는 경우 자동연결을 우선시할 타입으로 설정
public class Pikachu implements Pokemon{

	@Override
	public void attack() {
		System.out.println("피카츄가 공격을 합니다, 백만 볼트~~ 찌지지지직!");
		
	}

}

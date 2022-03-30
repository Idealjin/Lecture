package com.ohgiraffers.section02.annotatoin;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component
public class Owner {
	// init-method와 같은 설정의 어노테이션 -> @PostConstruct
	@PostConstruct
	public void openShop() {
		System.out.println("사장님이 가게 문을 오픈하였습니다. 이제 쇼핑을 하실 수 있습니다.");
	}
	
	//destroy-method와 같은 설정의 어노테이션 -> @PreDestoy
	@PreDestroy
	public void closeShop() {
		System.out.println("사장님이 가게 문을 닫으셨습니다. 이제 쇼핑을 하실 수 없습니다.");
	}
	
}

package com.ohgiraffers.section02.service.model.run;

import com.ohgiraffers.section02.service.model.service.MenuService;

public class Application {
	public static void main(String[] args) {
		
		//Service의 역할
		/* 1. Connection 생성
		 * 2. DAO 메소드 호출
		 * 3. 트랜젝션 제어
		 * 4. Connection 닫기
		 * */
		
		new MenuService().registNewMenu();
		
		
	}
}

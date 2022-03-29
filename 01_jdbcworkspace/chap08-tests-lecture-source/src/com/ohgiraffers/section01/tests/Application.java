package com.ohgiraffers.section01.tests;

public class Application {
	public static void main(String[] args) {
		
		// 테스트 시나리오
		// 에플리케이션의 테스트 되어야할 기능이나 특징을 한 문장으로 기술 한 것
		
		// 1. Calculator 인스턴스 생성이 잘되는지 테스트
		Calculator calc = new Calculator();
		
		if(calc != null) {
			System.out.println("성공");
		} else {
			System.out.println("실패");
		}
		
		// 2. sumTwoNumber 메소드가 정상 기능하는지 테스트
		//2-1 4,5를 전달 -> 9가 나오는지확인
		int result1 = calc.sumToNumber(4, 5);
		
		if(result1 == 9) {
			System.out.println("4와 5를 전달하여 합계가 9인지 확인");
		} else {
			System.out.println("4와 5를 전달하여 합계가 9가 아니다");
		}
		
		//2-2 6과 7을 전달하면 합게가 13이 되는지 확인
		int result2 = calc.sumToNumber(6, 7);
		
		if(result1 == 13) {
			System.out.println("6와 7를 전달하여 합계가 13인지 확인");
		} else {
			System.out.println("6와 7를 전달하여 합계가 13이 아니다");
		}
		
		// 3. 위 테스트 결과가 모두 통과되면 해당 클래스의 메소드는 신뢰성 있는 메소드임을 확인한다.
		if(result1 == 9 && result2 == 13) {
			System.out.println("테스트 성공! 유후~");
		} else {
			System.out.println("테스트 실패... 다시 메소드를 확인해주세요.");
		}
		
		
	}
}

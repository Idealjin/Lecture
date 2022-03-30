package com.ohgiraffers.section02.locale.javaconfig;

import java.util.Date;
import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ohgiraffers.section02.locale.javaconfig.config.ContextConfiguration;

public class Application {

	public static void main(String[] args) {
		
		/*
		 * i18n 소프트웨어의 국제화 (Internationalization에서 첫글자 I와 마지막 글자인 N사이 알파벳 개수가 18개)
		 * 소프트웨어를 국제화 하기 위해서는 처리해야할 작업이 있다.
		 * 1. 언어, 지역별 번역
		 * 2. OS/플랫폼 별 인코딩
		 * 3. 문자열 치환방법 : 서버쪽, 클라이언트쪽 중 서버쪽에서 하는 것이 좋다.
		 * 4. 국제화 UI(문자열 크기 변환, 폰트, 아이콘등)
		 * 5. 쓰기 방향의 차이
		 * 6. 숫자, 공백, 화폐, 날짜, 주소, 측정단위 등
		 * 7. 타임존, 섬머타임 등 시각
		 * 8. 문자열 정렬 방법
		 * */
		
		ApplicationContext context = 
				new AnnotationConfigApplicationContext(ContextConfiguration.class);
		
		String error404Message = context.getMessage("error.404", null, Locale.US);
		String error500Message = context.getMessage("error.500",new Object[] {"sangjin", new Date()}, Locale.KOREA);
		
		System.out.println("The I18N message for error404 : " + error404Message);
		System.out.println("The I18N message for error500 : " + error500Message);
		
		
	}
	
}

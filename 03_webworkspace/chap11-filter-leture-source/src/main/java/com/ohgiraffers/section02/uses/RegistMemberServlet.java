package com.ohgiraffers.section02.uses;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@WebServlet("/member/regist")
public class RegistMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		
		System.out.println("userId : " + userId);
		System.out.println("password : " + password);
		System.out.println("name : " + name);
		
		/* 암호화 처리된 패스워드는 동일한 값을 입력하더라도 매번 실행할 때마다 다른 값을 가지게 된다.
		 * 암호화된 문자열은 일반 문자열 비교가 불가능하고 matches()라는 메소드를 이용해야 한다.
		 * */
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		System.out.println("비밀번호가 pass01인지 확인 : " + passwordEncoder.matches("pass01", password));
		System.out.println("비밀번호가 pass02인지 확인 : " + passwordEncoder.matches("pass02", password));
		
	}

}

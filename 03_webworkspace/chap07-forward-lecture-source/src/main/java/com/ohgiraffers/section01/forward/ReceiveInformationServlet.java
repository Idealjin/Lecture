package com.ohgiraffers.section01.forward;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/forword")
public class ReceiveInformationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ReceiveInformationServlet() {
        super();
        
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); //POST방식을 할떄는 꼭 캐릭터인코딩을 셋 해야한다.
		
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		//여러개 값을 가져올때는 getparameterValues를 사용한다.
		System.out.println("userId : " + userId);
		System.out.println("password : " + password);
	
		//서블릿의 역할은 3가지
		/*
		 * 1. 요청정보 받기 (위에 작성한 내용)
		 * 2. 비즈니스 로직 처리
		 * 3. 응답 내보내기
		 * */
		
		request.setAttribute("userId", userId);
		
		RequestDispatcher rd = request.getRequestDispatcher("print");
		
		rd.forward(request, response);
		
		
	}

}

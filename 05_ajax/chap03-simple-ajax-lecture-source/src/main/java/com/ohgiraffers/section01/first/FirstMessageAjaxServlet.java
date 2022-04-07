package com.ohgiraffers.section01.first;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/first/message")
public class FirstMessageAjaxServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*전달된 파라미터를 꺼낼때는 Request의 getparameter 메소드를 이용한다.
		 * 마찬가지로 응답데이터에 한글이 포함되어 있는 경우 응답에 대한 인코딩 설정을 해주어야 한다.
		 * 반환하는 데이터의 기본 형태는 text/plain이다.
		 * */
		
		String message = request.getParameter("message");
		
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		out.print("I'm get! " + message);
		
		out.flush();
		out.close();
		
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*전달된 파라미터를 꺼낼때는 Request의 getparameter 메소드를 이용한다.
		 * 마찬가지로 응답데이터에 한글이 포함되어 있는 경우 응답에 대한 인코딩 설정을 해주어야 한다.
		 * 반환하는 데이터의 기본 형태는 text/plain이다.
		 * */
		
		String message = request.getParameter("message");
		
		response.setCharacterEncoding("UTF-8");
		
		System.out.println(message);
		
		PrintWriter out = response.getWriter();
		out.print("I'm Post! " + message);
		
		out.flush();
		out.close();
		
		
	}

}

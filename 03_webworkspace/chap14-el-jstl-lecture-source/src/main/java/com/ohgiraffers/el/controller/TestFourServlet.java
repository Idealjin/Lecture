package com.ohgiraffers.el.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ohgiraffers.el.model.dto.MemberDTO;


@WebServlet("/test4")
public class TestFourServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		MemberDTO requestMember = new MemberDTO("홍길동", 20, "010-1234-5678", "hong@ohgiraffers.com");
		MemberDTO sessionMember = new MemberDTO("유관순", 19, "010-5678-1234", "yu@ohgiraffers.com");
		
		HttpSession session = request.getSession();
		
		request.setAttribute("member", requestMember);
		session.setAttribute("member", sessionMember);
		
		RequestDispatcher rd = request.getRequestDispatcher("views/el/testEl4.jsp");
		rd.forward(request, response);
		
	}

}

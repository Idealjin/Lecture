package com.ohgiraffers.el.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ohgiraffers.el.model.dto.MemberDTO;

@WebServlet("/test2")
public class TestTwoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MemberDTO member = new MemberDTO("홍길동", 20, "010-1234-5678", "hong@ohgiraffers.com");
		
		request.setAttribute("member", member);
		
		RequestDispatcher rd = request.getRequestDispatcher("views/el/testEl2.jsp");
		rd.forward(request, response);
		
	}

}

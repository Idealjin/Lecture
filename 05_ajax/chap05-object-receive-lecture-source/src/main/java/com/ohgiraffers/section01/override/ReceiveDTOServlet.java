package com.ohgiraffers.section01.override;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ohgiraffers.model.dto.MemberDTO;

@WebServlet("/receive/override")
public class ReceiveDTOServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		MemberDTO member = new MemberDTO("get", "gildong", "hong", 20);
		
		System.out.println(member);
		
		response.setContentType("application/json; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		out.print(member);
		out.flush();
		out.close();
		
	}

}

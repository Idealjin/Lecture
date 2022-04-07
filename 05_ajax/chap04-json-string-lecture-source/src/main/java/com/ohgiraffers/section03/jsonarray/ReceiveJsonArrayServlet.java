package com.ohgiraffers.section03.jsonarray;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/receive/jsonarray")
public class ReceiveJsonArrayServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//응답헤더의 content-type 설정을 application/json으로 지
		response.setContentType("application/json");
		
		PrintWriter out = response.getWriter();
		out.print("[{\"type\":\"get\",\"firstname\":\"gildong\",\"lastname\":\"hong\",\"age\":20},"
	              + "{\"type\":\"get\",\"firstname\":\"gwansoon\",\"lastname\":\"yoo\",\"age\":16},"
	              + "{\"type\":\"get\",\"firstname\":\"soonsin\",\"lastname\":\"lee\",\"age\":40},"
	              + "{\"type\":\"get\",\"firstname\":\"bonggil\",\"lastname\":\"yoon\",\"age\":34}]");
		out.flush();
		out.close();
		
	}

}

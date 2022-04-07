package com.ohgiraffers.section01.jsonstring;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/receive/array")
public class RecieveArrayServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/* Json으로 javaScript object로 변환시키기 위해서는 array의 경우 대괄호로 []감싸고, 각 인덱스의 구분은 ,로 한다.*/
		
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		out.print("[{\"type\":\"get\",\"firstname\":\"gildong\",\"lastname\":\"hong\",\"age\":20},"
	              + "{\"type\":\"get\",\"firstname\":\"gwansoon\",\"lastname\":\"yoo\",\"age\":16},"
	              + "{\"type\":\"get\",\"firstname\":\"soonsin\",\"lastname\":\"lee\",\"age\":40},"
	              + "{\"type\":\"get\",\"firstname\":\"bonggil\",\"lastname\":\"yoon\",\"age\":34}]");
		
	}

}

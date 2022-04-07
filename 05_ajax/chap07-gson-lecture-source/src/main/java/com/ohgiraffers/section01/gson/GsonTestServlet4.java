package com.ohgiraffers.section01.gson;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@WebServlet("/gson/test4")
public class GsonTestServlet4 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jsonString = request.getParameter("jsonString");
		System.out.println(jsonString);
		
		Gson gson = new GsonBuilder().setDateFormat("yyyy/MM/dd").create();
		// 날짜의 경우 값을 자동으로 역직렬화 할 수 없데 된다.
		//GsonBuilder()를 이용하여 setDateFormat()메소드를 이용할 수 있다.
		
		//Gson gson = new GsonBuilder().setDateFormat("yyyy/MM/dd").create();
		
		String dateTest = gson.toJson(new java.sql.Date(System.currentTimeMillis()));
		System.out.println(dateTest);
		
		MemberDTO member = gson.fromJson(jsonString, MemberDTO.class);
		System.out.println(member);
		

		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.print(member);
		out.flush();
		out.close();
		
		
		
	}

}

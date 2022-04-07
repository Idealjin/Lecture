package com.ohgiraffers.section01.gson;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@WebServlet("/gson/test5")
public class GsonTestServlet5 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MemberDTO member = new MemberDTO("MO1", "길동", "<h1>홍</h1>", 20, new java.sql.Date(System.currentTimeMillis()));
		
		Gson gson = new GsonBuilder()
				.setDateFormat("yyyy-mm-dd hh:mm:ss:SSS")
				.setPrettyPrinting() 				//json문자열을 이쁘게 출력
//				.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_DASHES) //필드 이름으로 json key값 네이밍 설정할 떄 사용하는 옵션
				.setFieldNamingPolicy(FieldNamingPolicy.IDENTITY) //기본
				.serializeNulls()			//필드값이 null이어도 직렬화한다.
				.create();
		
		String jsonString = gson.toJson(member);
		System.out.println(jsonString);
		
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.print(member);
		out.flush();
		out.close();
		
	}

}

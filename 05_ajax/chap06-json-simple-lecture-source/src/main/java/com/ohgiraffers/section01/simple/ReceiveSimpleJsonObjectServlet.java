package com.ohgiraffers.section01.simple;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.ohgiraffers.model.dto.MemberDTO;

@WebServlet("/receive/simple")
public class ReceiveSimpleJsonObjectServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		MemberDTO member = new MemberDTO("MO1","gildong","hong", 20);
		
		JSONObject json = new JSONObject();
		
		json.put("code", member.getCode());
		json.put("firstname", member.getFirstName());
		json.put("lastname", member.getLastName());
		json.put("age", member.getAge());
	
			System.out.println(json.toJSONString());
		
			response.setContentType("application/json; charset=utf-8");
			PrintWriter out = response.getWriter();
			
			out.print(response.getWriter());
			out.flush();
			out.close();
	}
	

}

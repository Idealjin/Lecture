package com.ohgiraffers.section02.array;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.ohgiraffers.model.dto.MemberDTO;


@WebServlet("/receive/array")
public class ReceiveJsonArrayServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MemberDTO member1 = new MemberDTO("MO1","길동","홍", 20);
		MemberDTO member2 = new MemberDTO("MO2","순신","이", 43);
		MemberDTO member3 = new MemberDTO("MO3","관순","유", 16);
		MemberDTO member4 = new MemberDTO("MO4","봉길","윤", 33);
	
		List<MemberDTO> memberList = new ArrayList<>();
		memberList.add(member1);
		memberList.add(member2);
		memberList.add(member3);
		memberList.add(member4);
		
		JSONArray jsonArray = new JSONArray();
		for(MemberDTO member : memberList) {
			JSONObject json = new JSONObject();
			json.put("code", member.getCode());
			json.put("firstname", member.getFirstName());
			json.put("lastname", member.getLastName());
			json.put("age", member.getAge());
			
			jsonArray.add(json);
		}
		System.out.println(jsonArray.toJSONString());
		
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.print(jsonArray.toJSONString());
		out.flush();
		out.close();
		
		
		
		
	}

}

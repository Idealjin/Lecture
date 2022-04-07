package com.ohgiraffers.section02.list;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ohgiraffers.model.dto.MemberDTO;

@WebServlet("/receive/list")
public class ReceiveListServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MemberDTO member1 =new MemberDTO("get", "gildong", "hong", 20);
		MemberDTO member2 =new MemberDTO("get", "soonsin", "lee", 43);
		MemberDTO member3 =new MemberDTO("get", "gwansun", "yu", 16);
		MemberDTO member4 =new MemberDTO("get", "bonggil", "yoon", 33);
		
		List<MemberDTO> memberList = new ArrayList<>();
		memberList.add(member1);
		memberList.add(member2);
		memberList.add(member3);
		memberList.add(member4);
		
		System.out.println(memberList);
		
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.print(memberList);
		out.flush();
		out.close();
		
		
		
	}

}

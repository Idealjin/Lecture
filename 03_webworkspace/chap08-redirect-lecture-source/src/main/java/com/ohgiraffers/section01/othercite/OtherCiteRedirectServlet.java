package com.ohgiraffers.section01.othercite;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/othercite")
public class OtherCiteRedirectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public OtherCiteRedirectServlet() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("get 요청후 naver사이트로 redirect");
		
		/* 사용자 url 재작성이라고 불리는 redirect방식은 302번 응답 코드인 경우 요청에 대한 처리를 잘 하였고,
		 * 사용자의 url을 강제로 redirect 경로로 이동을 시키라는 의미
		 */
		response.sendRedirect("http://www.naver.com");
	}

}

package com.ohgiraffers.section01.exception;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/show404error")
public class Show404ErrorSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Show404ErrorSevlet() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.sendError(404, "페이지를 찾을 수 없습니다.");
		
		
	}

}

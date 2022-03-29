package com.ohgiraffers.section01.exception;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.core.ApplicationMappingImpl;

@WebServlet("/showErrorPage")
public class ExceptionHandlerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public ExceptionHandlerServlet() {
        super();
     
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*
		javax.servlet.forward.request_uri
		javax.servlet.forward.context_path
		javax.servlet.forward.servlet_path
		javax.servlet.forward.mapping
		javax.servlet.error.status_code
		javax.servlet.error.message
		javax.servlet.error.servlet_name
		javax.servlet.error.request_uri
		*/
		
		Enumeration<String> attrName = request.getAttributeNames();
		while(attrName.hasMoreElements()) {
			System.out.println(attrName.nextElement());
		}
		
		String forwardRequestURI = (String) request.getAttribute("javax.servlet.forward.request_uri");
		String contextPath = (String) request.getAttribute("javax.servlet.forward.context_path");
		String servletPath = (String) request.getAttribute("javax.servlet.forward.servlet_path");
		ApplicationMappingImpl mapping = (ApplicationMappingImpl) request.getAttribute("javax.servlet.forward.mapping");
		Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
		String message = (String) request.getAttribute("javax.servlet.error.message");
		String servletName = (String) request.getAttribute("javax.servlet.error.servlet_name");
		String requestURI = (String) request.getAttribute("javax.servlet.error.request_uri");
		
		
		System.out.println(forwardRequestURI);
		System.out.println(contextPath);
		System.out.println(servletPath);
		System.out.println(mapping);
		System.out.println(mapping.getServletName());
		System.out.println(mapping.getMatchValue());
		System.out.println(mapping.getPattern());
		System.out.println(mapping.getMappingMatch());
		System.out.println(statusCode);
		System.out.println(message);
		System.out.println(servletName);
		System.out.println(requestURI);
		
		//아래처럼 에러페이지를 생성해주기
		
		StringBuilder errorPage = new StringBuilder();
		errorPage.append("<!doctype html>\n")
				 .append("<html>\n")
				 .append("<head>\n")
				 .append("</head>\n")
				 .append("<body>\n")
				 .append("<h1 align=\"center\">")
				 .append(statusCode)
				 .append(" = ")
				 .append(message)
				 .append("</body>\n")
				 .append("</html>\n");
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.print(errorPage.toString());
		
		out.flush();
		out.close();
	}

}

package com.ohgiraffers.section01.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


@WebFilter("/first/*")
public class FirstFilter implements Filter {

   
    public FirstFilter() {
      // 기본 생성자, 필터는 톰캣을 start할 시점부터 인스턴스를 미리 생성한다.
      System.out.println("FirstFilter 인스턴스 생성!");
    }

	
	public void destroy() {
		//필터 인스턴스가 소멸될 때 호출되는 메소드(톰캣 종료시)
		System.out.println("FirstFilter destroy 호출");
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//servlet으로 request가 전달되기 전에 요청을 가로채는 역할을 하는 메소드
		System.out.println("filter doFilter 호출");
		
		//뭔가 처리하기 위해선 여기에코드를 작성한다
		chain.doFilter(request, response);
		
		System.out.println("서블릿 요청처리 완료!");
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("filter init 호출");
	}

}

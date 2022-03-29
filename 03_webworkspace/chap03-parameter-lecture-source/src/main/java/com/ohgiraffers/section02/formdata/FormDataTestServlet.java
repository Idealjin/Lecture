package com.ohgiraffers.section02.formdata;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/formdata")
public class FormDataTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public FormDataTestServlet() {
        super();
        
    }
    
    /* POST 방식으로 전달받은 데이터에 한글이 있는 경우에는 한글이 깨지게 된다.
     * GET 방식의 데이터는 HTML charset에 기술된 인코딩 방식으로 브라우저가 한글을 이해한 뒤 
     * %문자로 URL인코더를 이용해서 변환 url 요청으로 전송한다.
     * 
     * GET 요청은 보통 서버쪽 리소스를 가져오는용도의 행위를 요청하는 http 요청방식 이기에 별도의 데이터가필요없어서
     * 요청 본문은 해석하지 않게 된다.
     * 
     * 하지만 POST요청은 서버쪽 리소스에 내용을 추가하는 용도의 용청이기 때문에 요청하는 데이터가 필요한 경우가 많다.
     * 이러한 자바쪽 리소스에 추가해야 하는 정보를 본문(페이로드)에 Key&Value 방식으로 담아 전송을 하는데,
     * 헤더와는 별개로 URLENcoder를 이용하지 않고,
     * 페이지 meta에 기술된 cahrset에 따라 UTF-8로 해석된 데이터를 서버로 전송하게 된다.
     * */
    
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//기본 설정된 인코딩 방식이 null이기 때문에톰캣이 기본 세팅값인 ISO-8859-1fh 디코딩을 하게된다.
		System.out.println(request.getCharacterEncoding());
		
		//파라미터값을 꺼내기 전에 디코딩할 인코딩 방식을 설정해준다.
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		System.out.println("name : " + name);
		
		//인코딩을 제외한 나머지 들은 GET방식에서 값을 꺼내는 것과 동일하다.
		Map<String,String[]> requestMap = request.getParameterMap();
		Set<String> keySet = requestMap.keySet();
		Iterator<String> keyIter = keySet.iterator();
		
		while(keyIter.hasNext()) {
			String key = keyIter.next();
			String[] value = requestMap.get(key);
			
			System.out.println("key : " + key);
			for(int i =0; i < value.length; i++) {
				System.out.println("value[" + i + "] : " + value[i]);
			}
		}
		
		//파라미터로 전달된 키 목록만도 확인 가능하다.
		// request.getParameterNames()를 이용한다.
	    Enumeration<String> names = request.getParameterNames();
		while(names.hasMoreElements()) {
			System.out.println(names.nextElement());
		}
		
	}

}

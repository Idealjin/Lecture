package com.ohgiraffers.section01.fieldInjection.javaconfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository("bookDao")
public class BookDAOImpl implements BookDAO{

	private Map<Integer, BookDTO> bookList;

	public BookDAOImpl() {
		bookList = new HashMap<>();
		bookList.put(1, new BookDTO(1, 123456, "자바의정석","남궁성", "도우출판", new java.util.Date()));
		bookList.put(2, new BookDTO(2, 432423, "수학의정석","홍성대", "도넛출판", new java.util.Date()));
		bookList.put(3, new BookDTO(3, 345234, "칭찬은 고래도 춤추게한다.","고래", "홍대출판", new java.util.Date()));
	}
	
	/**
	 *<pre>
	 * 도서 정보 전체 조회용 메소드
	 *</pre>
	 */
	@Override
	public List<BookDTO> selectBookList() {
		
		return new ArrayList<BookDTO>(bookList.values());
	}

	/**
	 *<pre>
	 * 도서 번호에 해당하는 BookDTO타입의 객체를 리턴
	 *</pre>
	 */
	@Override
	public BookDTO selectOneBook(int sequence) {

		return bookList.get(sequence);
	}

}

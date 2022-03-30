package com.ohgiraffers.section01.fieldInjection.javaconfig;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/* 스프링 컨테이너에서 관리하는 bean으로 등록하기 위한 어노테이션으로 Service계층에서는
 * @Service를 사용한다.
 * */
@Service
public class BookService {

	@Autowired
	private BookDAO bookDao;  //필드 주입

	public BookService(BookDAO bookDao) {
		super();
		this.bookDao = bookDao;
	}
	
	public List<BookDTO> selectAllBooks(){
		return bookDao.selectBookList();
	}
	
	public BookDTO searchBookBySequence(int sequence) {
		return bookDao.selectOneBook(sequence);
	}
	
	
}

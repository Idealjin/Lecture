package com.ohgiraffers.section02.service.model.service;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.commit;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;
import static com.ohgiraffers.common.JDBCTemplate.rollback;

import java.sql.Connection;

import com.ohgiraffers.section02.service.model.dao.MenuDAO;
import com.ohgiraffers.section02.service.model.dto.CategoryDTO;
import com.ohgiraffers.section02.service.model.dto.MenuDTO;

public class MenuService {

	
	/**
	 * 신규 메뉴 등록용 서비스 메소드
	 */
	public void registNewMenu() {
		//1. Connection 생성
		Connection con = getConnection();
		
		//2, DAO 메소드 생성
		MenuDAO menuDAO = new MenuDAO();
		
		//2-1 카테고리 등록
		CategoryDTO newCategory = new CategoryDTO();
		newCategory.setName("기타");
		newCategory.setRefCategoryCode(null);
		
		int result1 = menuDAO.insertNewCategory(con, newCategory);
		
		//방금 입력한 마지막 카테고리 번호 조회
		int newCategoryCode = menuDAO.selectlLastCategoryCode(con);
		
		//2-2 메뉴 등록
		MenuDTO newMenu = new MenuDTO();
		newMenu.setName("메롱메롱스튜");
		newMenu.setPrice(40000);
		newMenu.setCategoryCode(newCategoryCode);
		newMenu.setOrderableStatus("Y");
		
		int result2 = menuDAO.insertNewMenu(con, newMenu);
		
		//3. 트랜젝션 제어
		if(result1 > 0 && result2 > 0) {
			System.out.println("신규 카테고리와 메뉴를 추가하였습니다.");
			commit(con);
		} else {
			System.out.println("신규 카테고리와 메뉴를 추가하지 못하였습니다.");
			rollback(con);
		}
		
		//4. Connection 반납
		close(con);
		
	}
	
}

package com.ohgiraffers.section01.xmlconfig;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import static com.ohgiraffers.section01.xmlconfig.Template.getSqlSession;

public class MenuService {

	private final MenuDAO menuDAO;
	
	public MenuService() {
		menuDAO = new MenuDAO();
	}
	
	
	public List<MenuDTO> selectAllMenu(){
		
		SqlSession sqlSession = getSqlSession();					//커넥션 생성
		List<MenuDTO> menuList = menuDAO.selectAllMenu(sqlSession); 
		
		sqlSession.close();
		
		
		return menuList;
	}


	public MenuDTO selectMenuByCode(int code) {
		
		SqlSession sqlSession = getSqlSession();
		
		MenuDTO menu = menuDAO.selectMenuByCode(sqlSession, code);
		
		sqlSession.close();
		
		return menu;
	}


	public boolean registMenu(MenuDTO menu) {
		
		SqlSession sqlSession = getSqlSession();
		
		int result = menuDAO.insertMenu(sqlSession, menu);
		
		// insert, update, delete 일 경우 트랜젝션 처리 까먹지 말자
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result > 0? true : false;
	}


	public boolean updateMenuByCode(MenuDTO menu) {
		
		SqlSession sqlSession = getSqlSession();
		
		int result = menuDAO.updateMenu(sqlSession, menu);
		
		// insert, update, delete 일 경우 트랜젝션 처리 까먹지 말자
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result > 0? true : false;
	}


	public boolean deleteMenuByCode(MenuDTO menu) {
		
		SqlSession sqlSession = getSqlSession();
		
		int result = menuDAO.deleteMenu(sqlSession, menu);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result > 0? true : false;
	}
	
}

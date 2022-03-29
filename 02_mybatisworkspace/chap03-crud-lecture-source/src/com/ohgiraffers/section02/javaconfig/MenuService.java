package com.ohgiraffers.section02.javaconfig;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import static com.ohgiraffers.section02.javaconfig.Template.getSqlSession;

public class MenuService {

	private MenuMapper menuMapper;
	
	public List<MenuDTO> selectAllMenu(){
		
		SqlSession sqlSession = getSqlSession();					//커넥션 생성
		
		menuMapper = sqlSession.getMapper(MenuMapper.class);
		// SqlSession은 요청 단위 생성이다. 따라서 getMapper로 메소드 스코프로 매번 불러와야한다.
		List<MenuDTO> menuList = menuMapper.selectAllMenu(); 
		
		sqlSession.close();
		
		
		return menuList;
	}


	public MenuDTO selectMenuByCode(int code) {
		
		SqlSession sqlSession = getSqlSession();
		
		menuMapper = sqlSession.getMapper(MenuMapper.class);
		
		MenuDTO menu = menuMapper.selectMenuByCode(code);
		
		sqlSession.close();
		
		return menu;
	}


	public boolean registMenu(MenuDTO menu) {
		
		SqlSession sqlSession = getSqlSession();
		
		menuMapper = sqlSession.getMapper(MenuMapper.class);
		int result = menuMapper.insertMenu(menu);
		
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
		
		menuMapper = sqlSession.getMapper(MenuMapper.class);
		int result = menuMapper.updateMenu(menu);
		
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
		
		menuMapper = sqlSession.getMapper(MenuMapper.class);
		int result = menuMapper.deleteMenu(menu);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result > 0? true : false;
	}
	
}

package com.ohgiraffers.section03.remix;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import static com.ohgiraffers.section03.remix.Template.getSqlSession;

public class MenuService {

	
	
	public List<MenuDTO> selectAllMenu(){
		
		SqlSession sqlSession = getSqlSession();					//커넥션 생성
		
		MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
		List<MenuDTO> menuList = menuMapper.selectAllMenu();
		
		sqlSession.close();
		
		
		return menuList;
	}


	public MenuDTO selectMenuByCode(int code) {
		
		SqlSession sqlSession = getSqlSession();
		
		MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
		MenuDTO menu = menuMapper.selectMenuByCode(code);
		
		sqlSession.close();
		
		return menu;
	}


	public boolean registMenu(MenuDTO menu) {
		
		SqlSession sqlSession = getSqlSession();
		
		MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
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
		
		MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
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
		
		MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
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

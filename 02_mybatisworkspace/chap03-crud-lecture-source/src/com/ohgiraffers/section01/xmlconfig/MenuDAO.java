package com.ohgiraffers.section01.xmlconfig;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class MenuDAO {

	public List<MenuDTO> selectAllMenu(SqlSession sqlSession) {
									//Mapper의 namespace명.쿼리문의id
		return sqlSession.selectList("MenuMapper.selectAllMenu");
	}

	public MenuDTO selectMenuByCode(SqlSession sqlSession, int code) {
		
		return sqlSession.selectOne("MenuMapper.selectMenuByCode", code);
	}

	public int insertMenu(SqlSession sqlSession, MenuDTO menu) {
		
		return sqlSession.insert("MenuMapper.insertMenu", menu);
	}

	public int updateMenu(SqlSession sqlSession, MenuDTO menu) {
		
		return sqlSession.update("MenuMapper.updateMenu", menu);
	}

	public int deleteMenu(SqlSession sqlSession, MenuDTO menu) {
		
		return sqlSession.delete("MenuMapper.deleteMenu", menu);
	}
	
	

}

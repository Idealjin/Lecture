package com.ohgiraffers.mvc.common.mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.ohgiraffers.mvc.common.config.ConfigLocation;

public class Template {

	private static SqlSessionFactory sqlSessionFactory;
	
	public static SqlSession getSqlSession() {
		
		if(sqlSessionFactory == null) {
			String resouce = ConfigLocation.mybatisConfigLocation;
			
			try {
				InputStream inputStream = Resources.getResourceAsStream(resouce);
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		SqlSession sqlSession = sqlSessionFactory.openSession(false);
		
		return sqlSession;
		
	}
}

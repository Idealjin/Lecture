package com.ohgiraffers.section03.remix;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

public class Template {

	private static String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static String URL = "jdbc:log4jdbc:oracle:thin:@oracle_high?TNS_ADMIN=/Volumes/SSDONE/창고/하이미디어/백엔드/Wallet_oracle";
	private static String USER = "OHGIRAFFERS";
	private static String PASSWORD = "OHGi12341234";
	
	
	private static SqlSessionFactory sqlSessionFactory;
	
	public static SqlSession getSqlSession() {
		
		if(sqlSessionFactory == null) {
			
			
			Environment environment =
					new Environment( "dev"
							, new JdbcTransactionFactory()
							, new PooledDataSource(DRIVER, URL, USER, PASSWORD));
			
			Configuration configuration = new Configuration(environment);
			
			configuration.addMapper(MenuMapper.class);
			
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
			
		}
		
		//SqlSession은 요청 시 마다 생성해야한다.
		
		return  sqlSessionFactory.openSession(false);
		
	}
	
	
}
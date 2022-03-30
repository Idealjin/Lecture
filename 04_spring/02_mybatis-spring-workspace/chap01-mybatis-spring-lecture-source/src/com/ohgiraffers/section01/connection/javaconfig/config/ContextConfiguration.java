package com.ohgiraffers.section01.connection.javaconfig.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Configuration
@ComponentScan("com.ohgiraffers.section01.connection.javaconfig")
@PropertySource("connection-info.properties")
public class ContextConfiguration {

	@Value("${oracle.dev.driver:oracle.jdbc.driver.OracleDriver}")
	private String driver;
	@Value("${oracle.dev.url:jdbc:log4jdbc:oracle:thin:@oracle_high?TNS_ADMIN=/Volumes/SSDONE/Space/himedia/dev/00_installFiles/Wallet_oracle}")
	private String url;
	@Value("${oracle.dev.username:OHGIRAFFERS}")
	private String username;
	@Value("${oracle.dev.password:OHGi12341234}")
	private String password;
//	
//	driver=oracle.jdbc.driver.OracleDriver
//			url=jdbc:log4jdbc:oracle:thin:@oracle_high?TNS_ADMIN=/Volumes/SSDONE/Space/himedia/dev/00_installFiles/Wallet_oracle
//			username=OHGIRAFFERS
//			password=OHGi12341234
	
	
	@Bean(destroyMethod = "close")
	public BasicDataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
	
		// 1. 값을 명시적으로 다쓰는 방법
//		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
//		dataSource.setUrl("jdbc:log4jdbc:oracle:thin:@cheoho.iptime.org:1521:xe");
//		dataSource.setUsername("C##OHGIRAFFERS");
//		dataSource.setPassword("OHGIRAFFERS");
		
		dataSource.setDriverClassName(driver);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		dataSource.setDefaultAutoCommit(false); //수동커밋을 위한설정
				
		
				
		return dataSource;

	}
	
	@Bean
	public SqlSessionFactory sqlSessionFactory(ApplicationContext context) throws Exception {
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setDataSource(dataSource());
		factoryBean.setConfigLocation(context.getResource("com/ohgiraffers/section01/connection/javaconfig/config/mybatis-config.xml"));
		return factoryBean.getObject();
	}
	
	@Bean
	public SqlSessionTemplate sqlSessionTemplate(ApplicationContext context) throws Exception {
		//spring-jdbc
		//spring-dao 라이브러리 추가
		return new SqlSessionTemplate(sqlSessionFactory(context));
	}
	
}

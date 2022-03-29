package com.ohgiraffers.section02.template;

import static com.ohgiraffers.section02.template.JDBCTemplate.close;
import static com.ohgiraffers.section02.template.JDBCTemplate.getConnection;

import java.sql.Connection;
//import static com.ohgiraffers.section02.template.JDBCTemplate.getConnection;


public class Application {

	public static void main(String[] args) {
		
		//Connection con = JDBCTemplate.getConnection();  //이렇게 하거나 위에 임포트하는 방법이 있다. + 설정 -> editer -> conten 에서 JDBCTEMPLATE 추
		Connection con = getConnection();
	
		System.out.println(con);
		
		close(con);
	}
	
	
}

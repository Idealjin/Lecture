package com.ohgiraffers.section01.statement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static com.ohgiraffers.common.JDBCTemplate.getConnection;
import static com.ohgiraffers.common.JDBCTemplate.close;

public class Application1 {

	public static void main(String[] args) {
		
		Connection con = getConnection();

		//쿼리문을 저장하고 실행하는 기능을 하는 용도의 인터페이스
		Statement stmt = null; 
		// select 결과집합을 받아 올 용도의 인터페이스
		ResultSet rset = null;
		
		try {
			//connection을 이용하여 statement 인스턴스 생성
			stmt = con.createStatement();
			
			rset = stmt.executeQuery("SELECT EMP_ID, EMP_NAME FROM EMPLOYEE1");
			
			while(rset.next()) {
				System.out.println(rset.getString("EMP_ID") + ", " + rset.getString("EMP_NAME"));
			}
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
			close(con);
			
		}
		
	}
	
}

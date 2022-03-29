package com.ohgiraffers.section01.statement;

import static com.ohgiraffers.common.JDBCTemplate.getConnection;
import static com.ohgiraffers.common.JDBCTemplate.close;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Application2 {
public static void main(String[] args) {
	
	// 1. Connection 생성
	Connection con = getConnection();
	// 2.  Statement 생성
	Statement stmt = null;
	
	// 3. ResultSet 생성
	ResultSet rset = null;
	
	try {
		stmt = con.createStatement();
		
		String empId = "200";
		String query = "Select EMP_ID, EMP_NAME FROM EMPLOYEE WHERE EMP_ID = '" + empId + "'";
		
		System.out.println(query);
		// 5. executeQuery로 쿼리문 실행하고 결과를 ResultSet으로 반환 받는다.
		rset = stmt.executeQuery(query);
		//6. ResultSet에 담긴 결과물을 컬럼 이름을 이용해 꺼내오기
		if(rset.next()) {
			//next() : ResultSet의 커서 위치를 하나 내리면서 행이 존재허면 true 존재하지 않으면 false를 반환
			System.out.println(rset.getString("EMP_ID") + ", " + rset.getString("EMP_NAME"));
		}
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		//7, 사용한 자원반납
		close(rset);
		close(stmt);
		close(con);
	}
	
	
	
	
 }
}
package com.ohgiraffers.section03.sqlinjection;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Application4 {

	private static String empId ="200";
	private static String empName = "'||'' OR 1=1 AND EMP_ID = '200'||'";

	
	public static void main(String[] args) {
		
		Connection con = getConnection();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "SELECT * FROM EMPLOYEE WHERE EMP_ID = ? AND EMP_NAME = ?";
		
		System.out.println(query);
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, empId);
			pstmt.setString(2, empName);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				System.out.println(rset.getString("EMP_NAME") + "님 환영합니다.");
			} else {
				System.out.println("회원 정보가 없습니다.");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
			close(con);
		}
		
		
	}
	
}

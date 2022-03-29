package com.ohgiraffers.section01.transaction;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.commit;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;
import static com.ohgiraffers.common.JDBCTemplate.rollback;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

public class Application3 {
	public static void main(String[] args) {
		
		//트랜젝션 : 한꺼번에 수행되어야할 최소의 작업 단위
		
		Connection con = getConnection();
		
		try {
			System.out.println("autoCommit의 현재 설정 값 : " + con.getAutoCommit());
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		PreparedStatement pstmt = null;
		int result = 0;
		Properties prop = new Properties();
		
		try {
			prop.loadFromXML(new FileInputStream("mapper/menu-query.xml"));
			
			String query = prop.getProperty("insertMenu");
			
			System.out.println(query);
			
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, "꽁치엑기스");
			pstmt.setInt(2, 40000);
			pstmt.setInt(3, 2);
			pstmt.setString(4, "Y");
			
			result = pstmt.executeUpdate();
			
			System.out.println(result);
			
			if(result > 0) {
				System.out.println(" 메뉴 등록 성공!");
				commit(con);
			}else {
				System.out.println(" 메뉴 등록 실패!");
				rollback(con);
			}
			
			
		} catch (InvalidPropertiesFormatException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(con);
			
		}
		
		
	}
}

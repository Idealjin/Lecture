package com.ohgiraffers.section01.insert;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

public class Application1 {
	public static void main(String[] args) {
		
		Connection con = getConnection();
		
		PreparedStatement pstmt = null;
		int result = 0;
		//INSERT에서는 REsultSet이 아니라 인트값으로 받아준다.
		
		Properties prop = new Properties();
		
		try {
			prop.loadFromXML(new FileInputStream("mapper/menu-query.xml"));
			String query = prop.getProperty("insertMenu");
			
			System.out.println(query);
			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, "문어해장국");
			pstmt.setInt(2, 5000);
			pstmt.setInt(3, 1);
			pstmt.setString(4, "Y");
			
			result = pstmt.executeUpdate();
			//INSERT 시에는 익스큐트 업데이트를 사용한다.
			
			
			
			
		} catch (InvalidPropertiesFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(con);
		}
		System.out.println("result : " + result);
		//잘 실행되면 결과는 1로 나온다.
		
		
		
		
		
		
		
		
	}
}

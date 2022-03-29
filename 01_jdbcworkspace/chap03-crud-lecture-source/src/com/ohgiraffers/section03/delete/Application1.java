package com.ohgiraffers.section03.delete;

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
import java.util.Scanner;

import com.ohgiraffers.menuDTO.MenuDTO;

public class Application1 {
	public static void main(String[] args) {
		
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		int result = 0;
		
		Properties prop = new Properties();
		
		try {
			prop.loadFromXML(new FileInputStream("mapper/menu-query.xml"));
			String query = prop.getProperty("deleteMenu");
			
			System.out.println(query);
			
			Scanner sc = new Scanner(System.in);
			System.out.print("삭제할 메뉴 번호를 입력하세요 : ");
			int menuCode = sc.nextInt();
			
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, menuCode);
			
			result = pstmt.executeUpdate();
			
			
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
		
		if(result > 0) {
			System.out.println("메뉴 삭제 성공!");
		}else {
			System.out.println("메뉴 삭제 실패!");
		}
		
		
	}
}

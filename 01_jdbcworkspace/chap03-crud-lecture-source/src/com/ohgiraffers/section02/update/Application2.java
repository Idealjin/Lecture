package com.ohgiraffers.section02.update;

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

public class Application2 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("변경할 메뉴 번호를 입력하세요 : ");
		int menuCode = sc.nextInt();
		System.out.print("변경할 메뉴의 이름을 입력하세요. : ");
		sc.nextLine();
		String menuName = sc.nextLine();
		System.out.print("변경할 메뉴의 가격을 입력하세요. : ");
		int menuPrice = sc.nextInt();
		
		MenuDTO changeMenu = new MenuDTO();
		changeMenu.setCode(menuCode);
		changeMenu.setName(menuName);
		changeMenu.setPrice(menuPrice);
		
	Connection con = getConnection();
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		Properties prop = new Properties();
		
		try {
			prop.loadFromXML(new FileInputStream("mapper/menu-query.xml"));
			String query = prop.getProperty("updateMenu");
			
			System.out.println(query);
			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, changeMenu.getName());
			pstmt.setInt(2, changeMenu.getPrice());
			pstmt.setInt(3, changeMenu.getCode());
			
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
			System.out.println("메뉴 수정 성공");
		}else {
			System.out.println("메뉴 수정 실패");
		}
		
	}
		
}


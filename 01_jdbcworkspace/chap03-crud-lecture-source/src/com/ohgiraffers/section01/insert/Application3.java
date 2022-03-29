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
import java.util.Scanner;

import com.ohgiraffers.menuDTO.MenuDTO;


public class Application3 {
	
	
	public static void main(String[] args) {
		
		// 다른쩍 클래스에서 작성한다고 가정
		Scanner sc = new Scanner(System.in);
		System.out.print("메뉴의 이름을 입력하세요 : ");
		String menuName = sc.nextLine();
		System.out.print("메뉴의 가격을 입력하세요 : ");
		int menuPrice = sc.nextInt();
		System.out.print("카테고리 코드를 입력하세요 : ");
		int categoryCode = sc.nextInt();
		System.out.print("판매 여부를 결정해주세요 (Y/N) : ");
		sc.nextLine();
		String orderableStatus = sc.nextLine().toUpperCase();
		
		MenuDTO newMenu = new MenuDTO();
		newMenu.setName(menuName);
		newMenu.setPrice(menuPrice);
		newMenu.setCategoryCode(categoryCode);
		newMenu.setOrderableStatus(orderableStatus);
		
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		int result = 0;
		
		Properties prop = new Properties();
		
		try {
			prop.loadFromXML(new FileInputStream("mapper/menu-query.xml"));
			String query = prop.getProperty("insertMenu");
			
			System.out.println(query);
			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, newMenu.getName());
			pstmt.setInt(2, newMenu.getPrice());
			pstmt.setInt(3, newMenu.getCategoryCode());
			pstmt.setString(4, newMenu.getOrderableStatus());
			
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
			System.out.println("메뉴 등록 성공");
		} else {
			System.out.println("메뉴 등록 실패!");
		}
		
		
	}
	
}

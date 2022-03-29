package com.ohgiraffers.section02.service.model.dao;

import static com.ohgiraffers.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

import com.ohgiraffers.section02.service.model.dto.CategoryDTO;
import com.ohgiraffers.section02.service.model.dto.MenuDTO;

public class MenuDAO {

	
	private Properties prop = new Properties();
	
	public MenuDAO() {
		try {
			prop.loadFromXML(new FileInputStream("mapper/menu-query.xml"));
			
			
			
			
		} catch (InvalidPropertiesFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * <pre>
	 *  신규 카테고리 등록용 메소드
	 * </pre>
	 * 
	 * @param con 연결객체
	 * @param newCategory 등록할 카테고리 객체
	 * @return
	 */
	public int insertNewCategory(Connection con, CategoryDTO newCategory) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertCategory");
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, newCategory.getName());
			pstmt.setObject(2, newCategory.getRefCategoryCode());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int selectlLastCategoryCode(Connection con) {
		
		Statement stmt = null;
		ResultSet rset = null;
		int newCategoryCode = 0;
		
		String query = prop.getProperty("getCurrentSequence");
		
		try {
			stmt = con.createStatement();
			
			rset = stmt.executeQuery(query);
			
			if(rset.next()) {
				newCategoryCode = rset.getInt("CURRVAL");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		return newCategoryCode;
	}

	/**
	 * <pre>
	 *  신규 메뉴 등록용 메소드
	 * </pre>
	 * 
	 * @param con
	 * @param newMenu
	 * @return
	 */
	public int insertNewMenu(Connection con, MenuDTO newMenu) {
		PreparedStatement pstmt = null;
		String query = prop.getProperty("insertMenu");
		int result = 0;
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, newMenu.getName());
			pstmt.setInt(2, newMenu.getPrice());
			pstmt.setInt(3, newMenu.getCategoryCode());
			pstmt.setString(4, newMenu.getOrderableStatus());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		return result;
	}
	
	
	
}

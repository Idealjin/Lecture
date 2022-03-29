package com.ohgiraffers.section02.model.dao;

import static com.ohgiraffers.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InvalidPropertiesFormatException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.ohgiraffers.section02.model.dto.MenuDTO;


/* DAO ( Datebase Access Object ) : 데이터베이스 접근용 객체 
 * -> CRUD 연산을 담당하는 메소드들의 집함으로 이루어진 클래스
 * */

public class MenuDAO {

	private Properties prop = new Properties();
	
	public MenuDAO() {
		
		try {
			prop.loadFromXML(new FileInputStream("mapper/menu-query.xml"));
			
			
			
		} catch (InvalidPropertiesFormatException e) {
			
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	/**
	 * @param 
	 * @return
	 */
	public int selectLastMenuCode(Connection con) {
		Statement stmt = null;
		ResultSet rset = null;
		
		int maxMenuCode = 0;
		
		String query = prop.getProperty("selectLastMenuCode");
		
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);
			
			if(rset.next()) {
				maxMenuCode = rset.getInt("MAX(A.MENU_CODE)");	
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		return maxMenuCode;
	}

	public List<Map<Integer, String>> selectAllCategory(Connection con) {
		
		Statement stmt = null;
		ResultSet rset = null;
		
		List<Map<Integer, String>> categoryList = null;
		
		String query = prop.getProperty("selectAllCategoryList");
		
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);
			
			categoryList = new ArrayList<>();
			
			while(rset.next()) {
				java.util.Map<Integer, String> category = new HashMap<>();
				category.put(rset.getInt("CATEGORY_CODE"), rset.getString("CATEGORY_NAME"));
				
				categoryList.add(category);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return categoryList;
	}
	
	/**
	 * <pre>
	 * 메뉴를 넣어준다.
	 * </pre>
	 * @param con
	 * @param newMenu
	 * @return
	 */
	public int insertNewMenu(Connection con, MenuDTO newMenu) {
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		String query = prop.getProperty("insertMenu");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, newMenu.getCode());
			pstmt.setString(2, newMenu.getName());
			pstmt.setInt(3, newMenu.getPrice());
			pstmt.setInt(4, newMenu.getCategoryCode());
			pstmt.setString(5, newMenu.getOrderableStatus());
			
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

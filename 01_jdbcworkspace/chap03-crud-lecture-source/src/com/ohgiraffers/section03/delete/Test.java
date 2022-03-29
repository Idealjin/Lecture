package com.ohgiraffers.section03.delete;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {

	public static void main(String[] args) {
		
		Connection con = getConnection();
		Statement stmt = null;
		ResultSet rset = null;
		
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery("SELECT SYSDATE FROM DUAL");
			
			if(rset.next()) {
				System.out.println(rset.getDate(1));
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

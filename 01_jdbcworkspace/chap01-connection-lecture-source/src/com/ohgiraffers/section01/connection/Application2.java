package com.ohgiraffers.section01.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Application2 {
	public static void main(String[] args) {
		
	    String driver = "oracle.jdbc.OracleDriver";
		String url ="jdbc:oracle:thin:@oracle_high?TNS_ADMIN=/Volumes/SSDONE/Wallet_oracle";
	    String user="EMPLOYEE1";
	    String pwd ="PLOYEe12341234";
		
	    Connection con = null;
	    
	   try {
		Class.forName(driver);
		System.out.println("드라이버 로딩 성공");
		con = DriverManager.getConnection(url, user, pwd);
		System.out.println("연결성공");
	   } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
		if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	    
	    
	    
	}
}

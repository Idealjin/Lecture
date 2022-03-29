package com.ohgiraffers.section01.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Application1 {

	public static void main(String[] args) {
		
	String url ="jdbc:oracle:thin:@localhost:1521:xe";
	String userid="EMPLOYEE1";
	String pwd ="PLOYEe12341234";
	
	/* DB 접속을 위한 Connection 인스턴스 생성을 위한 레퍼런스 변수 선언
	 * 나중에 finally 블럭에서 사용하기 위해 try블럭 밖에서 선언한다.
	 * */ 
	Connection con = null;

	//사용할 드라이버를 등록
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("드라이버확인");
		try {
			con = DriverManager.getConnection(url, userid, pwd);
			//"jdbc:oracle:thin:@localhost:1521:xe"
			System.out.println("con : " + con);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

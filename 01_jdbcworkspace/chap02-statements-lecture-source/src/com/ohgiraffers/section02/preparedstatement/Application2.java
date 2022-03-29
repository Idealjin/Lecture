package com.ohgiraffers.section02.preparedstatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.ohgiraffers.common.JDBCTemplate.getConnection;
import static com.ohgiraffers.common.JDBCTemplate.close;

public class Application2 {
	public static void main(String[] args) {
		
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String empId = "200";
		try {
			pstmt = con.prepareStatement("SELECT EMP_ID, EMP_NAME FROM EMPLOYEE WHERE EMP_ID = ?");
			//위코드에서 ?를 위치홀더라고한다.
			pstmt.setString(1, empId);
			
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				System.out.println(rset.getString("EMP_ID") + ". " + rset.getString("EMP_NAME")); 
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
			close(con);
		}
		
	}
}

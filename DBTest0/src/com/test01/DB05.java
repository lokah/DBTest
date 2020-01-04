package com.test01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DB05 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "kh";
		String password = "kh";
		
		Connection con = DriverManager.getConnection(url, user, password);
		
		String sql = " DELETE FROM JDBCTEST " + " WHERE NO = 4 ";
		
		Statement stmt = con.createStatement();
		
		int res = stmt.executeUpdate(sql);
		
		if(res>0) {
			
			System.out.println("delete 성공");
		}else {
			
			System.out.println("delete 실패");
		}
		
		stmt.close();
		con.close();
	}

}

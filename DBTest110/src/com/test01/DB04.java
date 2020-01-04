package com.test01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB04 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

		Class.forName("oracle.jdbc.driver.OracleDriver");
		//2. 계정 연결
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "kh";
		String password = "kh";
		
		Connection con = DriverManager.getConnection(url, user, password); //java.sql패키지에 있다.
		
		
		//3. query 준비, 전달할 객체 필요
		Statement stmt = con.createStatement();
		String sql = " SELECT * FROM JDBCTEST ORDER BY NO DESC ";
		
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()) {
			
			System.out.printf("%d %s %s \n", rs.getInt(1), rs.getString(2), rs.getString(3));
			
		}
		
		rs.close();
		stmt.close();
		con.close();
	}

}

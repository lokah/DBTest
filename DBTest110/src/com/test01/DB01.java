package com.test01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB01 {

	//j db c
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//1. driver 연결 -ojdbc6.jar 꼭 추가!!!
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//2. 계정 연결
		
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String user = "scott";
		String password = "tiger";
		
		Connection con = DriverManager.getConnection(url, user, password); //java.sql패키지에 있다.
		
		
		//3. query 준비, 전달할 객체 필요
		Statement stmt = con.createStatement();
		String sql = " SELECT * FROM EMP ";
		
		
		
		//4. 실행 및 리턴
		
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()) {
			
			System.out.printf("%d %s %s %d %s %d %d %d \n", rs.getInt(1), rs.getString(2), rs.getString(3), 
					rs.getInt("MGR"), rs.getDate(5), rs.getInt(6), rs.getInt(7), rs.getInt("DEPTNO"));
		}
		
		//5. db 종료
		
		rs.close();
		stmt.close();
		con.close();
	}
	
}

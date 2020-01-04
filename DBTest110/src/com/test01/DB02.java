package com.test01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DB02 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String user = "scott";
		String password = "tiger";
		
		Connection con = DriverManager.getConnection(url, user, password);
		
		Statement stmt = con.createStatement();
		String sql = " SELECT DEPTNO, DNAME, LOC " + " FROM DEPT " + " WHERE DEPTNO = ";
		
		Scanner sc = new Scanner(System.in);
		System.out.println("부서를 선택해주세요(10/20/30/40)");
		int deptno = sc.nextInt();
		sql = sql + deptno;
		
		System.out.println(sql);
				
		
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()) {
		
			System.out.printf(rs.getInt(1) + "" + rs.getString(2)
					+ " " + rs.getString(3));
		}
		
		rs.close();
		stmt.close();
		con.close();
	}


}

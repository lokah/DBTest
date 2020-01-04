package com.test02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB01 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

		Class.forName("oracle.jdbc.driver.OracleDriver");

		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String user = "scott";
		String password = "tiger";

		Connection con = DriverManager.getConnection(url, user, password);

		Statement stmt = con.createStatement();
		String sql = " SELECT * FROM EMP ";

		ResultSet rs = stmt.executeQuery(sql);

		while (rs.next()) {

			System.out.printf("%d %s %s %d %s %d %d %d \n", rs.getInt(1), rs.getString(2), rs.getString(3),
					rs.getInt("MGR"), rs.getDate(5), rs.getInt(6), rs.getInt(7), rs.getInt("DEPTNO"));
		}
		
		rs.close();
		stmt.close();
		con.close();
	}

}

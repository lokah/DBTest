package com.test01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DB03 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

		//1. driver 연결 -ojdbc6.jar 꼭 추가!!!
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//2. 계정 연결
		
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String user = "scott";
		String password = "tiger";
		
		Connection con = DriverManager.getConnection(url, user, password); //java.sql패키지에 있다.
		
		
		//3. query 준비, 전달할 객체 필요
		Scanner sc = new Scanner(System.in);
		System.out.println("번호 입력: ");
		int no = sc.nextInt();
		System.out.println("이름 입력: ");
		String name = sc.next();
		System.out.println("별명 입력: ");
		String nickname = sc.next();
		
		//insert into jdbctest values(no, 'name', 'nickname');
		String sql = " INSERT INTO JDBCTEST " + " VALUES (" + no+ ",'"+ name + "','" + nickname + "')";
		
		
		
		Statement stmt = con.createStatement();
		//4 실행 및 리턴
		int res = stmt.executeUpdate(sql);
		if(res>0) {
			
			System.out.println("insert 성공");
		}else {
			System.out.println("insert 실패");
		}
		
		
		stmt.close();
		con.close();
	}

}

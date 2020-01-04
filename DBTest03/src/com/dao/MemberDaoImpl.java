package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
//디비하고 연결하는 역할
import com.dto.MemberDto;
import static com.db.JDBCTemplate.*; //대신에 MemberDaoImpl에서 extends JDBCTemplate로 상속받아도 된다.
public class MemberDaoImpl implements MemberDao {

	@Override
	public List<MemberDto> selectList() {
		
		Connection con = getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		
		List<MemberDto> list = new ArrayList<MemberDto>();
		
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(SELECT_LIST_SQL);
			while(rs.next()) {
				
				MemberDto dto = new MemberDto();
				dto.setNo(rs.getInt(1));
				dto.setName(rs.getString(2));
				dto.setAge(rs.getInt(3));
				dto.setGender(rs.getString(4));
				dto.setLocation(rs.getString(5));
				dto.setJob(rs.getString(6));
				dto.setTel(rs.getString(7));
				dto.setEmail(rs.getString(8));
				
				list.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("[ERROR] : 3, 4");
			e.printStackTrace();
		}finally {
			
			close(rs);
			close(stmt);
			close(con);
		}
		
		
		
		return list;
	}

	@Override
	public MemberDto selectOne(int no) {
		// TODO Auto-generated method stub
		
		Connection con = getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		
		MemberDto dto = new MemberDto();
		
		
		try {
			stmt = con.createStatement();
			
			rs = stmt.executeQuery(SELECT_ONE_SQL+no);
			while(rs.next()) {
				
				
				dto.setNo(rs.getInt(1));
				dto.setName(rs.getString(2));
				dto.setAge(rs.getInt(3));
				dto.setGender(rs.getString(4));
				dto.setLocation(rs.getString(5));
				dto.setJob(rs.getString(6));
				dto.setTel(rs.getString(7));
				dto.setEmail(rs.getString(8));
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("[ERROR] : 3, 4");
			e.printStackTrace();
		} finally {
			
			close(rs);
			close(stmt);
			close(con);
		}
		
		return dto;
	}

	@Override
	public int insert(MemberDto dto) {
		// TODO Auto-generated method stub
		
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		//쿼리 준비
		try {
			pstm = con.prepareStatement(INSERT_SQL);
			pstm.setInt(1, dto.getNo());
			pstm.setString(2, dto.getName());
			pstm.setInt(3, dto.getAge());
			pstm.setString(4, dto.getGender());
			pstm.setString(5, dto.getLocation());
			pstm.setString(6, dto.getJob());
			pstm.setString(7, dto.getTel());
			pstm.setString(8, dto.getEmail());
			//실행 및 리턴
			res = pstm.executeUpdate();
			if(res >0) {
				
				commit(con);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("[ERROR]: 3,4");
			e.printStackTrace();
		}finally {
			close(pstm);
			close(con);
		}
		
		
		return res;
	}

	@Override
	public int update(MemberDto dto1) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		
	
		
		
		try {
			pstm = con.prepareStatement(UPDATE_SQL);
			pstm.setString(1, dto1.getName());
			pstm.setString(2, dto1.getJob());
			pstm.setInt(3, dto1.getNo());
			
			res = pstm.executeUpdate();
			if(res>0) {
				
				commit(con);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("[ERROR] : 3, 4");
			e.printStackTrace();
		}finally {
		
		close(pstm);
		close(con);
	}
	return res;
		
		
		
	}

	@Override
	public int delete(int no) {
		// TODO Auto-generated method stub
		
		Connection con = getConnection();//1, 2번 완료
		PreparedStatement pstm = null;
		int res = 0;
		

		//커리 준비
		//MyDto dto = new MyDto();
		
		try {
			pstm = con.prepareStatement(DELETE_SQL);
			pstm.setInt(1, no);
			
			res = pstm.executeUpdate();
			if(res>0) {
				
				commit(con);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("[ERROR] : 3, 4");//에러 로그 라고 한다.logging 어느 부분이 틀린 곳인지 찾기 쉽게
			e.printStackTrace();
		}finally {
		
		close(pstm);
		close(con);
	}
	return res;
		
	}
	
	
	
	
}

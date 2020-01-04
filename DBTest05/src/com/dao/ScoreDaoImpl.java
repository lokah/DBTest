package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dto.ScoreDto;
import static com.db.JDBCTemplate.*;

public class ScoreDaoImpl implements ScoreDao {

	@Override
	public List<ScoreDto> selectList() {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		Statement stmt = null;// 쿼리문을 전달할 인스턴스
		ResultSet rs = null;

		List<ScoreDto> list = new ArrayList<ScoreDto>();

		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(SELECT_LIST_SQL);
			while (rs.next()) {
				ScoreDto dto = new ScoreDto();

				dto.setName(rs.getString(1));
				dto.setKor(rs.getInt(2));
				dto.setEng(rs.getInt(3));
				dto.setMath(rs.getInt(4));
				dto.setSum(rs.getInt(5));
				dto.setAvg(rs.getDouble(6));
				dto.setGrade(rs.getString(7));

				list.add(dto);

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

		return list;
	}

	@Override
	public ScoreDto selectOne(String name) {
		// TODO Auto-generated method stub

		Connection con = getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		ScoreDto dto = null; // 이렇게 null로 초기값을 잡아준 후에 콘트롤로에서 tmp !=null 로 하던지...

		// ScoreDto dto = new ScoreDto(); //이렇게 하면 tmp.getName() !=null로 한다.

		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(SELECT_ONE_SQL + "'" + name + "'");

			while (rs.next()) {
				dto = new ScoreDto();
				dto.setName(rs.getString(1));
				dto.setKor(rs.getInt(2));
				dto.setEng(rs.getInt(3));
				dto.setMath(rs.getInt(4));
				dto.setSum(rs.getInt(5));
				dto.setAvg(rs.getDouble(6));
				dto.setGrade(rs.getString(7));

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
	public int insert(ScoreDto dto) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;

		try {
			pstm = con.prepareStatement(INSERT_SQL);
			pstm.setString(1, dto.getName());
			pstm.setInt(2, dto.getKor());
			pstm.setInt(3, dto.getEng());
			pstm.setInt(4, dto.getMath());
			pstm.setInt(5, dto.getSum());
			pstm.setDouble(6, dto.getAvg());
			pstm.setString(7, dto.getGrade());

			res = pstm.executeUpdate();

			if (res > 0) {

				commit(con);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			close(pstm);
			close(con);
		}

		return res;
	}

	@Override
	public int update(ScoreDto dto) {
		// TODO Auto-generated method stub

		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;

		try {
			pstm = con.prepareStatement(UPDATE_SQL);
			pstm.setInt(1, dto.getKor());
			pstm.setInt(2, dto.getEng());
			pstm.setInt(3, dto.getMath());
			pstm.setInt(4, dto.getSum());
			pstm.setDouble(5, dto.getAvg());
			pstm.setString(6, dto.getGrade());
			pstm.setString(7, dto.getName());
			res = pstm.executeUpdate();
			if(res>0) {
				commit(con);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			close(pstm);
			close(con);
		}

		return res;
	}

	@Override
	public int delete(String name) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;

		try {
			pstm = con.prepareStatement(DELETE_SQL);
			pstm.setString(1, name);
			res = pstm.executeUpdate();
			if (res > 0) {
				commit(con);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstm);
			close(con);
		}
		return res;
	}
	
	public ScoreDto topNSelect(int n) {
		
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		ScoreDto dto = null;
		
		try {
			pstm = con.prepareStatement(TOP_N_SQL);
			
			pstm.setInt(1, n);
			rs = pstm.executeQuery();
					while(rs.next()) {
						dto = new ScoreDto();
						dto.setName(rs.getString(2));//1번은 rownum이기 때문에 2번이 name이다
					dto.setKor(rs.getInt(3));
					dto.setEng(rs.getInt(4));
					dto.setMath(rs.getInt(5));
					dto.setSum(rs.getInt(6));
					dto.setAvg(rs.getInt(7));
					dto.setGrade(rs.getString(8));
					
					
					}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstm);
			close(con);
		}
		
		
		return dto;
	}

}

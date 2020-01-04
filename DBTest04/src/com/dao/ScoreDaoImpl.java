package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import static com.db.JDBCTemplate.*;


import com.dto.ScoreDto;

public class ScoreDaoImpl implements ScoreDao {

	
		@Override
		public List<ScoreDto> scoreList() {
			
			Connection con = getConnection();
			Statement stmt = null;
			ResultSet rs = null;
			
			List<ScoreDto> list = new ArrayList<ScoreDto>();
			
			try {
				stmt = con.createStatement();
				rs = stmt.executeQuery(SELECT_LIST_SQL);
				while(rs.next()) {
					
					ScoreDto dto = new ScoreDto();
					dto.setNo(rs.getInt(1));
					dto.setName(rs.getString(2));
					dto.setKor(rs.getInt(3));
					dto.setEng(rs.getInt(4));
					dto.setMath(rs.getInt(5));
					dto.setSum(rs.getInt(6));
					dto.setAvg(rs.getInt(7));
					
					
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
	public ScoreDto scoreOne(int no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(ScoreDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(ScoreDto dto1) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int no) {
		// TODO Auto-generated method stub
		return 0;
	}

}

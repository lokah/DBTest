package com.dao;

import java.util.List;

import com.dto.ScoreDto;

public interface ScoreDao {

	String SELECT_LIST_SQL = " SELECT NO, NAME, KOR, ENG, MATH, SUM, AVG "
			+ " FROM SCORE ";

		String SELECT_ONE_SQL = " SELECT NO, NAME, KOR, ENG, MATH, SUM, AVG  "
				+ " FROM SCORE " + " WHERE NO = " ;
		String INSERT_SQL = " INSERT INTO SCORE VALUES(?, ?, ?,?,?,?,?) ";
		String UPDATE_SQL = " UPDATE SCORE SET KOR = ?, ENG= ? " + " WHERE NO = ? ";
		String DELETE_SQL = " DELETE FROM SCORE WHERE NO = ?";
	
	public List<ScoreDto> scoreList();
	public ScoreDto scoreOne(int no);
	public int insert(ScoreDto dto);
	public int update(ScoreDto dto1);
	public int delete(int no);
	
}

package com.dao;

import static com.db.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import com.dto.ScoreDto;

public interface ScoreDao {

	String SELECT_LIST_SQL = " SELECT NAME, KOR, ENG, MATH, SUM, AVG, GRADE " 
	+ " FROM SCORE ";
	String SELECT_ONE_SQL = " SELECT NAME, KOR, ENG,  MATH, SUM, AVG, GRADE " + " FROM SCORE " 
	+ " WHERE NAME =  " ;
	String INSERT_SQL = " INSERT INTO SCORE "
			+ " VALUES( ?, ?, ?, ?, ?, ?, ?) ";
	String UPDATE_SQL = " UPDATE SCORE SET KOR = ? , ENG = ? , MATH = ?, SUM = ?, AVG = ?, GRADE =? "
			+ " WHERE NAME = ? ";
	String DELETE_SQL = " DELETE FROM SCORE " + " WHERE NAME = ? ";
	
	String TOP_N_SQL = " SELECT * " + 
			" FROM " + 
			" (SELECT ROWNUM AS R, NAME, KOR, ENG, MATH, SUM, AVG, GRADE " + 
			" FROM " + 
			" (SELECT NAME, KOR,ENG,MATH,SUM,AVG,GRADE " + 
			" FROM SCORE " + 
			" ORDER BY AVG DESC) A)B " + 
			" WHERE R = ? ";
	
	public List<ScoreDto> selectList();
	public ScoreDto selectOne(String name);
	public int insert(ScoreDto dto);
	public int update(ScoreDto dto);
	public int delete(String name);
	
	public ScoreDto topNSelect(int n);
	
}

package com.dao;

import java.util.List;

import com.dto.MemberDto;

public interface MemberDao {
	
	String SELECT_LIST_SQL = " SELECT NO, NAME, AGE, GENDER, LOCATION, JOB, TEL, EMAIL "
			+ " FROM TB_MEMBER " + " ORDER BY NO DESC ";

		String SELECT_ONE_SQL = " SELECT NO, NAME, AGE, GENDER, LOCATION, JOB, TEL, EMAIL "
				+ " FROM TB_MEMBER " + " WHERE NO = " ;
		String INSERT_SQL = " INSERT INTO TB_MEMBER VALUES(?, ?, ?,?,?,?,?,?) ";
		String UPDATE_SQL = " UPDATE TB_MEMBER SET NAME = ?, JOB= ? " + " WHERE NO = ? ";
		String DELETE_SQL = " DELETE FROM TB_MEMBER WHERE NO = ?";
	
	
	public List<MemberDto> selectList();
	public MemberDto selectOne(int no);
	public int insert(MemberDto dto);
	public int update(MemberDto dto);
	public int delete(int no);
	
}

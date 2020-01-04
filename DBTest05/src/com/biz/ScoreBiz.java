package com.biz;

import java.util.List;

import com.dto.ScoreDto;

public interface ScoreBiz {

	
	public List<ScoreDto> selectList();
	public ScoreDto selectOne(String name);
	public int insert(ScoreDto dto);
	public int update(ScoreDto dto);
	public int delete(String name);
	
	public ScoreDto topNSelect(int n);
}

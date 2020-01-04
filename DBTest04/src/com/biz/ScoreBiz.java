package com.biz;


import java.util.List;

import com.dto.ScoreDto;
public interface ScoreBiz {

	public List<ScoreDto> scoreList();
	public ScoreDto scoreOne(int no);
	public int insert(ScoreDto dto);
	public int update(ScoreDto dto1);
	public int delete(int no);
	
}

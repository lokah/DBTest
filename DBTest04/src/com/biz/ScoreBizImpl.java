package com.biz;

import java.util.List;
import com.dao.ScoreDao;
import com.dao.ScoreDaoImpl;
import com.dto.ScoreDto;

public class ScoreBizImpl implements ScoreBiz {

	private ScoreDao dao = new ScoreDaoImpl();
	
	@Override
	public List<ScoreDto> scoreList() {
		// TODO Auto-generated method stub
		return dao.scoreList();
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

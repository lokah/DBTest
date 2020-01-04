package com.biz;

import java.util.List;

import com.dao.ScoreDao;
import com.dao.ScoreDaoImpl;
import com.dto.ScoreDto;

public class ScoreBizImpl implements ScoreBiz {

	private ScoreDao dao = new ScoreDaoImpl();
	
	@Override
	public List<ScoreDto> selectList() {
		// TODO Auto-generated method stub
		
		return dao.selectList();
	}

	@Override
	public ScoreDto selectOne(String name) {
		// TODO Auto-generated method stub
		return dao.selectOne(name);
	}

	@Override
	public int insert(ScoreDto dto) {
		// TODO Auto-generated method stub
		dto.setSum(getSum(dto.getKor(), dto.getEng(),dto.getMath()));
		
		dto.setAvg(getAvg(dto.getSum()));
		
		dto.setGrade(getGrade(dto.getAvg()));
		
		return dao.insert(dto);
	}

	@Override
	public int update(ScoreDto dto) {
		// TODO Auto-generated method stub
		dto.setSum(getSum(dto.getKor(),dto.getEng(),dto.getMath()));
		dto.setAvg(getAvg(dto.getSum()));
		dto.setGrade(getGrade(dto.getAvg()));
		
		
		return dao.update(dto);
	}

	@Override
	public int delete(String name) {
		// TODO Auto-generated method stub
		
		
		
		return dao.delete(name);
	}

	
	public int getSum(int kor, int eng, int math) {
		
		return kor + eng + math;
	}
	public double getAvg(int sum) {
		return sum/3.0;
		
	}
	
	public String getGrade(double avg) {
		
		switch((int) avg/10) {
		
		case 10 :
		case 9 :
			return "A";
		
		case 8 :
			return "B";
		case 7 :
			return "C";
		case 6 :
			return "D";
		
		}
		return "F";
	}
	
	public ScoreDto topNSelect(int n) {
		
		return dao.topNSelect(n);
	}
}

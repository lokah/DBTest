package com.biz;

import java.util.List;

import com.dao.MemberDao;
import com.dao.MemberDaoImpl;
import com.dto.MemberDto;

public class MemberBizImpl implements MemberBiz {

	private MemberDao dao = new MemberDaoImpl();
	
	@Override
	public List<MemberDto> selectList() {
		// TODO Auto-generated method stub
		return dao.selectList();
	}

	@Override
	public MemberDto selectOne(int no) {
		// TODO Auto-generated method stub
		
		
		return dao.selectOne(no);
	}

	@Override
	public int insert(MemberDto dto) {
		// TODO Auto-generated method stub
		MemberDto tmp = dto;//조건 수정을 하는 것이므로 비즈에서 한다.
		tmp.setGender(dto.getGender().toUpperCase());
		
		return dao.insert(tmp);
	}

	@Override
	public int update(MemberDto dto1) {
		// TODO Auto-generated method stub
		
		
		return dao.update(dto1);
	}

	@Override
	public int delete(int no) {
		// TODO Auto-generated method stub
		return dao.delete(no);
	}

}

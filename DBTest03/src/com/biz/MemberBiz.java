package com.biz;

import java.util.List;

import com.dto.MemberDto;
//데이터 연결과 화면 전환 역할 외에 다른 모든 것을 한다. 연산, 데이터 수정 삽입 등의 조건을 만족하도록 처리하는 역할, 서비스 역할
//소문자를 대문자로 바꿔주는 역할
public interface MemberBiz {
	
	public List<MemberDto> selectList();
	public MemberDto selectOne(int no);
	public int insert(MemberDto dto);
	public int update(MemberDto dto1);
	public int delete(int no);

}

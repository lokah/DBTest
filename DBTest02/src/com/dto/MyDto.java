package com.dto;

//dto
//vo
//db에 있는 데이터를 전달 - 주의사항 db의 컬럼과 같은 이름으로 필드를 생성한다. 이유는 이름이 다르면 자동으로 못가져오기 때문에...
public class MyDto {

	/*
	 * NO NUMBER PRIMARY KEY, NAME VARCHAR2(100), NICKNAME VARCHAR2(200) );
	 */
	
	private int no;
	private String name;
	private String nickname;
	
	public MyDto() {
		
	}
	
	public MyDto(int no, String name, String nickname) {
		this.no = no;
		this.name = name;
		this.nickname = nickname;
		
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@Override
	public String toString() {
		return no + "\t" + name + "\t" + nickname ;
	}
	

	

}

package com.view;

import java.util.List;
import java.util.Scanner;

import com.biz.MemberBiz;
import com.biz.MemberBizImpl;
import com.dto.MemberDto;




//뷰와 컨트롤로가 혼합된 상태의 클래스, 지금 뷰가 컨트롤로의 역할
public class MemberView {

	
	private static Scanner sc = new Scanner(System.in);
	
	public static int getMenu() {
		
		StringBuffer sb = new StringBuffer() ;
		int select = 0;
		
		sb.append("********\n")
		.append("*1. 전체출력*\n")
		.append("*2. 선택출력*\n")
		.append("*3. 추      가*\n")
		.append("*4. 수      정*\n")
		.append("*5. 삭      제*\n")
		.append("*6. 종      료*\n")
		.append("**********\n");
		
		System.out.println(sb);;
		System.out.println("input select :");
		select = sc.nextInt();
		

		return select;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int select = 0;
		MemberBiz biz = new MemberBizImpl();
		
		while(select!=6) {
			
			select = getMenu();
			
			switch(select) {
			
			case 1:
				
				
				List<MemberDto> list = biz.selectList();
				for(MemberDto dto : list) {
					
					System.out.println(dto);
				}
				
				
				//전체출력
				break;
			case 2:
				
				System.out.println("선택출력");
				
				
				System.out.println("출력할 번호 선택 :");
				int selectNo = sc.nextInt();
				
				MemberDto selectOne = biz.selectOne(selectNo);
				System.out.println(selectOne);
				
				//선택출력
				break;
			case 3 :
				
System.out.println("추가");
				
				System.out.println("추가할 번호 :");
				int insertNo = sc.nextInt();
				System.out.println("추가할 이름 :");
				String insertName = sc.next();
				System.out.println("추가할 나이 :");
				int insertAge = sc.nextInt();
				System.out.println("추가할 성 :");
				String insertGender = sc.next();
				System.out.println("추가할 주소 :");
				String insertLocation = sc.next();
				System.out.println("추가할 직업 :");
				String insertJob = sc.next();
				System.out.println("추가할 전화 :");
				String insertTel = sc.next();
				System.out.println("추가할 이메일 :");
				String insertEmail = sc.next();
				
				MemberDto dto = new MemberDto(insertNo, insertName,insertAge,insertGender,insertLocation, insertJob,insertTel, insertEmail);
				//dto.setNo(insertNo)...이런 형식으로 담아도 된다.
				int insertRes = biz.insert(dto);
				if(insertRes > 0) {
					
					System.out.println("추가 성공");
				}else {
					System.out.println("추가 실패");
				}
				
				//추가
				break;
			case 4 :
				
System.out.println("수정");
				
				System.out.println("수정할 번호 선택 :");
				int updateNo = sc.nextInt();
				
				System.out.println("수정할 이름 : ");
				String updateName = sc.next();
				System.out.println("수정할 직업 :");
				String updateJob = sc.next();
				
				MemberDto dto1 = new MemberDto();
				dto1.setNo(updateNo);
				dto1.setName(updateName);
				dto1.setJob(updateJob);
				
				int updateRes = biz.update(dto1);
				if(updateRes >0) {
					
					System.out.println("수정 성공");
				}else {
					
					System.out.println("수정 실패");
				}
				
				
				//수정
				break;
			case 5 :
				
System.out.println("삭제");
				
				System.out.println("삭제할 번호 선택 :");
				int deleteNo = sc.nextInt();
				
				//MyDto deleteDto = new MyDto();
				//deleteDto.setNo(deleteNo);
				
				int deleteRes = biz.delete(deleteNo);
				if(deleteRes >0) {
					
					System.out.println("삭제 성공");
				}else {
					
					System.out.println("삭제 실패");
				}
				
				//삭제
				break;
			case 6 :
				
				//종료
				System.out.println("종료...");
				break;
			
			}
		}
		
		
	}

}

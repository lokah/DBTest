package com.controller;

import java.util.List;
import java.util.Scanner;

import com.biz.ScoreBiz;
import com.biz.ScoreBizImpl;
import com.dto.ScoreDto;

public class ScoreController {

	private static Scanner sc = new Scanner(System.in);

	private static int getMenu() {

		StringBuffer sb = new StringBuffer();
		sb.append("1. 전체출력  \n");
		sb.append("2. 선택출력  \n");
		sb.append("3. 추가  \n");
		sb.append("4. 수정  \n");
		sb.append("5. 삭제  \n");
		sb.append("......\n");
		sb.append("6.1등 출력  \n");
		sb.append("7.2등 출력 \n");
		sb.append("8.3등 출력 \n");
		sb.append("9. 종료 \n");

		System.out.println(sb);
		System.out.println("번호 선택 :");
		int select1 = sc.nextInt();
		return select1;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ScoreBiz biz = new ScoreBizImpl();
		int select = 0;
		while (select != 9) {

			select = getMenu();
			switch(select) {
			
			case 1 :
				System.out.println("전체출력");
				
				List<ScoreDto> list = biz.selectList();
				for(ScoreDto dto : list) {
					System.out.println(dto);
				}
				
				break;
			case 2 :
				
				System.out.println("선택출력");
				
				System.out.println("출력할 이름 선택 :");
				String selectName = sc.next();
				ScoreDto selectOne = biz.selectOne(selectName);
				System.out.println(selectOne);
				

				break;
			case 3 :
				
				System.out.println("이름 입력");
				String inputName = sc.next();
				ScoreDto tmp = biz.selectOne(inputName);
				if(tmp !=null) {
					
					System.out.println("이름이 존재합니다.");
				}else {
					
					System.out.println("국어 점수 : ");
					int insertKor = sc.nextInt();
					System.out.println("영어 점수 :");
					int insertEng = sc.nextInt();
					System.out.println("수학 점수 :");
					int insertMath = sc.nextInt();
					
					ScoreDto insertDto = new ScoreDto(inputName, insertKor, insertEng, insertMath,0,0,null);
					
					int insertRes = biz.insert(insertDto);
					if(insertRes >0) {
						System.out.println("입력 성공");
						
					}else {
						System.out.println("입력 실패");
					}
					
					
				}
				
				//추가
				//이름 입력
				//이름 있으면 이름이 존재합니다.
				//없으면 국어 영어 수학 입력 받는다.
				break;
			case 4 :
				
				System.out.println("수정할 이름");
				String updateName = sc.next();
				System.out.println("국어점수 :");
				int updateKor = sc.nextInt();
				System.out.println("영어점수 :");
				int updateEng = sc.nextInt();
				System.out.println("수학점수 :");
				int updateMath = sc.nextInt();
				
				ScoreDto updateDto = new ScoreDto();
				updateDto.setName(updateName);
				updateDto.setKor(updateKor);
				updateDto.setEng(updateEng);
				updateDto.setMath(updateMath);
				
				int updateRes = biz.update(updateDto);
				
				if(updateRes >0) {
					
					System.out.println("수정 성공");
				}else {
					System.out.println("수정 실패");
				}
				
				
				break;
			case 5 :
				
				System.out.println("삭제할 이름");
				String deleteName = sc.next();
				int deleteRes =  biz.delete(deleteName);
				if(deleteRes>0) {
					
					System.out.println("삭제 성공");
				}else {
					System.out.println("삭제 실패");
				}
				
				break;
			case 6 :
				//1등
				
				System.out.println("1등 출력");
				System.out.println(biz.topNSelect(1));
				break;
			case 7 :
				//2등
				System.out.println("2등 출력");
				System.out.println(biz.topNSelect(2));
				break;
			case 8 :
				//3등
				System.out.println("3등 출력");
				System.out.println(biz.topNSelect(3));
				break;
			case 9 :
				break;
				
			}
			
		}

	}

}

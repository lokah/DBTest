package com.view;

import java.util.List;
import java.util.Scanner;

import com.biz.ScoreBiz;
import com.biz.ScoreBizImpl;
import com.dto.ScoreDto;

public class ScoreView {

	private static Scanner sc = new Scanner(System.in);

	public static int getMenu() {

		StringBuffer sb = new StringBuffer();
		int select = 0;

		sb.append("********\n").append("*1. 전체출력*\n").append("*2. 선택출력*\n").append("*3. 추      가*\n")
				.append("*4. 수      정*\n").append("*5. 삭      제*\n").append("*6. 종      료*\n").append("**********\n");

		System.out.println(sb);
		;
		System.out.println("input select :");
		select = sc.nextInt();

		return select;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int select = 0;
		ScoreBiz biz = new ScoreBizImpl();
		
		while(select != 6) {
			
			select = getMenu();
			switch(select) {
			
			case 1:
				List<ScoreDto> list = biz.scoreList();
				for(ScoreDto dto : list) {
					
					System.out.println(dto);
				}
				
				break;
				
			case 2:
				
				System.out.println("선택출력");
				
				break;
			case 3:
				
				System.out.println("추가");
				break;
			case 4:
				System.out.println("수정");
				break;
			case 5:
				System.out.println("삭제");
				break;
			case 6:
				System.out.println("종료");
				break;
			}
		}
	}

}

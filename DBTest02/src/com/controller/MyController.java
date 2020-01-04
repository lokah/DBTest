package com.controller;

import java.util.List;

import java.util.Scanner;

import com.dao.MyDao;
import com.dto.MyDto;
//마이컨트롤로에서 입력받으면
//다오에서 연결받아 디비에 요청하고 
//디비에서 받아 화면에 출력

//컨트롤로는 입력이 있으면 그 입력에 맞는 데이타를 화면에 출력해준다.
//클라이언트에서 요청이 들어오면 그 요청에 받는 화면을 응답시켜주는 역할이 컨트롤로다.
//컨트롤로에서 다오를 통해 디비에 접근한다. 다오는 디비와 연결해주는 역할이다.
//컨트롤로에서 요청이 들어오면 다오가 디비에 연결해준다. 다오는 디비와 연결 수정 삽입하는 역할
//디비와 다오 사이가 jdbc다. 
//쿼리 준비 - 스테이트먼트는 커리를 문자열로 만들어야 한다. 작은 따옴표가 들어가야 한다.
//반면에 프리페어드스테이트먼트는 문자열이 아닌 ?를 써도 된다. ?에 값을 하나씩 넣어주는 역할을 한다.
//또한 프리페어드스테이트 먼트는 sql이 가로 안에 없어도 된다. 스테이트먼트는 가로 안에 Sql을 넣어줘야 한다.
//
public class MyController {
// view 역할, 화면을 뭔가 할거야 하는 역할 화면 제어 전환

	private static Scanner sc = new Scanner(System.in);

	public static int getMenu() {

		StringBuffer sb = new StringBuffer();
		int select = 0;

		sb.append("1. 전체 출력 \n").append("2. 선택출력  \n").append("3. 추가 \n").append("4. 수정 \n").append("5. 삭제 \n")
				.append("6. 종료 \n");

		System.out.println(sb);
		System.out.println("번호 선택 :");
		select = sc.nextInt();

		return select;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// mvc
		// model - 연산 또는 디비와 연결해주는
		// view 화면
		// controller
		// dto - data transfer object 변하는 데이터
		// vo - value object 변하는 데이터

		int no = 0;
		MyDao dao = new MyDao();
		do {

			no = getMenu();
			switch (no) {
			case 1:
				System.out.println("전체출력");

				List<MyDto> list = dao.selectList();
				for (MyDto dto : list) {

					System.out.println(dto);
				}
				break;
			case 2:
				
				System.out.println("선택출력");
				
				
				
				System.out.println("출력할 번호 선택 :");
				int selectNo = sc.nextInt();
				
				
				
				MyDto selectOne = dao.selectOne(selectNo);
				System.out.println(selectOne);
				
				//if(selectRes != null) {
					//System.out.println("선택 출력 성공");
				//}else {
					//System.out.println("선택 출력 실패");
				//}
				
				
				break;
			case 3:
				System.out.println("추가");
				
				System.out.println("추가할 번호 :");
				int insertNo = sc.nextInt();
				System.out.println("추가할 이름 :");
				String insertName = sc.next();
				System.out.println("추가할 별명 :");
				String insertNickname = sc.next();
				
				MyDto insertDto = new MyDto(insertNo, insertName, insertNickname);
				int insertRes = dao.insert(insertDto);
				if(insertRes > 0) {
					
					System.out.println("추가 성공");
				}else {
					System.out.println("추가 실패");
				}
				
				
				break;
			case 4:
				System.out.println("수정");
				
				System.out.println("수정할 번호 선택 :");
				int updateNo = sc.nextInt();
				
				System.out.println("수정할 이름 : ");
				String updateName = sc.next();
				System.out.println("수정할 별명 :");
				String updateNickname = sc.next();
				
				MyDto updateDto = new MyDto();
				updateDto.setNo(updateNo);
				updateDto.setName(updateName);
				updateDto.setNickname(updateNickname);
				
				int updateRes = dao.update(updateDto);
				if(updateRes >0) {
					
					System.out.println("수정 성공");
				}else {
					
					System.out.println("수정 실패");
				}
				
				
				
				break;
			case 5:
				System.out.println("삭제");
				
				System.out.println("삭제할 번호 선택 :");
				int deleteNo = sc.nextInt();
				
				//MyDto deleteDto = new MyDto();
				//deleteDto.setNo(deleteNo);
				
				int deleteRes = dao.delete(deleteNo);
				if(deleteRes >0) {
					
					System.out.println("삭제 성공");
				}else {
					
					System.out.println("삭제 실패");
				}
				
				break;
			case 6:
				System.out.println("종료");
				sc.close();
				System.exit(0);
			}

		} while (no != 6);

	}
}

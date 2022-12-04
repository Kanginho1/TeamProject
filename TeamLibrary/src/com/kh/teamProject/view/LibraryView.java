package com.kh.teamProject.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.teamProject.controller.BookController;
import com.kh.teamProject.model.vo.Book;

public class LibraryView {
	
	
	public static void printBook() {
		Scanner sc = new Scanner(System.in);
		BookController bc = new BookController();
		ArrayList<Book> bList = new ArrayList<>();
		bList.add(new Book(7345, "아지트", "조인명", "연화", 2));
		bList.add(new Book(7867, "삼순이", "정찬일", "호와출판", 1));
		bList.add(new Book(8370, "싱크로드", "수진", "해커스", 3));
		bList.add(new Book(7874, "공부유전", "김박사", "친화출판", 1));
		bList.add(new Book(1765, "워크맨", "룰루랄라", "스튜디오", 2));
		bList.add(new Book(5664, "언덕에", "조하영", "초록뱀", 1));
		bList.add(new Book(5471, "빛", "빛", "빛", 1));
		bList.add(new Book(3718, "어둠", "김창렬", "문학사", 1));
		bList.add(new Book(8417, "가비차", "이지은", "프로젝트", 1));
		
		for(Book b : bList) {
			bc.addBook(b);
		}
		
		while(true) {
			System.out.println("(1)관리자 모드 (2)이용자 모드 (3)종료");
			System.out.print("이용하실 모드의 번호를 입력하세요 : ");
			int num = sc.nextInt();
			switch (num) {
			case 1 :
				System.out.println("*************관리자 모드 입니다.********************");
				System.out.println("(1)도서 조회 (2)도서 등록 (3)도서 삭제 (4)도서 정보 수정 (5)뒤로 가기 (6)종료");
				System.out.print("원하시는 메뉴 번호를 선택하세요 : ");
				int num2 = sc.nextInt();
				sc.nextLine();
				if(num2==1) {
					System.out.println("*************도서 전체 조회를 시작합니다.********************");
					for(Book b : bc.allBook()) {
						System.out.println(b);
					}
				}else if(num2==2) {
					while(true) {
					System.out.print("도서명을 입력하세요 : ");
					String bn = sc.nextLine();
					System.out.print("도서 지은이를 입력하세요 : ");
					String ba = sc.nextLine();
					System.out.print("도서 출판사를 입력하세요 : ");
					String bp = sc.nextLine();
					System.out.print("총 보유 권수를 입력하세요 : ");
					int rm = sc.nextInt();
					System.out.println("도서번호는 자동으로 생성됩니다.");
					System.out.print("도서를 등록하시겠습니까?(1.등록하기 2.다시하기) : ");
					int yn = sc.nextInt();
					sc.nextLine();
					if(yn == 1) {
					while(true) {		// 겹치지 않는 도서 코드가 생성될때까지 무한 반복
						int count = 0;						//도서 번호 랜덤 생성하고 기존에 있는 번호와 겹치지 않게끔 함
						int bno = (int)(Math.random()*(10000-1000+1)+1000);	
					for(Book b : bc.bList) {
						if(b.getbNo() == bno) {
							count++;			// 기존에 있는 도서코드와 겹치는게 있다면 증감하도록 설정
							
						}
					}
					if(count == 0 ) { // 기존에 있는 도서코드와 겹치지 않는다면 증감하지 않
						Book b = new Book(bno, bn, ba, bp, rm); // 입력한 책 정보 추가
						bc.addBook(b);                // 입력한 책 정보 추가
						System.out.println("*************도서등록완료********************");
						System.out.println("도서번호 : "+ bno);
						System.out.println("도서명 : "+ bn);
						System.out.println("지은이 : "+ ba);
						System.out.println("출판사 : "+ bp);
						System.out.println("보유 권수 : " + rm);
						System.out.println("*****************************************");
						System.out.println();
						break;
						
					}
					}
					}else if(yn == 2) {
						continue;
					}else {
						System.out.println("잘못입력했습니다. 이전화면으로 돌아갑니다.");
						break;
					}
					break;
					}
					break;
					
				}else if(num2==3) {
					System.out.println("***********도서 삭제를 시작합니다.*******************");
					System.out.print("삭제를 원하는 도서 번호를 입력하세요 : ");
					int dno = sc.nextInt();
					sc.nextLine();
					int flag = 0;
					for(Book b : bc.bList) {
						if(b.getbNo()==dno) {  // 입력한 도서코드와 일치하면 그 도서코드를 가진 북객체 삭제
							bc.delectBook(b);
							flag++;			// 일치하는 도서코드가 있다면 증감
							System.out.println("***********도서가 삭제 되었습니다.*****************");
							break;
						}
					}
					if(flag == 0) { // 입력한 도서코드와 일치하는 도서코드가 없기에 flag는 증감하지 않았음 그렇기에 잘못 입력한 것!!
					System.out.println("번호를 잘못 입력하셨습니다.");
					}
				}else if(num2==4) {
					
				}else if(num2==5) {
					continue;
				}else if(num2==6) {
					System.out.println("프로그램을 종료합니다.");
					return;
				}else {
					System.out.println("잘못 입력했습니다.");
				}
				break;
			case 2 : 
				System.out.println("*************이용자 모드 입니다.********************");
				System.out.println("(1)회원가입 (2)로그인 (3)도서조회 (4)회원정보 수정 (5)대출 (6)반납 (7)뒤로가기 (8)종료");
				System.out.print("원하시는 메뉴 번호를 선택하세요 : ");
				int num3 = sc.nextInt();
				if(num3==1) {
					
				}else if(num3==2) {
					
				}else if(num3==3) {
					
				}else if(num3==4) {
					
				}else if(num3==5) {
					
				}else if(num3==6) {
					
				}else if(num3==7) {
					continue;
				}else if(num3==8) {
					System.out.println("프로그램을 종료합니다.");
					return;
					
				}else {
					
				}
				break;
			case 3 :
				System.out.println("프로그램을 종료합니다.");
				return;
				
				default : 
				System.out.println("잘못 입력했습니다.");
			}
		}
	}
}






/*
 * 1.관리자 모드 2. 이용자 모드 3. 종료
 * 
 *   관리자모드 
 *   1-1. 도서 조회  1-2. 도서 등록  1-3. 도서 삭제  1-4. 도서 정보 수정  1-5. 뒤로가기 1-6. 종료
 *   기본 디폴트 도서 등록
 *   관리자 메뉴의 기능이 끝나면 다시 관리자 모드로 돌아와야함
 *   
 *   이용자 모드
 *   2-1. 회원가입  2-2. 로그인 2-3. 도서 조회 2-4. 회원정보 수정 2-5. 대출 2-6. 반납 2-7. 뒤로가기 2-8. 종료
 *   회원가입의 경우 map 컬렉션 사용
 *   도서조회나 대출 반납은 로그인 되어있을 때만 이용가능
 *   대출하려는 도서를 조회시 수량이 남아 있을 경우만 대출 가능하고 수량이 다 떨어지면 대출 불가능 반납시 다시 수량 +
 *   
 */

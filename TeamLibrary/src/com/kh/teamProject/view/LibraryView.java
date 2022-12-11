package com.kh.teamProject.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.teamProject.controller.BookController;
import com.kh.teamProject.model.vo.Book;
import com.kh.teamProject.model.vo.User;

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

		for (Book b : bList) {
			bc.addBook(b);
		}

		boolean login = false; // 핵심 역할 로그인 되어있다는걸 표시
		while (true) {
			System.out.println("(1)관리자 모드 (2)이용자 모드 (3)종료");
			System.out.print("이용하실 모드의 번호를 입력하세요 : ");
			int num = sc.nextInt();
			while (true) {
				switch (num) {
				case 1: // 관리자 모드
					System.out.println("*************관리자 모드 입니다.********************");
					System.out.println("(1)도서 조회 (2)도서 등록 (3)도서 삭제 (4)도서 정보 수정 (5)뒤로 가기 (6)종료");
					System.out.print("원하시는 메뉴 번호를 선택하세요 : ");
					int num2 = sc.nextInt();
					sc.nextLine();
					if (num2 == 1) { // 1_1. 도서 조회
						System.out.println("*************도서 전체 조회를 시작합니다.********************");
						for (Book b : bc.allBook()) {
							System.out.println(b);
						}
					} else if (num2 == 2) { // 1_2. 도서 등록
						while (true) {
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
							if (yn == 1) {
								while (true) { // 겹치지 않는 도서 코드가 생성될때까지 무한 반복
									int count = 0; // 도서 번호 랜덤 생성하고 기존에 있는 번호와 겹치지 않게끔 함
									int bno = (int) (Math.random() * (10000 - 1000 + 1) + 1000);
									for (Book b : bc.bList) {
										if (b.getbNo() == bno) {
											count++; // 기존에 있는 도서코드와 겹치는게 있다면 증감하도록 설정

										}
									}
									if (count == 0) { // 기존에 있는 도서코드와 겹치지 않는다면 증감하지 않
										Book b = new Book(bno, bn, ba, bp, rm); // 입력한 책 정보 추가
										bc.addBook(b); // 입력한 책 정보 추가
										System.out.println("*************도서등록완료********************");
										System.out.println("도서번호 : " + bno);
										System.out.println("도서명 : " + bn);
										System.out.println("지은이 : " + ba);
										System.out.println("출판사 : " + bp);
										System.out.println("보유 권수 : " + rm);
										System.out.println("*****************************************");
										System.out.println();
										break;

									}
								}
							} else if (yn == 2) {
								continue;
							} else {
								System.out.println("잘못입력했습니다. 이전화면으로 돌아갑니다.");
								break;
							}
							break;
						}
						break;

					} else if (num2 == 3) { // 1_3. 도서 삭제
						System.out.println("***********도서 삭제를 시작합니다.*******************");
						System.out.print("삭제를 원하는 도서 번호를 입력하세요 : ");
						int dno = sc.nextInt();
						sc.nextLine();
						int flag = 0;
						for (Book b : bc.bList) {
							if (b.getbNo() == dno) { // 입력한 도서코드와 일치하면 그 도서코드를 가진 북객체 삭제
								bc.delectBook(b);
								flag++; // 일치하는 도서코드가 있다면 증감
								System.out.println("***********도서가 삭제 되었습니다.*****************");
								break;
							}
						}
						if (flag == 0) { // 입력한 도서코드와 일치하는 도서코드가 없기에 flag는 증감하지 않았음 그렇기에 잘못 입력한 것!!
							System.out.println("번호를 잘못 입력하셨습니다.");
						}
					} else if (num2 == 4) { // 1_4. 도서 정보 수정
						if (bList.isEmpty()) { // 존재하는 도서가 없을 때
							System.out.println("현재 존재하는 도서가 없습니다.");
							break;
						} else {
							System.out.println("***********도서 수정을 시작합니다.*******************");

							System.out.print("수정을 원하는 도서 번호를 입력하세요 : ");
							int bNo = sc.nextInt();

							sc.nextLine();

							for (Book b : bList) {
								if (b.getbNo() != bNo) {
									System.out.println("존재하지 않는 도서 번호입니다.");
									break;
								} else {
									System.out.print("도서 제목을 입력하세요 : ");
									String bName = sc.nextLine();

									System.out.print("도서 지은이를 입력하세요 : ");
									String bAut = sc.nextLine();

									System.out.print("도서 출판사를 입력하세요 : ");
									String bPub = sc.nextLine();

									System.out.println("재고를 입력하세요 : ");
									int remain = sc.nextInt();

									sc.nextLine();

									int result = bc.updateBook(bNo, bName, bAut, bPub, remain);

									if (result == 1) {
										System.out.println("**********도서 수정이 완료되었습니다.****************");
										break;
									}
								}
							}
						}

					} else if (num2 == 5) { // 1_5. 뒤로 가기
						continue;
					} else if (num2 == 6) { // 1_6. 종료
						System.out.println("프로그램을 종료합니다.");
						return;
					} else {
						System.out.println("잘못 입력했습니다.");
					}
					break;
				case 2: // 이용자 모드
					System.out.println("*************이용자 모드 입니다.********************");
					System.out.println("(1)회원가입 (2)로그인 (3)도서조회 (4)회원정보 수정 (5)대출 (6)반납 (7)뒤로가기 (8)종료");
					System.out.print("원하시는 메뉴 번호를 선택하세요 : ");
					int num3 = sc.nextInt();
					sc.nextLine();
					if (num3 == 1) { // 2_1. 회원가입
						while (true) {
							System.out.println("*************회원 가입을 시작합니다.********************");
							System.out.print("ID를 입력하세요. : ");
							String id = sc.nextLine();
							System.out.print("비밀번호를 입력하세요 : ");
							String pwd = sc.nextLine();
							System.out.print("이름을 입력하세요 : ");
							String uName = sc.nextLine();
							System.out.print("나이를 입력하세요 : ");
							int age = sc.nextInt();
							sc.nextLine();
							System.out.print("전화번호 입력하세요 : ");
							String phone = sc.nextLine();
							System.out.print("정보를 등록하시겠습니까(1.등록하기 2.다시 입력하기) : ");
							int yn = sc.nextInt();
							sc.nextLine();
							if (yn == 1) {
								bc.addUser(new User(id, pwd, uName, age, phone));

								break;
							} else if (yn == 2) {
								continue;
							} else {
								System.out.println("잘못 입력했습니다. 이전 화면으로 돌아갑니다.");
								break;
							}
						}
					} else if (num3 == 2) { // 2_2. 로그인
						if (login == true) {
							System.out.println("현재 로그인 상태입니다.");
							break;
						}
						System.out.println("*************로그인 화면입니다.***************************");
						System.out.print("ID입력 : ");
						String id = sc.nextLine();
						System.out.print("비밀번호 입력 : ");
						String pwd = sc.nextLine();

						if (bc.uList.isEmpty()) {
							System.out.println("아이디나 비밀번호가 잘못 되었습니다.");
							break;
						}
						if (bc.user.containsKey(id)) {

						} else {
							System.out.println("아이디가 잘못 되었습니다.");
							break;
						}
						if (bc.user.get(id).equals(pwd)) {
							System.out.println(id + "님 로그인 되었습니다.");
							login = true;
						} else if (!bc.user.containsKey(id) == false) {
							System.out.println("비밀번호가 잘못 되었습니다.");
							break;
						}
					} else if (num3 == 3) { // 2_3. 도서 조회
						System.out.println("*************도서 조회를 시작합니다.********************");
						System.out.println("(1)도서 번호로 검색 (2)도서 명으로 검색 (3)지은이로 검색 (4)출판사로 검색");
						System.out.print("원하시는 모드를 선택하세요 : ");
						int mode = sc.nextInt();
						sc.nextLine();
						int search = 0;
						if (mode == 1) {
							System.out.print("도서 번호를 입력하세요 : ");
							int bno = sc.nextInt();
							for (Book b : bc.bList) {
								if (b.getbNo() == bno) {
									System.out.println(b);
									search++;
									break;
								}
							}
						} else if (mode == 2) {
							System.out.print("도서명을 입력하세요 : ");
							String bName = sc.nextLine();
							for (Book b : bc.bList) {
								if (b.getbName().contains(bName)) {
									System.out.println(b);
									search++;
									break;
								}
							}
						} else if (mode == 3) {
							System.out.print("지은이를 입력하세요 : ");
							String bAut = sc.nextLine();
							for (Book b : bc.bList) {
								if (b.getbAut().contains(bAut)) {
									System.out.println(b);
									search++;
									break;
								}
							}
						} else if (mode == 4) {
							System.out.print("출판사를 입력하세요 : ");
							String bPub = sc.nextLine();
							for (Book b : bc.bList) {
								if (b.getbPub().contains(bPub)) {
									System.out.println(b);
									search++;
									break;
								}
							}
						} else {
							System.out.println("잘못 입력했습니다. 이전 화면으로 돌아갑니다.");
							break;
						}
						if (search == 0) {
							System.out.println("존재하지 않는 정보입니다.");
						}
					} else if (num3 == 4) { // 2_4. 회원정보 수정
						while (true) {
							ArrayList<User> uList = bc.getAllUser();
							
							if (uList.isEmpty()) {
								System.out.println("현재 수정할 회원이 없습니다.");
								break;
							}
							System.out.println("***********회원정보 수정을 시작합니다.*******************");
							System.out.print("ID를 입력하세요 : ");
							String id = sc.nextLine();

							System.out.print("비밀번호를 입력하세요 : ");
							String pwd1 = sc.nextLine();

							boolean find = bc.modifyUser(id, pwd1);

							if (find == true) {
								System.out.println("회원님의 회원정보 수정페이지 입니다.");
							}
							if(find == false){
								System.out.println("없는 회원이거나 잘못 입력하셨습니다. 다시 입력해주세요.");
								continue;
							}
					
							System.out.print("비밀번호를 수정하세요 : ");
							String pwd = sc.nextLine();

							System.out.print("이름을 수정하세요 : ");
							String uName = sc.nextLine();

							System.out.print("나이를 수정하세요 : ");
							int age = sc.nextInt();
							sc.nextLine();

							System.out.print("전화번호를 수정하세요(-는 제외하고 입력해주세요.) : ");
							String phone = sc.nextLine();

							int result = bc.updateUser(id, pwd, uName, age, phone);

							System.out.println("수정이 완료되었습니다.");
							break;
						}

					} else if (num3 == 5) { // 2_5. 도서 대출
						if (login == false) {
							System.out.println("로그인을 하고 이용해주세요"); // 로그인이 안되어있으면 접속이 불가하도록 설정했음!!!!! ******
							break;
						}
						System.out.print("대여할 도서 번호를 입력하세요 : ");
						int bno = sc.nextInt();
						if (bc.bookLoan(bno)) {
							System.out.println("대출 완료");
						} else {
							System.out.println("존재하지 않는 도서 번호거나, 남은 도서가 없습니다.");
							break;
						}

					} else if (num3 == 6) { // 2_6. 도서 반납
						while (true) {
							System.out.print("반납할 도서 번호를 입력하세요 : ");
							int bNo = sc.nextInt();
							sc.nextLine();

							int result1 = bc.returnBook(bNo);
							
							if (result1 == 1) {
								System.out.println("반납 완료");
								int result2 = bc.returnBook2(bNo);
								break;
							} else {
								System.out.println("도서번호를 잘못 입력하셨습니다. 다시 입력해주세요.");
							}
						}

					} else if (num3 == 7) { // 2_7. 뒤로가기
						continue;
					} else if (num3 == 8) { // 2_8. 종료
						System.out.println("프로그램을 종료합니다.");
						return;

					} else {}
					break;
				case 3: // 종료
					System.out.println("프로그램을 종료합니다.");
					return;

				default:
					System.out.println("잘못 입력했습니다.");
				}
			}
		} 
	}
}

/*
 * 1.관리자 모드 2. 이용자 모드 3. 종료
 * 
 * 관리자모드 1-1. 도서 조회 1-2. 도서 등록 1-3. 도서 삭제 1-4. 도서 정보 수정 1-5. 뒤로가기 1-6. 종료 기본 디폴트
 * 도서 등록 관리자 메뉴의 기능이 끝나면 다시 관리자 모드로 돌아와야함
 * 
 * 이용자 모드 2-1. 회원가입 2-2. 로그인 2-3. 도서 조회 2-4. 회원정보 수정 2-5. 대출 2-6. 반납 2-7. 뒤로가기
 * 2-8. 종료 회원가입의 경우 map 컬렉션 사용 도서조회나 대출 반납은 로그인 되어있을 때만 이용가능 대출하려는 도서를 조회시 수량이
 * 남아 있을 경우만 대출 가능하고 수량이 다 떨어지면 대출 불가능 반납시 다시 수량 +
 * 
 */

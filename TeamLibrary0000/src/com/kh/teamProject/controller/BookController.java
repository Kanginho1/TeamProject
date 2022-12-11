package com.kh.teamProject.controller;

import java.util.ArrayList;
import java.util.HashMap;

import com.kh.teamProject.model.vo.Book;
import com.kh.teamProject.model.vo.RBook;
import com.kh.teamProject.model.vo.User;

public class BookController implements  BookManager{
	public ArrayList<Book> bList = new ArrayList<>();
	public ArrayList<User> uList = new ArrayList<>(); // 2-1번 유저 정보가 담김
	public ArrayList<RBook> rList = new ArrayList<>(); //대출 책 정보가 담김
	//public ArrayList<Book> bl = new ArrayList<Book>(); // 대출한 책 정보가 담김
	public HashMap user = new HashMap(); // 2-2번 로그인 할때 쓰임
	
	@Override
	public void addBook(Book nBook) { // 1-2 번
		boolean  find = true;
		for(Book b : bList) {
			if(b.getbNo() == nBook.getbNo()) {
				System.out.println("도서명 : " + nBook.getbName()+"도서는 이미 있습니다.");
				find = false;
				break;
			}
		}
		if(find == true) {
			bList.add(nBook);
		}
		
	}

	@Override
	public ArrayList<Book> allBook() { // 1-1번
		return bList;
	}

	@Override
	public void delectBook(Book dBook) { // 1-3번
		bList.remove(dBook);
	}
	
	public int updateBook(int bNo, String bName, String bAut, String bPub, int remain) { // 1-4번
		int result = 0;

		for (int i = 0; i < bList.size(); i++) {
			if (bList.get(i).getbNo() == bNo) {
				bList.get(i).setbName(bName);
				bList.get(i).setbAut(bAut);
				bList.get(i).setbPub(bPub);
				bList.get(i).setRemain(remain);
				result = 1;
				break;
			}
		}
		return result;
	}


	@Override
	public void addUser(User nUser) { // 2-1번
		boolean find = true;
		for(User u : uList) {
			if(u.getId().equals(nUser.getId())) {
				System.out.println(u.getId()+"는 현재 있는 ID입니다.");
				find = false;
				break;
			}
		}
		if(find == true) {
			uList.add(nUser);
			user.put(nUser.getId(), nUser.getPwd());
			System.out.println("**********회원가입완료******************");
			System.out.println("ID :"+nUser.getId());
			System.out.println("이름 :"+nUser.getuName());
			System.out.println("나이 :"+nUser.getAge());
			System.out.println("전화번호 :"+nUser.getPhone());
			System.out.println("************************************");
		}
	}
	
	@Override
	public ArrayList<User> getAllUser() { // 2_4 회원정보에 등록된 회원유무 확인할 때를 위한 메소드
		return uList;
	}
	
	


	public ArrayList<RBook> getAllRentBook() { // 2_4 회원정보에 등록된 회원유무 확인할 때를 위한 메소드
		return rList;
	}

	@Override
	public int modifyUser(String id, String pwd1) { // 2_4번
		int find = 0;
		for (User u : uList) {
			if (id.equals(u.getId())) {
				if (pwd1.equals(u.getPwd())) {
					find = 1;
					
				}else {
					find = 2;
				}
			}

		}
		return find;
	}

	@Override
	public int updateUser(String id, String pwd, String uName, int age, String phone) { // 2-4번
		int result = 0;

		if (user.get(id).equals(id)) {
		for (int i = 0; i < uList.size(); i++) {
				uList.get(i).setPwd(pwd);
				uList.get(i).setuName(uName);
				uList.get(i).setAge(age);
				uList.get(i).setPhone(phone);
				result = 1;
				break;
			}
		}
		return result;
	}

	@Override
	public boolean bookLoan(int bno) { // 2-5번
		boolean flag = false;
		for(Book b : bList) {
			if(b.getbNo()==bno) {
				if(b.getRemain()>0) {
				rList.add(new RBook(bno));
				b.setRemain(b.getRemain()-1);
				flag = true;
				break;
			}
			}
		}
		return flag;
		
	}

	@Override
	public int returnBook(int bNo) { // 2_6번 반납할 도서번호가 맞으면 반납완료
		int result1 = 0;
		
		for(RBook rb : rList) {
			if(rb.getbNo()== bNo) {
				result1 = 1;
				
		}
			if(result1 == 0) {
			result1 = 2;
		}
		
		}
		return result1;
	}
	
	@Override
	public int returnBook2(int bNo) { // 2_6번 도서 반납 후 재고에 다시 수량 추가
		int result2 = 0;
		for (Book b : bList) {
			if (b.getbNo() == bNo) {
				b.setRemain(b.getRemain() + 1);
				break;
			}
		}
		return result2;
	}
	
	
}
	



/*
 * 다 반환하는 값을 가진 메소드로 제작
*/

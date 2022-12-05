package com.kh.teamProject.controller;

import java.util.ArrayList;
import java.util.HashMap;

import com.kh.teamProject.model.vo.Book;
import com.kh.teamProject.model.vo.User;

public class BookController implements  BookManager{
	public ArrayList<Book> bList = new ArrayList<>();
	public ArrayList<User> uList = new ArrayList<>(); // 2-1번 유저 정보가 담김
	public ArrayList<Book> bl = new ArrayList<Book>(); // 대출한 책 정보가 담김
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
	
	@Override
	public int updateBook(int bNo, String bName, String bAut, String bPub, int remain) {
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
	public boolean bookLoan(int bno) { // 2-5번
		boolean flag = false;
		for(Book b : bList) {
			if(b.getbNo()==bno) {
				if(b.getRemain()>0) {
				bl.add(b);
				b.setRemain(b.getRemain()-1);
				flag = true;
				break;
			}
			}
		}
		
		return flag;
		
	}

	




	
}

/*
 * 다 반환하는 값을 가진 메소드로 제작
*/

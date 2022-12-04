package com.kh.teamProject.controller;

import java.util.ArrayList;

import com.kh.teamProject.model.vo.Book;

public class BookController implements  BookManager{
	public ArrayList<Book> bList = new ArrayList<>();

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




	
}

/*
 * 다 반환하는 값을 가진 메소드로 제작
*/

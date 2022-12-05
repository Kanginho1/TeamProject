package com.kh.teamProject.controller;

import java.util.ArrayList;

import com.kh.teamProject.model.vo.Book;

public interface BookManager {

	void addBook(Book nBook);
	ArrayList<Book> allBook();
	void delectBook(Book dBook);
	void updateBook ();
}

/*
 * 다 반환하는 값을 가진 메소드로 제작
*/

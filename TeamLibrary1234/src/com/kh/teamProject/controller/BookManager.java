package com.kh.teamProject.controller;

import java.util.ArrayList;

import com.kh.teamProject.model.vo.Book;
import com.kh.teamProject.model.vo.User;

public interface BookManager {

	void addBook(Book nBook);
	ArrayList<Book> allBook();
	void delectBook(Book dBook);
	int updateBook(int bNo,String bName, String bAut, String bPub, int remain);
	void addUser(User nUser);
	ArrayList<User> getAllUser();
	boolean modifyUser(String id,String pwd1);
	ArrayList<User> updateUser(String id, String pwd, String uName, int age, String phone);
	boolean bookLoan(int bno);
	int returnBook(int bNo);
	int returnBook2(int bNo);
}

/*
 * 다 반환하는 값을 가진 메소드로 제작
*/

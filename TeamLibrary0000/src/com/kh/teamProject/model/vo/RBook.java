package com.kh.teamProject.model.vo;

public class RBook extends Book{
	private int bNo;
	
	public RBook() {}
	
	public RBook(int bNo) {
		super();
		this.bNo = bNo;
	}

	public int getbNo() {
		return bNo;
	}

	public void setbNo(int bNo) {
		this.bNo = bNo;
	}
	

	@Override
	public String toString() {
		return "도서번호 : "+ bNo;
	}
}

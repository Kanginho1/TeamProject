package com.kh.teamProject.model.vo;

public class Book {

	private int bNo; // 도서번호
	private String bName; // 도서명
	private String bAut; // 지은이
	private String bPub; // 출판사
	private int remain; // 남아있는 수량
	
	public Book() {}

	public Book(int bNo, String bName, String bAut, String bPub, int remain) {
		super();
		this.bNo = bNo;
		this.bName = bName;
		this.bAut = bAut;
		this.bPub = bPub;
		this.remain = remain;
	}

	public int getbNo() {
		return bNo;
	}

	public void setbNo(int bNo) {
		this.bNo = bNo;
	}

	public String getbName() {
		return bName;
	}

	public void setbName(String bName) {
		this.bName = bName;
	}

	public String getbAut() {
		return bAut;
	}

	public void setbAut(String bAut) {
		this.bAut = bAut;
	}

	public String getbPub() {
		return bPub;
	}

	public void setbPub(String bPub) {
		this.bPub = bPub;
	}

	public int getRemain() {
		return remain;
	}

	public void setRemain(int remain) {
		this.remain = remain;
	}

	@Override
	public String toString() {
		return "Book [bNo=" + bNo + ", bName=" + bName + ", bAut=" + bAut + ", bPub=" + bPub + ", remain=" + remain
				+ "]";
	}
	
	
}

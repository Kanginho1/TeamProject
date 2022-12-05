package com.kh.teamProject.model.vo;

public class User {
	private String id;
	private String pwd;
	private String uName;
	private int age;
	private String phone;
	
	public User() {}

	public User(String id, String pwd, String uName, int age, String phone) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.uName = uName;
		this.age = age;
		this.phone = phone;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	};
	
		
}

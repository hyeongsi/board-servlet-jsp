package com.dto;

public class MemberDTO {
	
	int id;
	String userid;
	String pw;
	String name;
	
	public MemberDTO() {}
	public MemberDTO(String userid, String pw, String name) {
		this.userid = userid;
		this.pw = pw;
		this.name = name;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}

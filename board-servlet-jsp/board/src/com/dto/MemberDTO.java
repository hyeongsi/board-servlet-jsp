package com.dto;

public class MemberDTO {
	
	String userid;
	String pw;
	String name;
	
	public MemberDTO() {}
	public MemberDTO(String userid, String pw, String name) {
		this.userid = userid;
		this.pw = pw;
		this.name = name;
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

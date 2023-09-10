package com.dto;

public class LoginDTO {
	
	String userid;
	String pw;
	
	public LoginDTO() {}
	public LoginDTO(String userid, String pw) {
		this.userid = userid;
		this.pw = pw;
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
	
}

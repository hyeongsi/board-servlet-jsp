package com.service;

import com.dto.MemberDTO;

public interface MemberService {
	
	public MemberDTO useridCheck(String userid);
	public MemberDTO nameCheck(String name);
}

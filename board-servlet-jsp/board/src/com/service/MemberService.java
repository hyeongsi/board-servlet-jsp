package com.service;

import java.util.HashMap;

import com.dto.MemberDTO;

public interface MemberService {
	
	public MemberDTO useridCheck(String userid);
	public MemberDTO nameCheck(String name);
	public int registerMember(MemberDTO dto);
	public MemberDTO loginMember(HashMap<String, String> loginMap);
}

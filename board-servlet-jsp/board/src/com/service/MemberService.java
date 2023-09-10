package com.service;

import com.dto.LoginDTO;
import com.dto.MemberDTO;

public interface MemberService {
	 
	// userid에 맞는 회원 정보 획득
	public MemberDTO getSameUseridMember(String userid);
	// name에 맞는 회원 정보 획득
	public MemberDTO getSameNameMember(String name);
	// 회원 추가
	public int registerMember(MemberDTO dto);
	// 회원 정보 획득
	public MemberDTO getLoginUserInfo(LoginDTO loginDTO);
	// 회원 정보 삭제
	public int deleteMember(String userid);
	// 회원 정보 수정
	public int updateMember(MemberDTO dto);
}

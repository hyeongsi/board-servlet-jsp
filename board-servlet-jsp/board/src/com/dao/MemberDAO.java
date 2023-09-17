package com.dao;

import org.apache.ibatis.session.SqlSession;

import com.dto.LoginDTO;
import com.dto.MemberDTO;

public class MemberDAO {
	
	public MemberDTO getSameUseridMember(final SqlSession session, final String userid) {
		return session.selectOne("MemberMapper.getSameUseridMember", userid);
	}
	
	public MemberDTO getSameNameMember(final SqlSession session, final String name) {
		return session.selectOne("MemberMapper.getSameNameMember", name);
	}
	
	public int registerMember(final SqlSession session, final MemberDTO dto) {
		return session.insert("MemberMapper.registerMember", dto);
	}
	
	public MemberDTO getLoginUserInfo(final SqlSession session, final LoginDTO loginDTO) {
		return session.selectOne("MemberMapper.getLoginUserInfo", loginDTO);
	}
	
	public int deleteMember(final SqlSession session, final String userid) {
		return session.delete("MemberMapper.deleteMember", userid);
	}
	
	public int updateMember(final SqlSession session, final MemberDTO dto) {
		return session.update("MemberMapper.updateMember", dto);
	}
}

package com.dao;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.dto.MemberDTO;

public class MemberDAO {
	
	public MemberDTO useridCheck(SqlSession session, String userid) {
		return session.selectOne("MemberMapper.useridCheck", userid);
	}
	
	public MemberDTO nameCheck(SqlSession session, String name) {
		return session.selectOne("MemberMapper.nameCheck", name);
	}
	
	public int registerMember(SqlSession session, MemberDTO dto) {
		return session.insert("MemberMapper.registerMember", dto);
	}
	
	public MemberDTO loginMember(SqlSession session, HashMap<String, String> loginMap) {
		return session.selectOne("MemberMapper.loginMember", loginMap);
	}
}

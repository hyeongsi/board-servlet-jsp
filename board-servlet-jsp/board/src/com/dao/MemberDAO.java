package com.dao;

import org.apache.ibatis.session.SqlSession;

import com.dto.MemberDTO;

public class MemberDAO {
	
	public MemberDTO useridCheck(SqlSession session, String userid) {
		return session.selectOne("MemberMapper.useridCheck", userid);
	}
	
	public MemberDTO nameCheck(SqlSession session, String name) {
		return session.selectOne("MemberMapper.nameCheck", name);
	}
}

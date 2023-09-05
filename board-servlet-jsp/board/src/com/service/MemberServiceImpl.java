package com.service;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.MemberDAO;
import com.dto.MemberDTO;

public class MemberServiceImpl implements MemberService {

	@Override
	public MemberDTO useridCheck(String userid) {
		MemberDTO dto = null;
		
		SqlSession session = MySqlSessionFactory.getSession();
		try {
			MemberDAO dao = new MemberDAO();
			dto = dao.useridCheck(session, userid);
		}finally {
			session.close();
		}
		return dto;
	}

	@Override
	public MemberDTO nameCheck(String name) {
		MemberDTO dto = null;
		
		SqlSession session = MySqlSessionFactory.getSession();
		try {
			MemberDAO dao = new MemberDAO();
			dto = dao.nameCheck(session, name);
		}finally {
			session.close();
		}
		return dto;
	}

	@Override
	public int registerMember(MemberDTO dto) {
		int n = 0;
		
		SqlSession session = MySqlSessionFactory.getSession();
		try {
			MemberDAO dao = new MemberDAO();
			n = dao.registerMember(session, dto);
			session.commit();
		}finally {
			session.close();
		}
		return n;
	}

}

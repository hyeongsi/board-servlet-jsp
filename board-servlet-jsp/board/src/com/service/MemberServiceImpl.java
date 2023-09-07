package com.service;

import java.util.HashMap;

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

	@Override
	public MemberDTO loginMember(HashMap<String, String> loginMap) {
		MemberDTO dto = null;
		
		SqlSession session = MySqlSessionFactory.getSession();
		try {
			MemberDAO dao = new MemberDAO();
			dto = dao.loginMember(session, loginMap);
		}finally {
			session.close();
		}
		return dto;
	}

	@Override
	public int deleteMember(String userid) {
		int n = 0;
		
		SqlSession session = MySqlSessionFactory.getSession();
		try {
			MemberDAO dao = new MemberDAO();
			n = dao.deleteMember(session, userid);
			session.commit();
		}finally {
			session.close();
		}
		return n;
	}

	@Override
	public int editMember(MemberDTO dto) {
		int n = 0;
		
		SqlSession session = MySqlSessionFactory.getSession();
		try {
			MemberDAO dao = new MemberDAO();
			n = dao.editMember(session, dto);
			session.commit();
		}finally {
			session.close();
		}
		return n;
	}

}

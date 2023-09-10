package com.service;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.MemberDAO;
import com.dto.LoginDTO;
import com.dto.MemberDTO;

public class MemberServiceImpl implements MemberService {

	@Override
	public MemberDTO getSameUseridMember(final String userid) {
		MemberDTO dto = null;
		
		final SqlSession session = MySqlSessionFactory.getSession();
		try {
			final MemberDAO dao = new MemberDAO();
			dto = dao.getSameUseridMember(session, userid);
		}finally {
			session.close();
		}
		return dto;
	}

	@Override
	public MemberDTO getSameNameMember(final String name) {
		MemberDTO dto = null;
		
		final SqlSession session = MySqlSessionFactory.getSession();
		try {
			final MemberDAO dao = new MemberDAO();
			dto = dao.getSameNameMember(session, name);
		}finally {
			session.close();
		}
		return dto;
	}

	@Override
	public int registerMember(final MemberDTO dto) {
		int n = 0;
		
		final SqlSession session = MySqlSessionFactory.getSession();
		try {
			final MemberDAO dao = new MemberDAO();
			n = dao.registerMember(session, dto);
			session.commit();
		}finally {
			session.close();
		}
		return n;
	}

	@Override
	public MemberDTO getLoginUserInfo(final LoginDTO loginDTO) {
		MemberDTO dto = null;
		
		final SqlSession session = MySqlSessionFactory.getSession();
		try {
			final MemberDAO dao = new MemberDAO();
			dto = dao.getLoginUserInfo(session, loginDTO);
		}finally {
			session.close();
		}
		return dto;
	}

	@Override
	public int deleteMember(final String userid) {
		int n = 0;
		
		final SqlSession session = MySqlSessionFactory.getSession();
		try {
			final MemberDAO dao = new MemberDAO();
			n = dao.deleteMember(session, userid);
			session.commit();
		}finally {
			session.close();
		}
		return n;
	}

	@Override
	public int updateMember(final MemberDTO dto) {
		int n = 0;
		
		final SqlSession session = MySqlSessionFactory.getSession();
		try {
			final MemberDAO dao = new MemberDAO();
			n = dao.updateMember(session, dto);
			session.commit();
		}finally {
			session.close();
		}
		return n;
	}

}

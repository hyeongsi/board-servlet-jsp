package com.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.dto.MemberDTO;

public class LoginUtil {
	final static String LOGIN_ATTR_STR = "login";
	
	private LoginUtil() {}
	
	// 로그인 여부 반환
	public static boolean isLogin(final HttpServletRequest request) {
		final HttpSession session = request.getSession();
		final MemberDTO dto = (MemberDTO)session.getAttribute(LOGIN_ATTR_STR);
	
		return (dto != null);
	}
	
	// 로그인 유저정보 반환
	public static MemberDTO getLoginUserDTO(final HttpServletRequest request) {
		final HttpSession session = request.getSession();
		final MemberDTO dto = (MemberDTO)session.getAttribute(LOGIN_ATTR_STR);
		
		return dto;
	}
}

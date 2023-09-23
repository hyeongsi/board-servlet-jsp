package com.controller.myprofile;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.common.LoginUtil;
import com.common.TextHtmlUtil;
import com.common.enums.AlertMessage;
import com.common.enums.Location;
import com.service.MemberService;
import com.service.MemberServiceImpl;

@SuppressWarnings("serial")
@WebServlet("/memberDeletion")
public class MemberDeletionServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		final boolean isLogin = LoginUtil.isLogin(request);
		if(!isLogin) {
			TextHtmlUtil.autoProcessNeedLoginLocation(response);
			return;
		}
		
		final String userid = request.getParameter("userid");
		
		final MemberService service = new MemberServiceImpl();
		final int result = service.deleteMember(userid);
		
		final int FAIL_DELETE = 0;
		if(result == FAIL_DELETE) {	
			final String message = AlertMessage.FAILED_DELETE_MEMBER.toString();
			final String location = Location.UI_MY_PROFILE.toString();
			
			TextHtmlUtil.autoProcessMessageAndLocation(response, message, location);
			return;
		}
		
		final HttpSession session = request.getSession();
		session.invalidate();
		
		final String message = AlertMessage.SUCCESS_DELETE_MEMBER.toString();
		final String location = Location.UI_BOARD_REDIRECT.toString();
		TextHtmlUtil.autoProcessMessageAndLocation(response, message, location);
	}

}

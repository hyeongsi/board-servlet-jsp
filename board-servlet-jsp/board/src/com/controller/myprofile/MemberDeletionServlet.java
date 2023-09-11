package com.controller.myprofile;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.common.AlertHref;
import com.common.LoginUser;
import com.common.enums.AlertMessage;
import com.common.enums.SitePath;
import com.service.MemberService;
import com.service.MemberServiceImpl;

@WebServlet("/memberDeletion")
public class MemberDeletionServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final int FAIL_DELETE = 0;
		
		final boolean isLogin = LoginUser.isLogin(request);
		
		final AlertHref href = new AlertHref(request);
		String nextPage = null;
		
		if(isLogin) {
			final String userid = request.getParameter("userid");
			
			final MemberService service = new MemberServiceImpl();
			final int result = service.deleteMember(userid);
			
			if(result == FAIL_DELETE) {	
				nextPage = href.setAlertPath(AlertMessage.FAILED_DELETE_MEMBER, SitePath.MY_PROFILE_UI);
			}else {
				final HttpSession session = request.getSession();
				session.invalidate();  // 로그아웃
				
				nextPage = href.setAlertPath(AlertMessage.SUCCESS_DELETE_MEMBER, SitePath.BOARD_UI);
			}
		}else {			
			// 로그인 필요 메시지, 로그인 화면 이동 설정
			nextPage = href.setNeedLoginPath();
		}
		
		request.getRequestDispatcher(nextPage).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

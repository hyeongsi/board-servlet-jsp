package com.controller.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.common.AlertHref;
import com.common.LoginUser;
import com.common.enums.SitePath;
import com.dto.MemberDTO;

@WebServlet("/logoutUser")
public class LogoutUserServlet extends HttpServlet {    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		final boolean isLogin = LoginUser.isLogin(request);
		
		AlertHref href = new AlertHref(request);
		String nextPage = null;
		
		if(isLogin) {
			nextPage = SitePath.BOARD_UI.getPath();
			
			final HttpSession session = request.getSession();
			session.invalidate();  // 로그아웃
		}else {			
			nextPage = href.setNeedLoginPath();
		}
		
		response.sendRedirect(nextPage);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

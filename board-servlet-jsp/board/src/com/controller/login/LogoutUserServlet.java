package com.controller.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.common.LoginUtil;
import com.common.TextHtmlUtil;
import com.common.enums.Location;

@SuppressWarnings("serial")
@WebServlet("/logoutUser")
public class LogoutUserServlet extends HttpServlet {    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	

		final boolean isLogin = LoginUtil.isLogin(request);
		if(!isLogin) {
			TextHtmlUtil.autoProcessNeedLoginLocation(response);
			return;
		}		
		
		final HttpSession session = request.getSession();
		session.invalidate();
		
		final String location = Location.UI_BOARD_REDIRECT.toString();
		response.sendRedirect(location);
	}

}

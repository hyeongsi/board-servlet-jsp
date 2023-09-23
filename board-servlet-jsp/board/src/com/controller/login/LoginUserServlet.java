package com.controller.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.common.TextHtmlUtil;
import com.common.enums.AlertMessage;
import com.common.enums.Location;
import com.dto.LoginDTO;
import com.dto.MemberDTO;
import com.service.MemberService;
import com.service.MemberServiceImpl;

@SuppressWarnings("serial")
@WebServlet("/loginUser")
public class LoginUserServlet extends HttpServlet {    

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
		final String userid = request.getParameter("userid");
		final String pw = request.getParameter("pw");
		
		final LoginDTO loginDTO = new LoginDTO(userid, pw);
		
		final MemberService service = new MemberServiceImpl();
		final MemberDTO resultDTO = service.getLoginUserInfo(loginDTO);
		
		final boolean isLogin = (resultDTO != null);
		if(!isLogin) {
			final String message = AlertMessage.FAILED_LOGIN.toString();
			final String location = Location.UI_LOGIN_USER.toString();
			
			TextHtmlUtil.autoProcessMessageAndLocation(response, message, location);
			return;
		}
		
		final String location = Location.UI_BOARD_REDIRECT.toString();
		
		final HttpSession session = request.getSession();
		session.setAttribute("login", resultDTO);
		response.sendRedirect(location);
	}
	
}

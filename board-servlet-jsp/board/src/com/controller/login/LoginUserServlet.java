package com.controller.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.common.AlertHref;
import com.common.enums.AlertMessage;
import com.common.enums.SitePath;
import com.dto.LoginDTO;
import com.dto.MemberDTO;
import com.service.MemberService;
import com.service.MemberServiceImpl;

@WebServlet("/loginUser")
public class LoginUserServlet extends HttpServlet {    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
		final String userid = request.getParameter("userid");
		final String pw = request.getParameter("pw");
		
		final LoginDTO loginDTO = new LoginDTO(userid, pw);
		
		final MemberService service = new MemberServiceImpl();
		MemberDTO resultDTO = service.getLoginUserInfo(loginDTO);
		
		final AlertHref href = new AlertHref(request);
		String nextPage = null;
		
		// 로그인 실패
		if(resultDTO == null) {
			nextPage = href.setAlertPath(AlertMessage.FAILED_LOGIN, SitePath.LOGIN_USER_UI);
		}else {
			final HttpSession session = request.getSession();
			session.setAttribute("login", resultDTO);
			
			nextPage = SitePath.BOARD_UI.getPath();
		}
		
		request.getRequestDispatcher(nextPage).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

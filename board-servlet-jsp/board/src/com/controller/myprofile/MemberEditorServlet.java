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
import com.dto.MemberDTO;
import com.service.MemberService;
import com.service.MemberServiceImpl;

@WebServlet("/memberEditor")
public class MemberEditorServlet extends HttpServlet {    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		final int FAIL_UPDATE = 0;
		
		final boolean isLogin = LoginUser.isLogin(request);
		
		final AlertHref href = new AlertHref(request);
		String nextPage = null;
		
		if(isLogin) {
			final String userid = request.getParameter("userid");
			final String pw = request.getParameter("pw");
			final String name = request.getParameter("name");
			
			final MemberDTO editDTO = new MemberDTO(userid, pw, name);
			
			final MemberService service = new MemberServiceImpl();
			final int result = service.updateMember(editDTO);
			
			if(result == FAIL_UPDATE) {
				nextPage = href.setAlertPath(AlertMessage.FAILED_UPDATE_MEMBER, SitePath.BOARD_UI);
			}else {
				nextPage = href.setAlertPath(AlertMessage.SUCCESS_UPDATE_MEMBER, SitePath.BOARD_UI);
			}
		}else {			
			nextPage = href.setNeedLoginPath();
		}
		
		request.getRequestDispatcher(nextPage).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

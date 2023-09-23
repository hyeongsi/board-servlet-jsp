package com.controller.myprofile;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.common.LoginUtil;
import com.common.TextHtmlUtil;
import com.common.enums.AlertMessage;
import com.common.enums.Location;
import com.dto.MemberDTO;
import com.service.MemberService;
import com.service.MemberServiceImpl;

@SuppressWarnings("serial")
@WebServlet("/memberEditor")
public class MemberEditorServlet extends HttpServlet {    

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		final boolean isLogin = LoginUtil.isLogin(request);
		if(!isLogin) {
			TextHtmlUtil.autoProcessNeedLoginLocation(response);
			return;
		}
		
		final String userid = request.getParameter("userid");
		final String pw = request.getParameter("pw");
		final String name = request.getParameter("name");
		
		final MemberDTO editDTO = new MemberDTO(userid, pw, name);
		
		final MemberService service = new MemberServiceImpl();
		final int result = service.updateMember(editDTO);
		
		final int FAIL_UPDATE = 0;
		if(result == FAIL_UPDATE) {
			final String message = AlertMessage.FAILED_UPDATE_MEMBER.toString();
			final String location = Location.UI_BOARD_REDIRECT.toString();
			
			TextHtmlUtil.autoProcessMessageAndLocation(response, message, location);
			return;
		}
			
		final String message = AlertMessage.SUCCESS_UPDATE_MEMBER.toString();
		final String location = Location.UI_BOARD_REDIRECT.toString();
		
		TextHtmlUtil.autoProcessMessageAndLocation(response, message, location);
	}

}

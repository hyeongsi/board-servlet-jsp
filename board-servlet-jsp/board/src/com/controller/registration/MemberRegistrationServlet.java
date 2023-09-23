package com.controller.registration;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.common.TextHtmlUtil;
import com.common.enums.AlertMessage;
import com.common.enums.Location;
import com.dto.MemberDTO;
import com.service.MemberService;
import com.service.MemberServiceImpl;

@SuppressWarnings("serial")
@WebServlet("/memberRegistration")
public class MemberRegistrationServlet extends HttpServlet {    

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		final String userid = request.getParameter("userid");
		final String pw = request.getParameter("pw");
		final String name = request.getParameter("name");
		
		final MemberDTO dto = new MemberDTO(userid, pw, name);
		
		final MemberService service = new MemberServiceImpl();
		final int result = service.registerMember(dto);
			
		final int FAIL_REGISTRATION = 0;
		if(result == FAIL_REGISTRATION) {
			final String message = AlertMessage.FAILED_REGISTER_MEMBER.toString();
			final String location = Location.REGISTER_UI.toString();
			
			TextHtmlUtil.autoProcessMessageAndLocation(response, message, location);
			return;
		}
		
		final String message = AlertMessage.SUCCESS_REGISTER_MEMBER.toString();
		final String location = Location.SUCCESS_REGISTER_MEMBER_JSP.toString();
		
		TextHtmlUtil.autoProcessMessageAndLocation(response, message, location);
	}

}

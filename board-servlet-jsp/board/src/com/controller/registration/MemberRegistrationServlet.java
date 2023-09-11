package com.controller.registration;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.common.AlertHref;
import com.common.enums.AlertMessage;
import com.common.enums.SitePath;
import com.dto.MemberDTO;
import com.service.MemberService;
import com.service.MemberServiceImpl;

@WebServlet("/memberRegistration")
public class MemberRegistrationServlet extends HttpServlet {    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final int FAIL_REGISTRATION = 0;
		
		final String userid = request.getParameter("userid");
		final String pw = request.getParameter("pw");
		final String name = request.getParameter("name");
		
		final MemberDTO dto = new MemberDTO(userid, pw, name);
		
		final MemberService service = new MemberServiceImpl();
		final int result = service.registerMember(dto);
		
		final AlertHref href = new AlertHref(request);
		String nextPage = null;
		
		if(result == FAIL_REGISTRATION) {
			nextPage = href.setAlertPath(AlertMessage.FAILED_REGISTER_MEMBER, 
										SitePath.REGISTER_UI);
		}else {
			nextPage = href.setAlertPath(AlertMessage.SUCCESS_REGISTER_MEMBER, 
										SitePath.SUCCESS_REGISTER_MEMBER);
		}
		
		request.getRequestDispatcher("registerSuccess.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

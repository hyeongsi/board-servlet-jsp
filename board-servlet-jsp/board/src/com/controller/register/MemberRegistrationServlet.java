package com.controller.register;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.MemberDTO;
import com.service.MemberService;
import com.service.MemberServiceImpl;

@WebServlet("/memberRegistration")
public class MemberRegistrationServlet extends HttpServlet {    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final String userid = request.getParameter("userid");
		final String pw = request.getParameter("pw");
		final String name = request.getParameter("name");
		
		final MemberDTO dto = new MemberDTO(userid, pw, name);
		
		final MemberService service = new MemberServiceImpl();
		final int result = service.registerMember(dto);
		
		if(result == 0) {
		}else {}
		
		request.getRequestDispatcher("registerSuccess.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

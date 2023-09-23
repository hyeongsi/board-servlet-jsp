package com.controller.registration;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.common.enums.Location;

@SuppressWarnings("serial")
@WebServlet("/memberRegistrationUI")
public class MemberRegistrationUIServlet extends HttpServlet {    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		final String location = Location.MEMBER_REGISTRATION_JSP.toString();
		request.getRequestDispatcher(location).forward(request, response);
	}
	
}

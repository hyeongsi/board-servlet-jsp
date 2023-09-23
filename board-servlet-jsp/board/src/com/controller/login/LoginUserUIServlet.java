package com.controller.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.common.enums.Location;

@SuppressWarnings("serial")
@WebServlet("/loginUserUI")
public class LoginUserUIServlet extends HttpServlet {    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final String location = Location.LOGIN_USER_JSP.toString();
		request.getRequestDispatcher(location).forward(request, response);
	}

}

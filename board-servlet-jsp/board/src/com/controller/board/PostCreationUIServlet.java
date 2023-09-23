package com.controller.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.common.LoginUtil;
import com.common.TextHtmlUtil;
import com.common.enums.Location;

@SuppressWarnings("serial")
@WebServlet("/postCreationUI")
public class PostCreationUIServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		final boolean isLogin = LoginUtil.isLogin(request);
		if(!isLogin) {	
			TextHtmlUtil.autoProcessNeedLoginLocation(response);
			return;
		}
		
		final String location = Location.POST_CREATION_JSP.toString();
		request.getRequestDispatcher(location).forward(request, response);
	}

}

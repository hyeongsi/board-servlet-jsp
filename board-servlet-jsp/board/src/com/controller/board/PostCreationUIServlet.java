package com.controller.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.common.AlertHref;
import com.common.LoginUser;
import com.common.enums.SitePath;

@WebServlet("/postCreationUI")
public class PostCreationUIServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		final boolean isLogin = LoginUser.isLogin(request);
		
		final AlertHref href = new AlertHref(request);
		String nextPage = null;
		 
		if(isLogin) {	
			nextPage = SitePath.POST_CREATION.getPath();
		}else {			
			// 로그인 필요 메시지, 로그인 화면 이동 설정
			nextPage = href.setNeedLoginPath();
		}
		
		request.getRequestDispatcher(nextPage).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

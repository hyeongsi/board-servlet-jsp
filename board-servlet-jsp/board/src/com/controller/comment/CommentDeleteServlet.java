package com.controller.comment;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.common.AlertHref;
import com.common.LoginUser;
import com.common.enums.SitePath;
import com.dto.MemberDTO;
import com.service.CommentService;
import com.service.CommentServiceImpl;

@WebServlet("/CommentDelete")
public class CommentDeleteServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		final boolean isLogin = LoginUser.isLogin(request);
		
		final AlertHref href = new AlertHref(request);
		String nextPage = null;
		
		if(!isLogin) {	
			nextPage = href.setNeedLoginPath();
			request.getRequestDispatcher(nextPage).forward(request, response);
			return;
		}		
			
		int commentid = Integer.parseInt(request.getParameter("commentid"));
		int boardid = Integer.parseInt(request.getParameter("boardid"));
		
		MemberDTO memberDTO = LoginUser.getLoginUserDTO(request);
		int id = Integer.parseInt(request.getParameter("id"));
		
		if(id == memberDTO.getId()) {
			CommentService service = new CommentServiceImpl();
			service.deleteComment(commentid);
		}
		
		nextPage = SitePath.POST_DETAIL_RETRIEVE.getPath() + "?boardid=" + boardid;
		response.sendRedirect(nextPage);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

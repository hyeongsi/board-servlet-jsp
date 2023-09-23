package com.controller.comment;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.common.LoginUtil;
import com.common.TextHtmlUtil;
import com.common.enums.Location;
import com.dto.MemberDTO;
import com.service.CommentService;
import com.service.CommentServiceImpl;

@SuppressWarnings("serial")
@WebServlet("/CommentDeletion")
public class CommentDeletionServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		final boolean isLogin = LoginUtil.isLogin(request);
		if(!isLogin) {	
			TextHtmlUtil.autoProcessNeedLoginLocation(response);
			return;
		}		
			
		final int commentid = Integer.parseInt(request.getParameter("commentid"));
		final int boardid = Integer.parseInt(request.getParameter("boardid"));
		final int id = Integer.parseInt(request.getParameter("id"));
		
		final MemberDTO memberDTO = LoginUtil.getLoginUserDTO(request);
		final boolean isSameWriterAndDeleter = (id == memberDTO.getId());
		if(isSameWriterAndDeleter) {
			CommentService service = new CommentServiceImpl();
			service.deleteComment(commentid);
		}
		
		final String url = Location.UI_POST_DETAIL.toString();
		final String location = url + "?boardid=" + boardid;
		response.sendRedirect(location);
	}

}

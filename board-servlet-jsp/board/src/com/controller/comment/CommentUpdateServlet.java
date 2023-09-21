package com.controller.comment;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.common.AlertHref;
import com.common.LoginUser;
import com.common.OverflowCheck;
import com.common.OverflowCheck.LengthB;
import com.common.enums.AlertMessage;
import com.common.enums.SitePath;
import com.dto.CommentDTO;
import com.dto.MemberDTO;
import com.service.CommentService;
import com.service.CommentServiceImpl;

@WebServlet("/CommentUpdate")
public class CommentUpdateServlet extends HttpServlet {

	final static int FAIL_UPDATE = 0;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean isLogin = LoginUser.isLogin(request);
		
		final AlertHref href = new AlertHref(request);
		String nextPage = null;
		
		if(!isLogin) {
			nextPage = href.setNeedLoginPath();
			request.getRequestDispatcher(nextPage).forward(request, response);
			return;
		}
		final MemberDTO memberDTO = LoginUser.getLoginUserDTO(request);
		
		final String content = request.getParameter("content");
		final int boardid = Integer.parseInt(request.getParameter("boardid"));
		final int writerid = Integer.parseInt(request.getParameter("writerid"));
		final int commentid = Integer.parseInt(request.getParameter("commentid"));
		final int id = memberDTO.getId();
		
		int result = FAIL_UPDATE;
		// overflow가 아니라면 update 수행
		final int commentBytes = OverflowCheck.getBytesUtf8(content);
		if(writerid != id) {
			nextPage = SitePath.POST_DETAIL_RETRIEVE.getPath() + "?boardid=" + boardid;
			response.sendRedirect(nextPage);
			return;
		}
		
		if(!(OverflowCheck.isOverflow(commentBytes, LengthB.COMMENT_LENGTHB))) {
			CommentDTO dto = new CommentDTO();
			dto.setCommentid(commentid);
			dto.setContent(content);
			
			final CommentService service = new CommentServiceImpl();
			result = service.updateComment(content, dto);
		}

		// 작성 실패 메시지 등록
		if(result == FAIL_UPDATE) {
			nextPage = href.setAlertPath(AlertMessage.FAILED_UPDATE_COMMENT, SitePath.POST_DETAIL_UI);
			request.getRequestDispatcher(nextPage).forward(request, response);
			return;
		}
			
		nextPage = SitePath.POST_DETAIL_RETRIEVE.getPath() + "?boardid=" + boardid;
		response.sendRedirect(nextPage);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

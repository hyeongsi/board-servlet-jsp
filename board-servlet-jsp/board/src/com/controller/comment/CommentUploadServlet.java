package com.controller.comment;

import java.io.IOException;
import java.io.PrintWriter;

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

@WebServlet("/CommentUpload")
public class CommentUploadServlet extends HttpServlet {

	final static int FAIL_UPLOAD = 0;
	
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
		final String parent_commentid_str = request.getParameter("parent_commentid");
		Integer parent_commentid = null;
		if(parent_commentid_str != null) {
			parent_commentid = Integer.parseInt(parent_commentid_str);
		}
		final int boardid = Integer.parseInt(request.getParameter("boardid"));
		final int id = memberDTO.getId();
		
		int result = FAIL_UPLOAD;
		// overflow가 아니라면 update 수행
		final int commentBytes = OverflowCheck.getBytesUtf8(content);
		
		if(!(OverflowCheck.isOverflow(commentBytes, LengthB.COMMENT_LENGTHB))) {
			
			CommentDTO commentDTO = new CommentDTO();
			commentDTO.setContent(content);
			commentDTO.setParent_commentid(parent_commentid);
			commentDTO.setBoardid(boardid);
			commentDTO.setId(id);
			
			final CommentService service = new CommentServiceImpl();
			result = service.uploadComment(commentDTO);
		}

		// 작성 실패 메시지 등록
		if(result == FAIL_UPLOAD) {
			nextPage = href.setAlertPath(AlertMessage.FAILED_UPLOAD_COMMENT, SitePath.POST_DETAIL_UI);
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

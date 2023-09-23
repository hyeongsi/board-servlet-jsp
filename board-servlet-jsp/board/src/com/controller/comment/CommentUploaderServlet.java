package com.controller.comment;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.common.LoginUtil;
import com.common.OverflowCheck;
import com.common.OverflowCheck.LengthB;
import com.common.TextHtmlUtil;
import com.common.enums.AlertMessage;
import com.common.enums.Location;
import com.dto.CommentDTO;
import com.dto.MemberDTO;
import com.service.CommentService;
import com.service.CommentServiceImpl;

@SuppressWarnings("serial")
@WebServlet("/CommentUploader")
public class CommentUploaderServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		boolean isLogin = LoginUtil.isLogin(request);
		if(!isLogin) {
			TextHtmlUtil.autoProcessNeedLoginLocation(response);
			return;
		}
		
		final String content = request.getParameter("content");
		final String parent_commentid_str = request.getParameter("parent_commentid");
		final String boardid = request.getParameter("boardid");
		
		final MemberDTO memberDTO = LoginUtil.getLoginUserDTO(request);
		final int id = memberDTO.getId();
		
		final boolean isEmptyContent = content.trim().isEmpty();
		if(isEmptyContent) {
			failUpload(response, boardid);
			return;
		}
		
		Integer parent_commentid = null;
		if(parent_commentid_str != null) {
			parent_commentid = Integer.parseInt(parent_commentid_str);
		}
		
		final int FAIL_UPLOAD = 0;
		int result = FAIL_UPLOAD;

		final int commentBytes = OverflowCheck.getBytesUtf8(content);
		final boolean isOverflowComment = OverflowCheck.isOverflow(commentBytes, LengthB.COMMENT_LENGTHB);
		
		if(!(isOverflowComment)) {
			CommentDTO commentDTO = new CommentDTO();
			commentDTO.setContent(content);
			commentDTO.setParent_commentid(parent_commentid);
			commentDTO.setBoardid(Integer.parseInt(boardid));
			commentDTO.setId(id);
			
			final CommentService service = new CommentServiceImpl();
			result = service.uploadComment(commentDTO);
		}

		if(result == FAIL_UPLOAD) {
			failUpload(response, boardid);
			return;
		}
			
		final String url = Location.UI_POST_DETAIL.toString();
		final String location = url + "?boardid=" + boardid;
		response.sendRedirect(location);
	}
	
	private void failUpload(final HttpServletResponse response, final String boardid) throws IOException {
		
		final String message = AlertMessage.FAILED_UPLOAD_COMMENT.toString();
		final String url = Location.UI_POST_DETAIL.toString();
		final String location = url + "?boardid=" + boardid;
		
		TextHtmlUtil.autoProcessMessageAndLocation(response, message, location);
	}

}

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
@WebServlet("/CommentEditor")
public class CommentEditorServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		boolean isLogin = LoginUtil.isLogin(request);
		if(!isLogin) {
			TextHtmlUtil.autoProcessNeedLoginLocation(response);
			return;
		}
		
		final String content = request.getParameter("content");
		final String boardid = request.getParameter("boardid");
		final int writerid = Integer.parseInt(request.getParameter("writerid"));
		final int commentid = Integer.parseInt(request.getParameter("commentid"));
		
		final MemberDTO memberDTO = LoginUtil.getLoginUserDTO(request);
		final int id = memberDTO.getId();
		
		final boolean isEmptyContent = content.trim().isEmpty();
		if(isEmptyContent) {	
			failEdit(response, boardid);
			return;
		}
		
		final boolean isSameWriterAndEditor = (id == writerid);
		if(!isSameWriterAndEditor) {
			failEdit(response, boardid);
			return;
		}
		
		final int FAIL_UPDATE = 0;
		int result = FAIL_UPDATE;
		
		final int commentBytes = OverflowCheck.getBytesUtf8(content);
		final boolean isOverflowComment = OverflowCheck.isOverflow(commentBytes, LengthB.COMMENT_LENGTHB);
		
		if(!isOverflowComment) {
			CommentDTO dto = new CommentDTO();
			dto.setCommentid(commentid);
			dto.setContent(content);
			
			final CommentService service = new CommentServiceImpl();
			result = service.updateComment(content, dto);
		}

		if(result == FAIL_UPDATE) {
			failEdit(response, boardid);
			return;
		}
			
		final String url = Location.UI_POST_DETAIL.toString();
		final String location = url + "?boardid=" + boardid;
		response.sendRedirect(location);
	}
	
	private void failEdit(final HttpServletResponse response, final String boardid) throws IOException {
		
		final String message = AlertMessage.FAILED_EDIT_COMMENT.toString();
		final String url = Location.UI_POST_DETAIL.toString();
		final String location = url + "?boardid=" + boardid;
		
		TextHtmlUtil.autoProcessMessageAndLocation(response, message, location);
	}

}

package com.controller.board;

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
import com.service.BoardService;
import com.service.BoardServiceImpl;

@SuppressWarnings("serial")
@WebServlet("/postEditor")
public class PostEditorServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		final boolean isLogin = LoginUtil.isLogin(request);
		if(!isLogin) {
			TextHtmlUtil.autoProcessNeedLoginLocation(response);
			return;
		}
			
		final int boardid = Integer.parseInt(request.getParameter("boardid"));
		final String title = request.getParameter("title");
		final String boardcontent = request.getParameter("boardcontent");
		
		final boolean isEmptyTitle = title.trim().isEmpty();
		if(isEmptyTitle) {
			final String message = AlertMessage.FAILED_EDIT_POST.toString();
			final String location = Location.UI_BOARD.toString();
			
			TextHtmlUtil.autoProcessMessageAndLocation(response, message, location);
			return;
		}
		
		final int FAIL_UPDATE = 0;
		int result = FAIL_UPDATE;
		
		final int titleBytes = OverflowCheck.getBytesUtf8(title);
		final int contentBytes = OverflowCheck.getBytesUtf8(boardcontent);
		
		final boolean isOverflowTitle = OverflowCheck.isOverflow(titleBytes, LengthB.TITLE_LENGTHB);
		final boolean isOverflowContent = OverflowCheck.isOverflow(contentBytes, LengthB.CONTENT_LENGTHB);
		
		final boolean isOverflow = isOverflowTitle || isOverflowContent;
		if(!isOverflow) {
			final BoardService service = new BoardServiceImpl();
			result = service.updatePost(boardid, title, boardcontent);
		}

		String message = null;
		String location = null;

		if(result == FAIL_UPDATE) {
			message = AlertMessage.FAILED_EDIT_POST.toString();
			location = Location.UI_BOARD_REDIRECT.toString();
		}
		else {
			message = AlertMessage.SUCCESS_EDIT_POST.toString();
			location = Location.UI_BOARD_REDIRECT.toString();
		}
		
		TextHtmlUtil.autoProcessMessageAndLocation(response, message, location);
	}

}

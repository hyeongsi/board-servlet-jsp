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
import com.dto.MemberDTO;
import com.service.BoardService;
import com.service.BoardServiceImpl;

@SuppressWarnings("serial")
@WebServlet("/postCreation")
public class PostCreationServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		final boolean isLogin = LoginUtil.isLogin(request);
		if(!isLogin) {
			TextHtmlUtil.autoProcessNeedLoginLocation(response);
			return;
		}
		
		final MemberDTO loginUserDTO = LoginUtil.getLoginUserDTO(request);
		
		final String title = request.getParameter("title");
		final String boardcontent = request.getParameter("boardcontent");
		final String name = loginUserDTO.getName();
		final int id = loginUserDTO.getId();
		
		final boolean isEmptyTitle = title.trim().isEmpty();
		if(isEmptyTitle) {
			failUpload(response);
			return;
		}
		
		final int FAIL_UPLOAD = 0;
		int result = FAIL_UPLOAD;
		
		final int titleBytes = OverflowCheck.getBytesUtf8(title);
		final int contentBytes = OverflowCheck.getBytesUtf8(boardcontent);
	
		final boolean isOverflowTitle = OverflowCheck.isOverflow(titleBytes, LengthB.TITLE_LENGTHB);
		final boolean isOverflowContent = OverflowCheck.isOverflow(contentBytes, LengthB.CONTENT_LENGTHB);
		
		final boolean isOverflow = isOverflowTitle || isOverflowContent;
		if(!isOverflow) {
			final BoardService service = new BoardServiceImpl();
			result = service.uploadPost(title, boardcontent, name, id);
		}
		
		if(result == FAIL_UPLOAD) {
			failUpload(response);
			return;
		}
		
		final String location = Location.UI_BOARD_REDIRECT.toString();
		response.sendRedirect(location);
	}
	
	private void failUpload(final HttpServletResponse response) throws IOException {
		
		final String message = AlertMessage.FAILED_UPLOAD_POST.toString();
		final String location = Location.UI_POST_CREATION.toString();
		
		TextHtmlUtil.autoProcessMessageAndLocation(response, message, location);
	}

}

package com.controller.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.common.LoginUtil;
import com.common.TextHtmlUtil;
import com.common.enums.AlertMessage;
import com.common.enums.Location;
import com.service.BoardService;
import com.service.BoardServiceImpl;

@SuppressWarnings("serial")
@WebServlet("/postDeletion")
public class PostDeletionServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		final boolean isLogin = LoginUtil.isLogin(request);
		if(!isLogin) {
			TextHtmlUtil.autoProcessNeedLoginLocation(response);
			return;
		}
			
		final int boardid = Integer.parseInt(request.getParameter("boardid"));
		
		final BoardService service = new BoardServiceImpl();
		final int result = service.deletePost(boardid);
		
		final int FAIL_DELETE = 0;
		String message = null;
		String location = null;
		
		if(result == FAIL_DELETE) {
			message = AlertMessage.FAILED_DELETE_POST.toString();
			location = Location.UI_POST_DETAIL.toString();
		}else {
			message = AlertMessage.SUCCESS_DELETE_POST.toString();
			location = Location.UI_BOARD_REDIRECT.toString();
		}
		
		TextHtmlUtil.autoProcessMessageAndLocation(response, message, location);
	}

}

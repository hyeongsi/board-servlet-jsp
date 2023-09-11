package com.controller.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.common.AlertHref;
import com.common.LoginUser;
import com.common.enums.AlertMessage;
import com.common.enums.SitePath;
import com.service.BoardService;
import com.service.BoardServiceImpl;

@WebServlet("/postEditor")
public class PostEditorServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final int FAIL_UPDATE = 0;
		
		boolean isLogin = LoginUser.isLogin(request);
		
		final AlertHref href = new AlertHref(request);
		String nextPage = null;
		
		if(isLogin) {
			final int boardid = Integer.parseInt(request.getParameter("boardid"));
			final String title = request.getParameter("title");
			final String boardcontent = request.getParameter("boardcontent");
			
			final BoardService service = new BoardServiceImpl();
			final int result = service.updatePost(boardid, title, boardcontent);
			
			// 수정 실패
			if(result == FAIL_UPDATE) {
				nextPage = href.setAlertPath(AlertMessage.FAILED_UPDATE_POST, SitePath.BOARD_UI);
			}
			// 수정 성공
			else {
				nextPage = href.setAlertPath(AlertMessage.SUCCESS_UPDATE_POST, SitePath.BOARD_UI);
			}

		}else {
			nextPage = href.setNeedLoginPath();
		}
		
		request.getRequestDispatcher(nextPage).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

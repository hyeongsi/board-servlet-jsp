package com.controller.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.common.AlertHref;
import com.common.LoginUser;
import com.common.enums.AlertMessage;
import com.common.enums.SitePath;
import com.dto.MemberDTO;
import com.service.BoardService;
import com.service.BoardServiceImpl;

@WebServlet("/postDeletion")
public class PostDeletionServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		final int FAIL_DELETE = 0;
		
		final boolean isLogin = LoginUser.isLogin(request);
		
		final AlertHref href = new AlertHref(request);
		String nextPage = null;
		
		if(isLogin) {
			final int boardid = Integer.parseInt(request.getParameter("boardid"));
			
			final BoardService service = new BoardServiceImpl();
			final int result = service.deletePost(boardid);
			
			if(result == FAIL_DELETE) {
				// 삭제 실패 메시지, 글 상세 화면 이동 설정
				nextPage = href.setAlertPath(AlertMessage.FAILED_DELETE_POST, SitePath.POST_DETAIL_UI);
			}else {
				// 삭제 성공 메시지, 메인화면(게시글) 이동 설정
				nextPage = href.setAlertPath(AlertMessage.SUCCESS_DELETE_POST, SitePath.BOARD_UI);
			}
		}else {
			// 로그인 필요 메시지, 로그인 화면 이동 설정
			nextPage = href.setNeedLoginPath();
		}
		
		request.getRequestDispatcher(nextPage).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

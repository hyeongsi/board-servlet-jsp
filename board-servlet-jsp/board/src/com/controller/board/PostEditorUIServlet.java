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
import com.dto.BoardDTO;
import com.dto.MemberDTO;
import com.service.BoardService;
import com.service.BoardServiceImpl;

@WebServlet("/postEditorUI")
public class PostEditorUIServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		final boolean isLogin = LoginUser.isLogin(request); 
		
		final AlertHref href = new AlertHref(request);
		String nextPage = null;
		
		if(isLogin) {
			final int boardid = Integer.parseInt(request.getParameter("boardid"));
			
			final BoardService service = new BoardServiceImpl();
			final BoardDTO boardDTO = service.getPostDetail(boardid);
			if(boardDTO != null) {
				request.setAttribute("boardDTO", boardDTO);
				nextPage = SitePath.POST_EDITOR.getPath();
			}else {
				// 없는 게시글 메시지, 메인화면(게시글) 이동 설정
				nextPage = href.setAlertPath(AlertMessage.NOT_EXIST_POST, SitePath.BOARD_UI);
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

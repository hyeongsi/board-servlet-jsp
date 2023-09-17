package com.controller.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.common.AlertHref;
import com.common.enums.AlertMessage;
import com.common.enums.SitePath;
import com.dto.BoardDTO;
import com.service.BoardSelectService;
import com.service.BoardSelectServiceImpl;
import com.service.BoardService;
import com.service.BoardServiceImpl;

@WebServlet("/postDetailUI")
public class PostDetailUIServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		final int boardid = Integer.parseInt(request.getParameter("boardid"));
		
		// 게시글 상세내용 읽어오기
		final BoardSelectService selectService = new BoardSelectServiceImpl();
		final BoardDTO boardDTO = selectService.getPostDetail(boardid);
		
		final AlertHref href = new AlertHref(request);
		String nextPage = null;
		
		if(boardDTO != null) {
			// 조회수 증가
			final BoardService service = new BoardServiceImpl();
			service.increaseViewcnt(boardid);
			
			request.setAttribute("boardDTO", boardDTO);
			nextPage = SitePath.POST_DETAIL.getPath();
		}else {
			// 조회 실패 메시지, 메인화면(게시글) 이동 설정
			nextPage = href.setAlertPath(AlertMessage.NOT_EXIST_POST, SitePath.BOARD_UI);
		}
		
		request.getRequestDispatcher(nextPage).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

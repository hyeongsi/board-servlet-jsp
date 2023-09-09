package com.controller.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.BoardDTO;
import com.dto.MemberDTO;
import com.service.BoardService;
import com.service.BoardServiceImpl;

@WebServlet("/boardDetailUI")
public class BoardDetailUIServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String boardidStr = request.getParameter("boardid");
		int boardid = Integer.parseInt(boardidStr);
		
		// 게시글 상세내용 읽어오기
		BoardService service = new BoardServiceImpl();
		BoardDTO boardDTO = service.boardDetail(boardid);
		
		String nextPage = null;
		if(boardDTO != null) {
			// 조회수 증가
			service.increaseViewcnt(boardid);
			
			request.setAttribute("BoardDTO", boardDTO);
			nextPage = "boardDetail.jsp";
		}else {
			request.setAttribute("mesg", "게시글이 존재하지 않습니다.");
			nextPage = "board/boardAlert.jsp";
		}
		
		request.getRequestDispatcher(nextPage).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

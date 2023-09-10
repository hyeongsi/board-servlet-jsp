package com.controller.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.MemberDTO;
import com.service.BoardService;
import com.service.BoardServiceImpl;

@WebServlet("/postEditor")
public class PostEditorServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final HttpSession session = request.getSession();
		final MemberDTO dto = (MemberDTO)session.getAttribute("login");
		
		String nextPage = null;
		String mesg = null;
		if(dto != null) {
			final int boardid = Integer.parseInt(request.getParameter("boardid"));
			final String title = request.getParameter("title");
			final String boardcontent = request.getParameter("boardcontent");
			
			final BoardService service = new BoardServiceImpl();
			final int result = service.updatePost(boardid, title, boardcontent);
			
			if(result == 0) {
				mesg = "게시글 수정 실패";
			}else {
				mesg = "게시글 수정 완료";
			}
			request.setAttribute("mesg", mesg);
			nextPage = "board/boardAlert.jsp";
		}else {			
			nextPage = "member/needLogin.jsp";
		}
		
		request.getRequestDispatcher(nextPage).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

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

@WebServlet("/postEditorUI")
public class PostEditorUIServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final HttpSession session = request.getSession();
		final MemberDTO dto = (MemberDTO)session.getAttribute("login");
		
		String nextPage = null;
		if(dto != null) {
			final int boardid = Integer.parseInt(request.getParameter("boardid"));
			
			final BoardService service = new BoardServiceImpl();
			final BoardDTO boardDTO = service.getPostDetail(boardid);
			if(boardDTO != null) {
				request.setAttribute("boardDTO", boardDTO);
				nextPage = "postEditor.jsp";
			}else {
				request.setAttribute("mesg", "게시글이 존재하지 않습니다.");
				nextPage = "boardAlert.jsp";
			}
		}else {			
			nextPage = "member/needLogin.jsp";
		}
		
		request.getRequestDispatcher(nextPage).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

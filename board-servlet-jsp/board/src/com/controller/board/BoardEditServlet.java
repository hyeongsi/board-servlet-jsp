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

@WebServlet("/boardEdit")
public class BoardEditServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberDTO dto = (MemberDTO)session.getAttribute("login");
		
		String nextPage = null;
		String mesg = null;
		if(dto != null) {
			String boardidStr = request.getParameter("boardid");
			
			int boardid = Integer.parseInt(boardidStr);
			String title = request.getParameter("title");
			String boardcontent = request.getParameter("boardcontent");
			
			BoardService service = new BoardServiceImpl();
			int n = service.updateBoard(boardid, title, boardcontent);
			
			if(n == 0) {
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

package com.controller.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.common.TextHtmlUtil;
import com.common.enums.AlertMessage;
import com.common.enums.Location;
import com.dto.BoardDTO;
import com.dto.CommentDTO;
import com.service.BoardSelectService;
import com.service.BoardSelectServiceImpl;
import com.service.BoardService;
import com.service.BoardServiceImpl;
import com.service.CommentService;
import com.service.CommentServiceImpl;

@SuppressWarnings("serial")
@WebServlet("/postDetailUI")
public class PostDetailUIServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		final int boardid = Integer.parseInt(request.getParameter("boardid"));
		
		final BoardSelectService selectService = new BoardSelectServiceImpl();
		final BoardDTO boardDTO = selectService.getPostDetail(boardid);
		
		if(boardDTO == null) {
			final String message = AlertMessage.NOT_EXIST_POST.toString();
			final String location = Location.UI_BOARD.toString();
			
			TextHtmlUtil.autoProcessMessageAndLocation(response, message, location);
			return;
		}
			
		final BoardService service = new BoardServiceImpl();
		service.increaseViewcnt(boardid);
		
		final String location = Location.POST_DETAIL_JSP.toString();
		
		final CommentService commentService = new CommentServiceImpl();
		List<CommentDTO> commentDTOList = commentService.getComment(boardid);

		request.setAttribute("boardDTO", boardDTO);
		request.setAttribute("commentDTOList", commentDTOList);
		request.getRequestDispatcher(location).forward(request, response);
	}

}

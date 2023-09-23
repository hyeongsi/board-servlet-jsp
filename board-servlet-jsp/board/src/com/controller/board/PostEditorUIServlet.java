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
import com.dto.BoardDTO;
import com.service.BoardSelectService;
import com.service.BoardSelectServiceImpl;

@SuppressWarnings("serial")
@WebServlet("/postEditorUI")
public class PostEditorUIServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		final boolean isLogin = LoginUtil.isLogin(request); 	
		if(!isLogin) {
			TextHtmlUtil.autoProcessNeedLoginLocation(response);
			return;
		}	

		final int boardid = Integer.parseInt(request.getParameter("boardid"));
		
		final BoardSelectService service = new BoardSelectServiceImpl();
		final BoardDTO boardDTO = service.getPostDetail(boardid);
		
		if(boardDTO == null) {
			final String message = AlertMessage.NOT_EXIST_POST.toString();
			final String location = Location.UI_BOARD_REDIRECT.toString();
			
			TextHtmlUtil.autoProcessMessageAndLocation(response, message, location);
			return;
		}
		
		final String location = Location.POST_EDITOR_JSP.toString();
		
		request.setAttribute("boardDTO", boardDTO);
		request.getRequestDispatcher(location).forward(request, response);
	}

}

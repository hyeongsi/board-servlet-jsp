package com.controller.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.PageDTO;
import com.service.BoardService;
import com.service.BoardServiceImpl;

@WebServlet("/boardUI")
public class BoardUIServlet extends HttpServlet {    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final String curPageStr = request.getParameter("curPage");
		
		int curPage = 1;
		if(curPageStr != null) {
			try {
				curPage = Integer.parseInt(curPageStr);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		final BoardService service = new BoardServiceImpl();
		final PageDTO pageDTO = service.list(curPage);

		request.setAttribute("pageDTO", pageDTO);
		request.getRequestDispatcher("board.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

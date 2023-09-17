package com.controller.board;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.common.enums.SitePath;
import com.dto.PageDTO;
import com.service.BoardSelectService;
import com.service.BoardSelectServiceImpl;

@WebServlet("/boardUI")
public class BoardUIServlet extends HttpServlet {    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		final String searchType = request.getParameter("searchType");
		if(searchType != null && !searchType.isEmpty()) {
			request.getRequestDispatcher(SitePath.POST_SEARCH.getPath()).forward(request, response);
			return;
		}
		
		int curPage = 1;
		final String curPageStr = request.getParameter("curPage");
		if(curPageStr != null)
			curPage = Integer.parseInt(curPageStr);
		
		// 현재 페이지 기준의 게시글 리스트 얻기
		final BoardSelectService service = new BoardSelectServiceImpl();
		final PageDTO pageDTO = service.getPageInfo(curPage);
		
		String writetime = pageDTO.getList().get(0).getPageRenderingWritetime();
		
		// 메인화면(게시글) 화면 이동
		final String path = SitePath.BOARD.getPath();
		if(pageDTO != null)
			request.setAttribute("pageDTO", pageDTO);
		
		request.getRequestDispatcher(path).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

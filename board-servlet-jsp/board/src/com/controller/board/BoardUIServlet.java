package com.controller.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.common.enums.Location;
import com.dto.PageDTO;
import com.service.BoardSelectService;
import com.service.BoardSelectServiceImpl;

@SuppressWarnings("serial")
@WebServlet("/boardUI")
public class BoardUIServlet extends HttpServlet {    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		final String searchType = request.getParameter("searchType");
		final boolean isSearch = (searchType != null && !searchType.isEmpty());
		if(isSearch) {
			request.getRequestDispatcher(Location.SEARCH_POST.toString())
					.forward(request, response);
			return;
		}
		
		int curPage = 1;
		
		final String curPageParam = request.getParameter("curPage");
		if(curPageParam != null)
			curPage = Integer.parseInt(curPageParam);
		
		final BoardSelectService service = new BoardSelectServiceImpl();
		final PageDTO pageDTO = service.getPageInfo(curPage);
		
		request.setAttribute("pageDTO", pageDTO);
		
		final String location = Location.BOARD_JSP.toString();
		request.getRequestDispatcher(location).forward(request, response);
	}
	
}

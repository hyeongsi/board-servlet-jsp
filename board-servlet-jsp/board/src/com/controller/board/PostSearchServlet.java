package com.controller.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.common.enums.SitePath;
import com.dto.PageDTO;
import com.dto.SearchDTO;
import com.service.BoardSelectService;
import com.service.BoardSelectServiceImpl;

@WebServlet("/postSearchServlet")
public class PostSearchServlet extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int curPage = 1;
		final String curPageStr = request.getParameter("curPage");
		if(curPageStr != null)
			curPage = Integer.parseInt(curPageStr);
		
		final String searchType = request.getParameter("searchType");
		final String search = request.getParameter("search");
		
		final SearchDTO searchDTO = new SearchDTO();
		searchDTO.setSearchType(searchType);
		searchDTO.setSearch(search);
		
		// 현재 페이지 기준의 게시글 리스트 얻기
		final BoardSelectService service = new BoardSelectServiceImpl();
		PageDTO pageDTO = null;
		
		switch (searchType) {
		case "title":
			pageDTO = service.getSearchTitlePageInfo(curPage, search);
			break;
		case "content":
			pageDTO = service.getSearchContentPageInfo(curPage, search);
			break;
		case "name":
			pageDTO = service.getSearchNamePageInfo(curPage, search);
			break;
		default:
			response.sendRedirect(SitePath.BOARD_UI.getPath());
			return;
		}

		// 메인화면(게시글) 화면 이동
		final String path = SitePath.BOARD.getPath();
		if(pageDTO != null)
			request.setAttribute("pageDTO", pageDTO);
		// 페이지네이션 검색에 활용하기 위해 저장
		request.setAttribute("searchDTO", searchDTO);
		
		request.getRequestDispatcher(path).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

package com.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.BoardDAO;
import com.dao.BoardSelectDAO;
import com.dto.BoardDTO;
import com.dto.PageDTO;
import com.dto.SearchDTO;

public class BoardSelectServiceImpl implements BoardSelectService {

	@Override
	public PageDTO getPageInfo(final int curPage) {
		final SqlSession session = MySqlSessionFactory.getSession();
		PageDTO pageDTO = null;
		
		try {	
			// 가져올 작성글의 첫 인덱스, 첫 인덱스부터 가져올 글의 개수 연산
			final int offset = PageDTO.getOffset(curPage);
			final int limit = PageDTO.getLimit();
			
			// 현재 페이지의 작성글 리스트 획득
			final BoardSelectDAO boardSelectDAO = new BoardSelectDAO();
			List<BoardDTO> list = boardSelectDAO.getPosts(session, curPage, offset, limit);
			
			// 전체 작성글 개수 획득
			final int totalCount = boardSelectDAO.getTotalCount(session);	
			
			pageDTO = new PageDTO(curPage);
			pageDTO.setList(list);
			pageDTO.setTotalCount(totalCount);
			pageDTO.calcTotalPage();
			pageDTO.calcStartPage();
			pageDTO.calcEndPage();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return pageDTO;
	}
	
	@Override
	public PageDTO getSearchTitlePageInfo(final int curPage, final String search) {
		final SqlSession session = MySqlSessionFactory.getSession();
		PageDTO pageDTO = null;
		
		try {	
			// 가져올 작성글의 첫 인덱스, 첫 인덱스부터 가져올 글의 개수 연산
			final int offset = PageDTO.getOffset(curPage);
			final int limit = PageDTO.getLimit();
			
			final SearchDTO searchDTO = new SearchDTO();
			searchDTO.setSearch(search);
			searchDTO.setOffset(offset);
			searchDTO.setLimit(limit);
			
			// 현재 페이지의 작성글 리스트 획득
			final BoardSelectDAO boardSelectDAO = new BoardSelectDAO();
			List<BoardDTO> list = boardSelectDAO.getPostsAsTitle(session, searchDTO);
			
			// 전체 작성글 개수 획득
			final int totalCount = boardSelectDAO.getSearchTitleTotalCount(session, search);
			
			pageDTO = new PageDTO(curPage);
			pageDTO.setList(list);
			pageDTO.setTotalCount(totalCount);
			pageDTO.calcTotalPage();
			pageDTO.calcStartPage();
			pageDTO.calcEndPage();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return pageDTO;
	}

	@Override
	public PageDTO getSearchContentPageInfo(final int curPage, final String search) {
		final SqlSession session = MySqlSessionFactory.getSession();
		PageDTO pageDTO = null;
		
		try {	
			// 가져올 작성글의 첫 인덱스, 첫 인덱스부터 가져올 글의 개수 연산
			final int offset = PageDTO.getOffset(curPage);
			final int limit = PageDTO.getLimit();
			
			final SearchDTO searchDTO = new SearchDTO();
			searchDTO.setSearch(search);
			searchDTO.setOffset(offset);
			searchDTO.setLimit(limit);
			
			// 현재 페이지의 작성글 리스트 획득
			final BoardSelectDAO boardSelectDAO = new BoardSelectDAO();
			List<BoardDTO> list = boardSelectDAO.getPostsAsContent(session, searchDTO);
			
			// 전체 작성글 개수 획득
			final int totalCount = boardSelectDAO.getSearchContentTotalCount(session, search);
			
			pageDTO = new PageDTO(curPage);
			pageDTO.setList(list);
			pageDTO.setTotalCount(totalCount);
			pageDTO.calcTotalPage();
			pageDTO.calcStartPage();
			pageDTO.calcEndPage();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return pageDTO;
	}

	@Override
	public PageDTO getSearchNamePageInfo(final int curPage, final String search) {
		final SqlSession session = MySqlSessionFactory.getSession();
		PageDTO pageDTO = null;
		
		try {		
			// 가져올 작성글의 첫 인덱스, 첫 인덱스부터 가져올 글의 개수 연산
			final int offset = PageDTO.getOffset(curPage);
			final int limit = PageDTO.getLimit();
			
			final SearchDTO searchDTO = new SearchDTO();
			searchDTO.setSearch(search);
			searchDTO.setOffset(offset);
			searchDTO.setLimit(limit);
			
			// 현재 페이지의 작성글 리스트 획득
			final BoardSelectDAO boardSelectDAO = new BoardSelectDAO();
			List<BoardDTO> list = boardSelectDAO.getPostsAsName(session, searchDTO);
			
			// 전체 작성글 개수 획득
			final int totalCount = boardSelectDAO.getSearchNameTotalCount(session, search);
			
			pageDTO = new PageDTO(curPage);
			pageDTO.setList(list);
			pageDTO.setTotalCount(totalCount);
			pageDTO.calcTotalPage();
			pageDTO.calcStartPage();
			pageDTO.calcEndPage();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return pageDTO;
	}
	
	@Override
	public BoardDTO getPostDetail(final int boardid) {
		final SqlSession session = MySqlSessionFactory.getSession();
		BoardDTO dto = null;
		
		try {	
			final BoardSelectDAO boardSelectDAO = new BoardSelectDAO();
			dto = boardSelectDAO.getPostDetail(session, boardid);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return dto;
	}

}

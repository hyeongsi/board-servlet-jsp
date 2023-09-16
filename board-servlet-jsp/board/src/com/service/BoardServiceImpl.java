package com.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.BoardDAO;
import com.dto.BoardDTO;
import com.dto.PageDTO;

public class BoardServiceImpl implements BoardService {

	public int uploadPost(final String title, final String boardcontent, final String name, final int id) {
		final int titleByte = 100;
		final int boardcontentByte = 4000;
		int n = 0;
		
		final SqlSession session = MySqlSessionFactory.getSession();
		try {
			// 제목, 내용이 지정된 범위를 벗어나지 않았다면 동작
			System.out.println("title length: " + title.getBytes().length);
			System.out.println("content length: " + boardcontent.getBytes().length);
			
			if(title.getBytes().length <= titleByte && 
					boardcontent.getBytes().length <= boardcontentByte) {
				
				String replaceTitle = title.replaceAll("(\\r\\n|\\r|\\n\\r)", "\\n");
				String replaceContent = boardcontent.replaceAll("(\\r\\n|\\r|\\n\\r)", "\\n");
				
				final BoardDTO dto = new BoardDTO();
				dto.setTitle(replaceTitle);
				dto.setBoardcontent(replaceContent);
				dto.setName(name);
				dto.setId(id);
				
				final BoardDAO boardDAO = new BoardDAO();
				n = boardDAO.uploadPost(session, dto);
				
				session.commit();
			}else {
				return 0;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return n;
	}

	@Override
	public PageDTO getPageInfo(final int curPage) {
		final SqlSession session = MySqlSessionFactory.getSession();
		PageDTO pageDTO = null;
		
		try {	
			// 가져올 작성글의 첫 인덱스, 첫 인덱스부터 가져올 글의 개수 연산
			pageDTO = new PageDTO();
			pageDTO.setCurPage(curPage);
			final int offset = (pageDTO.getCurPage() - 1) * pageDTO.getPerPage();
			final int limit = pageDTO.getPerPage();
			
			// 현재 페이지의 작성글 리스트 획득
			final BoardDAO boardDAO = new BoardDAO();
			List<BoardDTO> list = boardDAO.getPosts(session, curPage, offset, limit);
			pageDTO.setList(list);
			
			// 전체 작성글 개수 획득
			final int totalCount = session.selectOne("BoardMapper.totalCount");
			pageDTO.setTotalCount(totalCount);
			
			// 페이지네이션에 사용할 첫 번호
			final int perPage = pageDTO.getPerPage();
			final int startPage = ((curPage-1) / perPage) * perPage + 1;
			pageDTO.setStartPage(startPage);
			
			// 페이지네이션에 사용할 마지막 번호
			int endPage = ((curPage-1) / perPage) * perPage + perPage;
			final int totalPage = (totalCount-1) / perPage + 1;
			pageDTO.setTotalPage(totalPage);
			
			// 마지막 페이지번호 초과 제한
			if(endPage >= totalPage)
				endPage = totalPage;
			pageDTO.setEndPage(endPage);
			
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
			final BoardDAO boardDAO = new BoardDAO();
			dto = boardDAO.getPostDetail(session, boardid);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return dto;
	}

	@Override
	public int increaseViewcnt(final int boardid) {
		final SqlSession session = MySqlSessionFactory.getSession();
		int n = 0;
		
		try {	
			final BoardDAO boardDAO = new BoardDAO();
			n = boardDAO.increaseViewcnt(session, boardid);
			
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return n;
	}

	@Override
	public int updatePost(final int boardid, final String title, final String boardcontent) {
		final SqlSession session = MySqlSessionFactory.getSession();
		int n = 0;
		
		try {	
			final String replaceTitle = title.replaceAll("(\\r\\n|\\r|\\n\\r)", "\\n");
			final String replaceContent = boardcontent.replaceAll("(\\r\\n|\\r|\\n\\r)", "\\n");
			
			final BoardDTO dto = new BoardDTO();
			dto.setBoardid(boardid);
			dto.setTitle(replaceTitle);
			dto.setBoardcontent(replaceContent);
			
			final BoardDAO boardDAO = new BoardDAO();
			n = boardDAO.updatePost(session, dto);
			
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return n;
	}

	@Override
	public int deletePost(final int boardid) {
		final SqlSession session = MySqlSessionFactory.getSession();
		int n = 0;
		
		try {
			final BoardDAO boardDAO = new BoardDAO();
			n = boardDAO.deletePost(session, boardid);
			
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return n;
	}

}

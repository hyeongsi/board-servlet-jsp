package com.service;

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
			if(title.getBytes().length <= titleByte && 
					boardcontent.getBytes().length <= boardcontentByte) {

				final BoardDTO dto = new BoardDTO();
				dto.setTitle(title);
				dto.setBoardcontent(boardcontent);
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
	public PageDTO getPosts(final int curPage) {
		final SqlSession session = MySqlSessionFactory.getSession();
		PageDTO pageDTO = null;
		
		try {	
			final BoardDAO boardDAO = new BoardDAO();
			pageDTO = boardDAO.getPosts(session, curPage);
			
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
			final BoardDTO dto = new BoardDTO();
			dto.setBoardid(boardid);
			dto.setTitle(title);
			dto.setBoardcontent(boardcontent);
			
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

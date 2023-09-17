package com.service;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.BoardDAO;
import com.dto.BoardDTO;

public class BoardServiceImpl implements BoardService {

	public int uploadPost(final String title, final String boardcontent, final String name, final int id) {
		int n = 0;
		
		final SqlSession session = MySqlSessionFactory.getSession();
		try {
			final BoardDTO dto = new BoardDTO();
			dto.setTitle(title);
			dto.setBoardcontent(boardcontent);
			dto.setName(name);
			dto.setId(id);
			
			final BoardDAO boardDAO = new BoardDAO();
			n = boardDAO.uploadPost(session, dto);
			
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return n;
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

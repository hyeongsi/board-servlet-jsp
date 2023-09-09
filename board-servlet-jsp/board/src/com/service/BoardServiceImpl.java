package com.service;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.BoardDAO;
import com.dto.BoardDTO;
import com.dto.PageDTO;

public class BoardServiceImpl implements BoardService {

	public int addBoard(String title, String boardcontent, String name, int id) {
		final int titleByte = 100;
		final int boardcontentByte = 4000;
		int n = 0;
		
		SqlSession session = MySqlSessionFactory.getSession();
		try {
			if(title.getBytes().length <= titleByte && 
					boardcontent.getBytes().length <= boardcontentByte) {

				BoardDTO dto = new BoardDTO();
				dto.setTitle(title);
				dto.setBoardcontent(boardcontent);
				dto.setName(name);
				dto.setId(id);
				
				BoardDAO boardDAO = new BoardDAO();
				n = boardDAO.addBoard(session, dto);
				
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
	public PageDTO list(int curPage) {
		SqlSession session = MySqlSessionFactory.getSession();
		PageDTO pageDTO = null;
		
		try {	
			BoardDAO boardDAO = new BoardDAO();
			pageDTO = boardDAO.list(session, curPage);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return pageDTO;
	}

	@Override
	public BoardDTO boardDetail(int boardid) {
		SqlSession session = MySqlSessionFactory.getSession();
		BoardDTO dto = null;
		
		try {	
			BoardDAO boardDAO = new BoardDAO();
			dto = boardDAO.boardDetail(session, boardid);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return dto;
	}

	@Override
	public int increaseViewcnt(int boardid) {
		SqlSession session = MySqlSessionFactory.getSession();
		int n = 0;
		
		try {	
			BoardDAO boardDAO = new BoardDAO();
			n = boardDAO.increaseViewcnt(session, boardid);
			
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return n;
	}

}

package com.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.CommentDAO;
import com.dto.CommentDTO;

public class CommentServiceImpl implements CommentService {

	@Override
	public int uploadComment(final CommentDTO dto) {
		int n = 0;
		
		final SqlSession session = MySqlSessionFactory.getSession();
		try {
			
			final CommentDAO commentDAO = new CommentDAO();
			
			if(dto.getParent_commentid() == null) {
				n = commentDAO.uploadRootComment(session, dto);
			}else {
				n = commentDAO.uploadComment(session, dto);
			}
			
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return n;
	}

	@Override
	public List<CommentDTO> getComment(final int boardid) {
		List<CommentDTO> list = null;
		
		final SqlSession session = MySqlSessionFactory.getSession();
		try {
			
			final CommentDAO commentDAO = new CommentDAO();
			list = commentDAO.getComment(session, boardid);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public int deleteComment(final int commentid) {
		int n = 0;
		
		final SqlSession session = MySqlSessionFactory.getSession();
		try {
			
			final CommentDAO commentDAO = new CommentDAO();
			n = commentDAO.deleteComment(session, commentid);
			
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return n;
	}

	@Override
	public int updateComment(final String content, final CommentDTO dto) {
		int n = 0;
		
		final SqlSession session = MySqlSessionFactory.getSession();
		try {
			
			final CommentDAO commentDAO = new CommentDAO();
			n = commentDAO.updateComment(session, dto);
			
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return n;
	}

}

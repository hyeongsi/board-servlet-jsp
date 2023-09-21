package com.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.CommentDTO;

public class CommentDAO {
	
	public int uploadRootComment(final SqlSession session, final CommentDTO dto) {
		return session.insert("CommentMapper.uploadRootComment", dto);
	}
	
	public int uploadComment(final SqlSession session, final CommentDTO dto) {
		return session.insert("CommentMapper.uploadComment", dto);
	}
	
	public List<CommentDTO> getComment(final SqlSession session, final int boardid) {
		return session.selectList("CommentMapper.getComment", boardid);
	}
	
	public int deleteComment(final SqlSession session, final int commentid) {
		return session.delete("CommentMapper.deleteComment", commentid);
	}
	
	public int updateComment(final SqlSession session, final CommentDTO dto) {
		return session.update("CommentMapper.updateComment", dto);
	}
}

package com.dao;

import org.apache.ibatis.session.SqlSession;

import com.dto.BoardDTO;

public class BoardDAO {
	
	public int uploadPost(final SqlSession session, final BoardDTO dto) {
		return session.insert("BoardMapper.uploadPost", dto);
	}
	
	public int increaseViewcnt(final SqlSession session, final int boardid) {
		return session.update("BoardMapper.increaseViewcnt", boardid);
	}
	
	public int updatePost(final SqlSession session, final BoardDTO dto) {
		return session.update("BoardMapper.updatePost", dto);
	}
	
	public int deletePost(final SqlSession session, final int boardid) {
		return session.delete("BoardMapper.deletePost", boardid);
	}
}

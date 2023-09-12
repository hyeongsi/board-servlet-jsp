package com.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.dto.BoardDTO;
import com.dto.PageDTO;

public class BoardDAO {
	public int uploadPost(final SqlSession session, final BoardDTO dto) {
		return session.update("BoardMapper.uploadPost", dto);
	}
	
	public List<BoardDTO> getPosts(final SqlSession session, 
			final int curPage, final int offset, final int limit) {
		return session.selectList("BoardMapper.getPosts", null, new RowBounds(offset, limit));
	}
	
	public BoardDTO getPostDetail(final SqlSession session, final int boardid) {
		return session.selectOne("BoardMapper.getPostDetail", boardid);
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

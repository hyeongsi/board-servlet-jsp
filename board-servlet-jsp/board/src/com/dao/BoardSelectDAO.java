package com.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.dto.BoardDTO;
import com.dto.SearchDTO;

public class BoardSelectDAO {

	public List<BoardDTO> getPosts(final SqlSession session, 
			final int curPage, final int offset, final int limit) {
		return session.selectList("BoardSelectMapper.getPosts", null, new RowBounds(offset, limit));
	}
	public int getTotalCount(final SqlSession session) {
		return session.selectOne("BoardSelectMapper.getTotalCount");
	}
	
	public BoardDTO getPostDetail(final SqlSession session, final int boardid) {
		return session.selectOne("BoardSelectMapper.getPostDetail", boardid);
	}
	
	
	public List<BoardDTO> getPostsAsTitle(final SqlSession session, final SearchDTO dto) {
		return session.selectList("BoardSelectMapper.getPostsAsTitle", dto.getSearch(), new RowBounds(dto.getOffset(), dto.getLimit()));
	}
	public List<BoardDTO> getPostsAsContent(final SqlSession session, final SearchDTO dto) {
		return session.selectList("BoardSelectMapper.getPostsAsContent", dto.getSearch(), new RowBounds(dto.getOffset(), dto.getLimit()));
	}
	public List<BoardDTO> getPostsAsName(final SqlSession session, final SearchDTO dto) {
		return session.selectList("BoardSelectMapper.getPostsAsName", dto.getSearch(), new RowBounds(dto.getOffset(), dto.getLimit()));
	}
	
	
	public int getSearchTitleTotalCount(final SqlSession session, final String search) {
		return session.selectOne("BoardSelectMapper.getSearchTitleTotalCount", search);
	}
	public int getSearchContentTotalCount(final SqlSession session, final String search) {
		return session.selectOne("BoardSelectMapper.getSearchContentTotalCount", search);
	}
	public int getSearchNameTotalCount(final SqlSession session, final String search) {
		return session.selectOne("BoardSelectMapper.getSearchNameTotalCount", search);
	}
	
}

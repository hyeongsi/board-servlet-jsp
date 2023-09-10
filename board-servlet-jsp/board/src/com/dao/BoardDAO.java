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
	
	public PageDTO list(final SqlSession session, final int curPage) {
		final PageDTO pageDTO = new PageDTO();
		pageDTO.setCurPage(curPage);
		final int offset = (pageDTO.getCurPage() - 1) * pageDTO.getPerPage();
		final int limit = pageDTO.getPerPage();
		
		List<BoardDTO> list = session.selectList("BoardMapper.list", null, new RowBounds(offset, limit));
		pageDTO.setList(list);
		
		final int totalCount = session.selectOne("BoardMapper.totalCount");
		pageDTO.setTotalCount(totalCount);
		
		return pageDTO;
	}
	
	public BoardDTO getPostDetail(final SqlSession session, final int boardid) {
		return session.selectOne("BoardMapper.postDetail", boardid);
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

package com.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.dto.BoardDTO;
import com.dto.PageDTO;

public class BoardDAO {
	public int addBoard(SqlSession session, BoardDTO dto) {
		return session.update("BoardMapper.addBoard", dto);
	}
	
	public PageDTO list(SqlSession session, int curPage) {
		PageDTO pageDTO = new PageDTO();
		pageDTO.setCurPage(curPage);
		int offset = (pageDTO.getCurPage() - 1) * pageDTO.getPerPage();
		int limit = pageDTO.getPerPage();
		
		List<BoardDTO> list = session.selectList("BoardMapper.list", null, new RowBounds(offset, limit));
		pageDTO.setList(list);
		
		int totalCount = session.selectOne("BoardMapper.totalCount");
		pageDTO.setTotalCount(totalCount);
		
		return pageDTO;
	}
	
	public BoardDTO boardDetail(SqlSession session, int boardid) {
		return session.selectOne("BoardMapper.boardDetail", boardid);
	}
	
	public int increaseViewcnt(SqlSession session, int boardid) {
		return session.update("BoardMapper.increaseViewcnt", boardid);
	}
}

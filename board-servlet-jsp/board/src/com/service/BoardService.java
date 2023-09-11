package com.service;

import com.dto.BoardDTO;
import com.dto.PageDTO;

public interface BoardService {
	
	// 게시글 추가
	public int uploadPost(final String title, final String boardcontent, final String name, final int id);
	// 현재페이지의 게시글 획득
	public PageDTO getPosts(final int curPage);
	// 게시글 상세내용 획득
	public BoardDTO getPostDetail(final int boardid); 
	// 조회수 증가
	public int increaseViewcnt(final int boardid);
	// 게시글 변경
	public int updatePost(final int boardid, final String title, final String boardcontent);
	// 게시글 삭제
	public int deletePost(final int boardid);
}

package com.service;

public interface BoardService {
	
	// 게시글 추가
	public int uploadPost(final String title, final String boardcontent, final String name, final int id);
	// 조회수 증가
	public int increaseViewcnt(final int boardid);
	// 게시글 변경
	public int updatePost(final int boardid, final String title, final String boardcontent);
	// 게시글 삭제
	public int deletePost(final int boardid);
	
}

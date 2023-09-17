package com.service;

import com.dto.BoardDTO;
import com.dto.PageDTO;

public interface BoardSelectService {
	
	// 현재페이지의 게시글 획득
	public PageDTO getPageInfo(int curPage);
	// 현재 페이지의 검색 게시글 획득
	public PageDTO getSearchTitlePageInfo(int curPage, String search);
	public PageDTO getSearchContentPageInfo(int curPage, String search);
	public PageDTO getSearchNamePageInfo(int curPage, String search);
	// 게시글 상세내용 획득
	public BoardDTO getPostDetail(int boardid); 
}

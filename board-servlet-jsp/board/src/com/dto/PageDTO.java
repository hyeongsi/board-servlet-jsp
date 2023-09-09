package com.dto;

import java.util.List;

public class PageDTO {
	
	List<BoardDTO> list;	// 한 페이지의 게시글
	final int perPage = 3;		// 한 페이지에 보여줄 게시글 개수
	int totalCount;			// 전체 레코드 개수
	int curPage = 1;		// 현재 페이지 번호
	
	public List<BoardDTO> getList() {
		return list;
	}
	public void setList(List<BoardDTO> list) {
		this.list = list;
	}
	public int getPerPage() {
		return perPage;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	
}

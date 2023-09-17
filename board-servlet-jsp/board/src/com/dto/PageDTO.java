package com.dto;

import java.util.List;

public class PageDTO {
	
	List<BoardDTO> list;	// 한 페이지의 게시글
	final static int perPage = 5;		// 한 페이지에 보여줄 게시글 개수
	int totalCount;			// 전체 레코드 개수
	int curPage = 1;		// 현재 페이지 번호
	int totalPage = 1;		// 전체 페이지 수
	int startPage = 1;		// 출력할 시작 페이지 번호
	int endPage = 1;		// 출력할 끝 페이지 번호
	
	
	public PageDTO(int curPage) {
		this.curPage = curPage;
	}
	
	public List<BoardDTO> getList() {
		return list;
	}
	public void setList(List<BoardDTO> list) {
		this.list = list;
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
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public int getPerPage() {
		return perPage;
	}
	
	public static int getOffset(int curPage) {
		return (curPage - 1) * perPage;
	}
	public static int getLimit() {
		return perPage;
	}
	
	public void calcStartPage() {
		startPage = ((curPage-1) / perPage) * perPage + 1;
	}
	public void calcEndPage() {
		endPage = ((curPage-1) / perPage) * perPage + perPage;
		
		if(endPage >= totalPage)
			endPage = totalPage;
	}
	public void calcTotalPage() {
		totalPage = (totalCount-1) / perPage + 1;
	}
}

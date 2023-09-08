package com.dto;

public class BoardDTO {
	int boardid;
	String title;
	String boardcontent;
	String writetime;
	int viewcnt;
	String name;
	
	public BoardDTO() {}
	public BoardDTO(int boardid, String title, String boardcontent, String writetime, int viewcnt, String name) {
		this.boardid = boardid;
		this.title = title;
		this.boardcontent = boardcontent;
		this.writetime = writetime;
		this.viewcnt = viewcnt;
		this.name = name;
	}
	
	public int getBoardid() {
		return boardid;
	}
	public void setBoardid(int boardid) {
		this.boardid = boardid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBoardcontent() {
		return boardcontent;
	}
	public void setBoardcontent(String boardcontent) {
		this.boardcontent = boardcontent;
	}
	public String getWritetime() {
		return writetime;
	}
	public void setWritetime(String writetime) {
		this.writetime = writetime;
	}
	public int getViewcnt() {
		return viewcnt;
	}
	public void setViewcnt(int viewcnt) {
		this.viewcnt = viewcnt;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}

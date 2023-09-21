package com.dto;

public class CommentDTO {
	int commentid;			// 댓글 id
	String content;			// 내용
	String writetime;		// 작성시간 
	Integer parent_commentid;	// 부모 댓글 id
	int boardid;			// 게시글 id
	int id;					// 작성자 id
	int level;				// 계층
	String name;			// 작성자 이름
	
	public CommentDTO() {}
	public CommentDTO(int commentid, String content, String writetime, int parent_commentid, int boardid, int id, int level, String name) {
		this.commentid = commentid;
		this.content = content;
		this.writetime = writetime;
		this.parent_commentid = parent_commentid;
		this.boardid = boardid;
		this.id = id;
		this.level = level;
		this.name = name;
	}
	
	public int getCommentid() {
		return commentid;
	}
	public void setCommentid(int commentid) {
		this.commentid = commentid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWritetime() {
		return writetime;
	}
	public void setWritetime(String writetime) {
		this.writetime = writetime;
	}
	public Integer getParent_commentid() {
		return parent_commentid;
	}
	public void setParent_commentid(Integer parent_commentid) {
		this.parent_commentid = parent_commentid;
	}
	public int getBoardid() {
		return boardid;
	}
	public void setBoardid(int boardid) {
		this.boardid = boardid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}

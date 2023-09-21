package com.dto;

public class CommentDTO {
	int commentid;			// 댓글 id
	String content;			// 내용
	Integer parent_commentid;	// 부모 댓글 id
	int boardid;			// 게시글 id
	int id;					// 작성자 id
	int level;
	
	public CommentDTO() {}
	public CommentDTO(int commentid, String content, int parent_commentid, int boardid, int id, int level) {
		this.commentid = commentid;
		this.content = content;
		this.parent_commentid = parent_commentid;
		this.boardid = boardid;
		this.id = id;
		this.level = level;
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
	
	
}

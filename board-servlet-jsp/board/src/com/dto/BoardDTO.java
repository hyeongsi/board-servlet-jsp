package com.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BoardDTO {
	int boardid;			// 게시판 id
	String title;			// 제목
	String boardcontent;	// 내용
	String writetime;			// 작성 시간
	int viewcnt;			// 조회수
	String name;			// 작성자명

	int id;					// 작성자식별 id
	
	public BoardDTO() {}
	
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
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getPageRenderingWritetime() {
		final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		final LocalDateTime localDateTime = LocalDateTime.parse(writetime, formatter);
		final LocalDate localDate = localDateTime.toLocalDate();
		
		// 오늘 저장 시간이 하루를 지나지 않았다면 실행
		if(localDate.isEqual(LocalDate.now())) {
			// 시,분 문자열만 추출
			StringBuilder sb = new StringBuilder();
			sb.append(localDateTime.getHour())
				.append(":")
				.append(localDateTime.getMinute());
			
			return sb.toString();
		}
		
		return localDate.toString();
	}
}

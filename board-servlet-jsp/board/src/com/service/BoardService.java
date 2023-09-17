package com.service;

import java.io.UnsupportedEncodingException;

import com.dto.BoardDTO;
import com.dto.PageDTO;

public interface BoardService {
	
	// 게시글 추가
	public int uploadPost(final String title, final String boardcontent, final String name, final int id);
	// 조회수 증가
	public int increaseViewcnt(final int boardid);
	// 게시글 변경
	public int updatePost(final int boardid, final String title, final String boardcontent);
	// 게시글 삭제
	public int deletePost(final int boardid);
	
	
	static boolean isOverflowTitle(final String title) {
		final int TITLE_LENGTHB = 200;
		try {
			if(title.getBytes("utf-8").length > TITLE_LENGTHB) {
				return true;
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return false; 
	}
	
	static boolean isOverflowContent(final String content) {
		final int CONTENT_LENGTHB = 4000;
		try {
			if(content.getBytes("utf-8").length > CONTENT_LENGTHB) {
				return true;
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return false;
	}
}

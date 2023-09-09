package com.service;

import com.dto.PageDTO;

public interface BoardService {
	
	public int addBoard(String title, String boardcontent, String name, int id);
	public PageDTO list(int curPage);
}

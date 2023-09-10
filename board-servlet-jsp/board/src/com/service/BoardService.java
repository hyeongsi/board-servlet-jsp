package com.service;

import com.dto.BoardDTO;
import com.dto.PageDTO;

public interface BoardService {
	
	public int boardAdd(String title, String boardcontent, String name, int id);
	public PageDTO list(int curPage);
	public BoardDTO boardDetail(int boardid); 
	public int increaseViewcnt(int boardid);
	public int boardUpdate(int boardid, String title, String boardcontent);
	public int boardDelete(int boardid);
}

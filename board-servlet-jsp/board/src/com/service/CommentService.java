package com.service;

import java.util.List;

import com.dto.CommentDTO;

public interface CommentService {
	
	public int uploadComment(CommentDTO dto);
	public List<CommentDTO> getComment(int boardid);
	public int deleteComment(int commentid);
}

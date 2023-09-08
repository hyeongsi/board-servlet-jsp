package com.dao;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

public class BoardDAO {
	public int writeBoard(SqlSession session, HashMap<String, String> map) {
		return session.insert("BoardMapper.writeBoard", map);
	}
}

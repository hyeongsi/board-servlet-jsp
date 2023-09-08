package com.service;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.BoardDAO;
import com.dao.MemberDAO;
import com.dto.MemberDTO;

public class BoardServiceImpl implements BoardService {

	public int writeBoard(String title, String boardcontent, String userid) {
		final int titleByte = 100;
		final int boardcontentByte = 4000;
		int n = 0;
		
		SqlSession session = MySqlSessionFactory.getSession();
		try {
			MemberDAO memberDAO = new MemberDAO();
			MemberDTO memberDTO = memberDAO.useridCheck(session, userid);
			
			if(title.getBytes().length <= titleByte && 
					boardcontent.getBytes().length <= boardcontentByte) {
				HashMap<String, String> map = new HashMap<String, String>();
				map.put("title", title);
				map.put("boardcontent", boardcontent);
				map.put("name", memberDTO.getName());
				
				BoardDAO boardDAO = new BoardDAO();
				n = boardDAO.writeBoard(session, map);
				session.commit();
			}else {
				return 0;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return n;
	}

}

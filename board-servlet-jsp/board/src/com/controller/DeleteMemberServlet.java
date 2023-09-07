package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.MemberDTO;
import com.service.MemberService;
import com.service.MemberServiceImpl;

@WebServlet("/deleteMember")
public class DeleteMemberServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberDTO dto = (MemberDTO)session.getAttribute("login");
		
		String nextPage = null;
		if(dto != null) {
			String userid = request.getParameter("userid");
			MemberService service = new MemberServiceImpl();
			int n = service.deleteMember(userid);
			
			nextPage = "boardUI";
			session.invalidate();  // 로그아웃
		}else {			
			nextPage = "member/needLogin.jsp";
		}
		
		response.sendRedirect(nextPage);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

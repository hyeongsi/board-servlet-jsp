package com.controller.myprofile;

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

@WebServlet("/memberEditor")
public class MemberEditorServlet extends HttpServlet {    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		final HttpSession session = request.getSession();
		final MemberDTO dto = (MemberDTO)session.getAttribute("login");
		
		String nextPage = null;
		if(dto != null) {
			final String userid = request.getParameter("userid");
			final String pw = request.getParameter("pw");
			final String name = request.getParameter("name");
			
			final MemberDTO editDTO = new MemberDTO(userid, pw, name);
			
			final MemberService service = new MemberServiceImpl();
			final int result = service.updateMember(editDTO);
			
			if(result == 0) {
			}else {}
			
			nextPage = "boardUI";
		}else {			
			nextPage = "member/needLogin.jsp";
		}
		
		response.sendRedirect(nextPage);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

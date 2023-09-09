package com.controller.login;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.MemberDTO;
import com.service.MemberService;
import com.service.MemberServiceImpl;

@WebServlet("/loginMember")
public class LoginMemberServlet extends HttpServlet {    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		String userid = request.getParameter("userid");
		String pw = request.getParameter("pw");
		
		HashMap<String, String> loginMap = new HashMap<String, String>();
		loginMap.put("userid", userid);
		loginMap.put("pw", pw);
		
		MemberService service = new MemberServiceImpl();
		MemberDTO dto = service.loginMember(loginMap);
		
		String nextPage = null;
		if(dto != null) {
			HttpSession session = request.getSession();
			session.setAttribute("login", dto);
			
			nextPage = "boardUI";
		}else {
			nextPage = "member/loginFail.jsp";
		}
		
		response.sendRedirect(nextPage);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

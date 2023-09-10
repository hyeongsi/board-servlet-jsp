package com.controller.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.LoginDTO;
import com.dto.MemberDTO;
import com.service.MemberService;
import com.service.MemberServiceImpl;

@WebServlet("/loginUser")
public class LoginUserServlet extends HttpServlet {    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		final String userid = request.getParameter("userid");
		final String pw = request.getParameter("pw");
		
		final LoginDTO loginDTO = new LoginDTO(userid, pw);
		
		final MemberService service = new MemberServiceImpl();
		final MemberDTO resultDTO = service.getLoginUserInfo(loginDTO);
		
		String nextPage = null;
		if(resultDTO != null) {
			final HttpSession session = request.getSession();
			session.setAttribute("login", resultDTO);
			
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

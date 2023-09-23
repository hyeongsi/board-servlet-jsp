package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.common.TextHtmlUtil;
import com.dto.MemberDTO;
import com.service.MemberService;
import com.service.MemberServiceImpl;

@SuppressWarnings("serial")
@WebServlet("/duplicationUseridCk")
public class DuplicationUseridCkServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		final String userid = request.getParameter("userid");
		
		final MemberService service = new MemberServiceImpl();
		final MemberDTO dto = service.getSameUseridMember(userid);
		
		TextHtmlUtil.initReturnTextHtml(response);
		final PrintWriter out = response.getWriter();
		
		if(dto == null) {
			out.print("success");
			return;
		}
			
		out.print("fail");
	}

}

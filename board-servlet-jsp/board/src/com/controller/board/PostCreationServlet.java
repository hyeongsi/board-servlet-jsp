package com.controller.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.common.AlertHref;
import com.common.LoginUser;
import com.common.enums.AlertMessage;
import com.common.enums.SitePath;
import com.dto.MemberDTO;
import com.service.BoardService;
import com.service.BoardServiceImpl;

@WebServlet("/postCreation")
public class PostCreationServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final int FAIL_UPLOAD = 0;
		
		boolean isLogin = LoginUser.isLogin(request);
		
		final AlertHref href = new AlertHref(request);
		String nextPage = null;
		
		if(isLogin) {
			final MemberDTO loginUserDTO = LoginUser.getLoginUserDTO(request);
			
			final String title = request.getParameter("title");
			final String boardcontent = request.getParameter("boardcontent");
			final String name = loginUserDTO.getName();
			final int id = loginUserDTO.getId();
			
			final BoardService service = new BoardServiceImpl();
			final int result = service.uploadPost(title, boardcontent, name, id);
			
			if(result == FAIL_UPLOAD) {
				// 업로드 실패 메시지, 글 작성 화면 이동 설정
				nextPage = href.setAlertPath(AlertMessage.FAILED_UPLOAD_POST, 
											SitePath.POST_CREATION_UI);
			}
			else {
				// 메인화면(게시글) 이동 설정
				nextPage = SitePath.BOARD_UI.getPath();
			}
		}else {
			// 로그인 필요 메시지, 로그인 화면 이동 설정
			nextPage = href.setNeedLoginPath();
		}
		
		request.getRequestDispatcher(nextPage).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

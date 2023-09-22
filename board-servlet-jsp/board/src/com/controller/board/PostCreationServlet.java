package com.controller.board;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.common.AlertHref;
import com.common.LoginUser;
import com.common.OverflowCheck;
import com.common.OverflowCheck.LengthB;
import com.common.enums.AlertMessage;
import com.common.enums.SitePath;
import com.dto.MemberDTO;
import com.service.BoardService;
import com.service.BoardServiceImpl;

@WebServlet("/postCreation")
public class PostCreationServlet extends HttpServlet {

	private final static int FAIL_UPLOAD = 0;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		boolean isLogin = LoginUser.isLogin(request);
		
		final AlertHref href = new AlertHref(request);
		String nextPage = null;
		
		if(!isLogin) {
			// 로그인 필요 메시지, 로그인 화면 이동 설정
			nextPage = href.setNeedLoginPath();
			request.getRequestDispatcher(nextPage).forward(request, response);
			return;
		}
		
		final MemberDTO loginUserDTO = LoginUser.getLoginUserDTO(request);
		
		final String title = request.getParameter("title");
		final String boardcontent = request.getParameter("boardcontent");
		final String name = loginUserDTO.getName();
		final int id = loginUserDTO.getId();
		
		final boolean isEmptyTitle = title.trim().isEmpty();
		if(isEmptyTitle) {
			nextPage = href.setAlertPath(AlertMessage.FAILED_UPLOAD_POST, 
							SitePath.POST_CREATION_UI);
			request.getRequestDispatcher(nextPage).forward(request, response);
			return;
		}
		
		int result = FAIL_UPLOAD;
		// overflow가 아니라면 upload 수행
		final int titleBytes = OverflowCheck.getBytesUtf8(title);
		final int contentBytes = OverflowCheck.getBytesUtf8(boardcontent);
		
		if(!(OverflowCheck.isOverflow(titleBytes, LengthB.TITLE_LENGTHB)) ||
				OverflowCheck.isOverflow(contentBytes, LengthB.CONTENT_LENGTHB)) {
			
			final BoardService service = new BoardServiceImpl();
			result = service.uploadPost(title, boardcontent, name, id);
		}
		
		if(result == FAIL_UPLOAD) {
			// 업로드 실패 메시지, 글 작성 화면 이동 설정
			nextPage = href.setAlertPath(AlertMessage.FAILED_UPLOAD_POST, 
										SitePath.POST_CREATION_UI);
		}
		else {
			// 메인화면(게시글) 이동 설정
			nextPage = SitePath.BOARD_UI.getPath();
		}
		
		request.getRequestDispatcher(nextPage).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

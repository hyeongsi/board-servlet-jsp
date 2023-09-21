package com.common.enums;

public enum SitePath {
	BOARD("board.jsp"),
	BOARD_UI("boardUI"),
	
	POST_SEARCH("/postSearchServlet"),
	
	POST_DETAIL("postDetail.jsp"),
	POST_DETAIL_UI("/postDetailUI"),
	POST_DETAIL_RETRIEVE("/board/postDetailUI"),
	
	POST_CREATION("postCreation.jsp"),
	POST_CREATION_UI("postCreationUI"),
	
	POST_EDITOR("postEditor.jsp"),

	LOGIN_USER("loginUser.jsp"),
	LOGIN_USER_UI("/loginUserUI"),
	
	MY_PROFILE("myProfile.jsp"),
	MY_PROFILE_UI("/board/myProfileUI"),
	
	MEMBER_REGISTRATION("memberRegistration.jsp"),
	REGISTER_UI("/board/memberRegistrationUI"),
	SUCCESS_REGISTER_MEMBER("registerSuccess.jsp"),
	
	ALERT_HREF_FORM("/board/common/alertAndHrefForm.jsp");

	private final String path;
	
	SitePath(final String path) {
		this.path = path;
	}
	
	public String getPath() {
		return path;
	}
}

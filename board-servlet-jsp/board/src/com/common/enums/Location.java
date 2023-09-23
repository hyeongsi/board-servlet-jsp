package com.common.enums;

public enum Location {
	BOARD_JSP("board.jsp"),
	UI_BOARD("/boardUI"),
	UI_BOARD_REDIRECT("/board/boardUI"),
	
	SEARCH_POST("/postSearchServlet"),
	
	POST_DETAIL_JSP("postDetail.jsp"),
	UI_POST_DETAIL("/board/postDetailUI"),
	
	POST_CREATION_JSP("postCreation.jsp"),
	UI_POST_CREATION("/board/postCreationUI"),
	
	POST_EDITOR_JSP("postEditor.jsp"),

	LOGIN_USER_JSP("loginUser.jsp"),
	UI_LOGIN_USER("/board/loginUserUI"),
	
	MY_PROFILE("myProfile.jsp"),
	UI_MY_PROFILE("/board/myProfileUI"),
	
	MEMBER_REGISTRATION_JSP("memberRegistration.jsp"),
	REGISTER_UI("/board/memberRegistrationUI"),
	SUCCESS_REGISTER_MEMBER_JSP("registerSuccess.jsp");

	private final String location;
	
	Location(final String location) {
		this.location = location;
	}
	
	public String toString() {
		return location;
	}
}

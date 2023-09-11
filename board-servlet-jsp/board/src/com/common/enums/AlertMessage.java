package com.common.enums;

public enum AlertMessage {
	FAILED_UPLOAD_POST("게시글 작성 실패"),
	FAILED_DELETE_POST("게시글 삭제 실패"),
	
	SUCCESS_DELETE_POST("게시글 삭제 성공"),
	
	FAILED_UPDATE_POST("게시글 수정 실패"),
	SUCCESS_UPDATE_POST("게시글 수정 성공"),
	
	NOT_EXIST_POST("게시글이 존재하지 않습니다."),
	
	FAILED_LOGIN("아이디 또는 비밀번호가 일치하지 않습니다."),
	
	FAILED_UPDATE_MEMBER("내 정보 변경 실패"),
	SUCCESS_UPDATE_MEMBER("내 정보 변경 성공"),
	
	FAILED_DELETE_MEMBER("회원 탈퇴 실패"),
	SUCCESS_DELETE_MEMBER("회원 탈퇴 성공"),
	
	FAILED_REGISTER_MEMBER("회원 등록 실패"),
	SUCCESS_REGISTER_MEMBER("회원 등록 성공"),
	
	NEED_LOGIN("로그인이 필요합니다.");

	
	private final String message;
	
	AlertMessage(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
}

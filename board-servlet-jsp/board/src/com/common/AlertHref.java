package com.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.common.enums.AlertMessage;
import com.common.enums.SitePath;

public class AlertHref {
	HttpServletRequest request;
	
	public AlertHref(final HttpServletRequest request) {
		this.request = request;
	}

	// alert 메시지, alert 후 이동 화면 설정
	public String setAlertPath(final AlertMessage alertMesg, final SitePath sitePath) {
		request.setAttribute("mesg", alertMesg.getMessage());
		request.setAttribute("path", sitePath.getPath());
		
		return SitePath.ALERT_HREF_FORM.getPath();
	}
	
	// 로그인이 필요 메시지, 로그인 화면 이동 설정
	public String setNeedLoginPath() {
		request.setAttribute("mesg", AlertMessage.NEED_LOGIN.getMessage());
		request.setAttribute("path", SitePath.LOGIN_USER_UI.getPath());
	
		return SitePath.ALERT_HREF_FORM.getPath();
	}
}

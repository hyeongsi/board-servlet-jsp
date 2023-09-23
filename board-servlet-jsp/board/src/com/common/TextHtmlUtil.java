package com.common;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.common.enums.Location;

public class TextHtmlUtil {
	
	private TextHtmlUtil() {}

	public static void initReturnTextHtml(final HttpServletResponse response) {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
	}
	
	public static void setAlertMessage(final PrintWriter printWriter, final String message) {
		
		final StringBuilder printScriptBuilder = new StringBuilder();
		printScriptBuilder.append("<script>alert(\'")
							.append(message)
							.append("\')</script>");
		
		printWriter.println(printScriptBuilder.toString());
	}
	
	public static void setLocationHref(final PrintWriter printWriter, final String location) {
		
		final StringBuilder printScriptBuilder = new StringBuilder();
		printScriptBuilder.append("<script>location.href=\'")
							.append(location)
							.append("\'</script>");
		
		printWriter.println(printScriptBuilder.toString());
	}
	
	public static void setMessageAndLocation(final PrintWriter printWriter, 
												final String message, 
												final String location) {
		setAlertMessage(printWriter, message);
		setLocationHref(printWriter, location);
	}
	
	public static void setNeedLoginLocation(final PrintWriter printWriter) {
		setAlertMessage(printWriter, "로그인이 필요합니다.");
		setLocationHref(printWriter, Location.UI_LOGIN_USER.toString());
	}
	
	public static void autoProcessNeedLoginLocation(final HttpServletResponse response) throws IOException {
		initReturnTextHtml(response);
		
		final PrintWriter printWriter = response.getWriter();
		setNeedLoginLocation(printWriter);

		printWriter.close();
	}
	
	public static void autoProcessMessageAndLocation(final HttpServletResponse response, 
													final String message, 
													final String location) throws IOException {
		initReturnTextHtml(response);
		
		final PrintWriter printWriter = response.getWriter();
		setMessageAndLocation(printWriter, message, location);
		
		printWriter.close();
	}

}

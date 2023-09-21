package com.common;

import java.io.UnsupportedEncodingException;

public class OverflowCheck {

	public static enum LengthB{
		TITLE_LENGTHB(200),
		CONTENT_LENGTHB(4000),
		COMMENT_LENGTHB(200);
		
		private int maxLengthB;
		
		LengthB(int maxLengthB){
			this.maxLengthB = maxLengthB;
		}
	}
	
	
	private OverflowCheck() {}
	
	public static boolean isOverflow(final int bytes, final LengthB lengthB) {
		if(bytes > lengthB.maxLengthB)
			return true;
		
		return false;
	}
	
	public static Integer getBytesUtf8(final String str) {
		try {
			return str.getBytes("utf-8").length;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}
	
}

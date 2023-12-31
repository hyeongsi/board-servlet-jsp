package com.controller;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@SuppressWarnings("serial")
@WebServlet("/imageUploadServlet")
@MultipartConfig(
		maxRequestSize = 1024 * 1024 * 2
)
public class ImageUploadServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        final String uploadDirectory = System.getProperty("catalina.base") + "/webapps/board/images";
        
        final Part part = request.getPart("file");
        final String getFileName = part.getSubmittedFileName();
        final String uuidFileName = UUID.randomUUID().toString();
        final String extentionName = getFileName.substring(getFileName.lastIndexOf("."));
        
        StringBuilder sb = new StringBuilder();
        sb.append(uploadDirectory)
        	.append("/")
        	.append(uuidFileName)
        	.append(extentionName);
        
        part.write(sb.toString());
        
    	final String IMAGE_DOMAIN = "http://localhost:8090/board/images/";
        final String responseUrl = IMAGE_DOMAIN + uuidFileName + extentionName;
        
        // 응답 데이터를 JSON 형식으로 생성
        final String jsonResponse = "{\"url\": \"" + responseUrl + "\"}";

        // 응답 전송
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(jsonResponse);
	}

}

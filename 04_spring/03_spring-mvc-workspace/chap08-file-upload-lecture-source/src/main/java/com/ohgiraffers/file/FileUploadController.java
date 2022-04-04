package com.ohgiraffers.file;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadController {

	@PostMapping("single-file")
	public String singleFileUpload(@RequestParam MultipartFile singleFile, HttpServletRequest request, Model model) {
		
		String singleFileDescription= request.getParameter("singleFileDescription"); //일반 컬럼의 값
		
		System.out.println("singleFile : " + singleFile);
		System.out.println("singleFile : " + singleFileDescription);
		
		return "";
	
 
	}
	
}

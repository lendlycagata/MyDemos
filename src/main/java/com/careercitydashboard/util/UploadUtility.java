package com.careercitydashboard.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public class UploadUtility {
	/* localpath */
	//private static String UPLOADER_FOLDER = "C://things//";

//	 serverpath-dev 
	
	 private static String UPLOADER_FOLDER = "//opt/tomcat/webapps/ImageRepo//";
	 

	public String singleFileUpload(MultipartFile file) {
		String url = "";
		
//		if (file.isEmpty()) {
//			redirectAttributes.addFlashAttribute("warning", "Please Select a file to upload");
//			return "Please Select a file to upload";
//		}
		
		try {
			byte[] bytes = file.getBytes();
			Path path = Paths.get(UPLOADER_FOLDER + file.getOriginalFilename());
			Files.write(path, bytes);

			url = "https://35.185.222.6/ImageRepo/" + file.getOriginalFilename();
			return url;
		} catch (IOException e) {
			e.printStackTrace();
			return "";
		}
	}
}
